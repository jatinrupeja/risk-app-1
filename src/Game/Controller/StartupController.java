package Game.Controller;

import Game.Model.CardData;
import Game.Model.ContinentData;
import Game.Model.CountryData;
import Game.Model.Player;
import Game.Risk.DataHolder;

import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

/**
 * The controller for the startup phase that takes place between game settings
 * and game play.
 * 
 * @author ndkcha, Jay
 * @version 1.2.0
 */
public class StartupController {

	/** a file that holds the information about the map */
	private File mapFile;
	/** the holder class for the data in the game play */
	private DataHolder holder = DataHolder.getInstance();

	/**
	 * A constructor that initializes the default values.
	 * 
	 * @param mapFile
	 *            File descriptor of the map file.
	 */
	public StartupController(File mapFile) {
		this.mapFile = mapFile;
	}

	/** A blank constructor */
	public StartupController() { }

	/**
	 * Process the game file in order to load the game
	 * @param gameFile file
	 */
	public void processGame(File gameFile) {
		try {
			FileInputStream fileInputStream = new FileInputStream(gameFile);
			ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);

			inputStream = holder.loadTheGameData(inputStream);

			inputStream.close();
			fileInputStream.close();

			this.holder.bmpFile = new File(holder.mapData.imageFilePath);
		} catch (FileNotFoundException e) {
			System.out.println("File not found!");
		} catch (IOException e) {
			System.out.println("Error in initializing stream");
		} catch (ClassNotFoundException e) {
			System.out.println("Error in parsing the data");
		}
	}

	/**
	 * Process the map file and load the data inside the DataHolder object.
	 */
	public void processFiles() {
		try {
			String existingSegment = "";
			Scanner mapScanner = new Scanner(this.mapFile);
			this.holder.mapData.cleanUpMapData();
			List<CountryData> countries = new ArrayList<>();
			this.holder.mapData.mapFilePath = this.mapFile.getAbsolutePath();
			this.holder.mapData.imageFilePath = this.holder.bmpFile.getAbsolutePath();

			while (mapScanner.hasNextLine()) {
				String incoming = mapScanner.nextLine();
				if (incoming.length() == 0)
					continue;
				if (incoming.startsWith("[")) {
					// start a segment
					existingSegment = incoming;
					continue;
				}
				if (existingSegment.equalsIgnoreCase("[map]")) {
					String[] contents = incoming.split("=");
					this.addToMapData(contents[0], contents[1]);
				}
				if (existingSegment.equalsIgnoreCase("[continents]")) {
					ContinentData data = this.addContinent(incoming);
					this.holder.addContinent(data);
				}
				if (existingSegment.equalsIgnoreCase("[territories]")) {
					CountryData data = this.addCountry(incoming);
					countries.add(data);
				}
			}

			this.assignCardsToCountry(countries);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	// change to the unit test

	/**
	 * Assign cards to the countries on the map
	 * @param countries list of countries
	 */
	private void assignCardsToCountry(List<CountryData> countries) {
		int totalCountries = countries.size();
		int assignment[] = new int[3];
		assignment[0] = totalCountries / 3; // infantry
		assignment[1] = totalCountries / 3; // cavalry
		assignment[2] = totalCountries / 3; // artillery
		Random random = new Random();

		for (int i = 0; i < totalCountries; i++) {
			int s = random.nextInt(3);
			if (s == 3)
				s--;

			CountryData data = countries.get(i);
			switch (s) {
				case 0:
					if (assignment[0] == 0) {
						if (assignment[1] != 0) {
							data.setCard(CardData.CARD_TYPE_CAVALRY);
							assignment[1]--;
							if (assignment[1] < 0)
								assignment[1] = 0;
						} else {
							data.setCard(CardData.CARD_TYPE_ARTILLERY);
							assignment[2]--;
							if (assignment[2] < 0)
								assignment[2] = 0;
						}
					} else {
						data.setCard(CardData.CARD_TYPE_INFANTRY);
						assignment[0]--;
					}
					break;
				case 1:
					if (assignment[1] == 0) {
						if (assignment[0] != 0) {
							data.setCard(CardData.CARD_TYPE_INFANTRY);
							assignment[0]--;
							if (assignment[0] < 0)
								assignment[0] = 0;
						} else {
							data.setCard(CardData.CARD_TYPE_ARTILLERY);
							assignment[2]--;
							if (assignment[2] < 0)
								assignment[2] = 0;
						}
					} else {
						data.setCard(CardData.CARD_TYPE_CAVALRY);
						assignment[1]--;
					}
					break;
				case 2:
					if (assignment[2] == 0) {
						if (assignment[1] != 0) {
							data.setCard(CardData.CARD_TYPE_CAVALRY);
							assignment[1]--;
							if (assignment[1] < 0)
								assignment[1] = 0;
						} else {
							data.setCard(CardData.CARD_TYPE_INFANTRY);
							assignment[0]--;
							if (assignment[0] < 0)
								assignment[0] = 0;
						}
					} else {
						data.setCard(CardData.CARD_TYPE_ARTILLERY);
						assignment[2]--;
					}
					break;
			}
			holder.addCountry(data);
		}
	}

	/**
	 * Assign countries to the players. It shuffles the list countries in order
	 * to give a random assignment to the players. It assigns the countries to
	 * the players in round robin fashion.
	 */
	public void assignCountries() {
		List<CountryData> countries = this.holder.getCountryDataList();
		List<Player> p = this.holder.getPlayerList();
		List<Integer> countryIndexes = new ArrayList<>();
		int playersTurn = 0;
		Player[] players = new Player[p.size()];

		for (int i = 0; i < p.size(); i++)
			players[i] = p.get(i);

		for (int i : IntStream.rangeClosed(0, countries.size() - 1).toArray())
			countryIndexes.add(i);

		Collections.shuffle(countryIndexes);

		System.out.println("Total countries: " + countryIndexes.size());

		for (int i : countryIndexes) {
			if (playersTurn == players.length)
				playersTurn = 0;

			players[playersTurn].initializeCountry(countries.get(i).getName());

			playersTurn++;
		}

		for (Player player : this.holder.getPlayerList()) {
			System.out.println(player.getName() + " has "
					+ player.getCountriesConquered().size() + " countries");
		}

		this.holder.updatePlayerList(Arrays.asList(players));
	}

	/**
	 * Assign armies to the initially conquered countries of the players. Based
	 * on number of players in the game, a specific number of armies are
	 * assigned to random countries that the players owns.
	 */
	public void assignArmies() {
		List<Player> players = this.holder.getPlayerList();
		Random random = new Random();
		int noOfArmiesToAssign = this.determineOfInitialArmy(players.size());

		for (int i = 0; i < noOfArmiesToAssign; i++) {
			for (Player player : players) {
				HashMap<String, Integer> countriesConquered = player
						.getCountriesConquered();
				Object[] entries = countriesConquered.keySet().toArray();

				int randomCountryIndex = random.nextInt(entries.length);
				String randomCountry = (String) entries[randomCountryIndex];
				int noOfArmies = countriesConquered.get(randomCountry);

				player.updateCountry(randomCountry, ++noOfArmies);
			}
		}

		this.holder.updatePlayerList(players);

		System.out.println("Initial armies allocation:");
		for (Player player : this.holder.getPlayerList()) {
			System.out.println("\n" + player.getName() + ": ");

			for (Map.Entry<String, Integer> country : player
					.getCountriesConquered().entrySet()) {
				System.out.print(
						country.getKey() + " - " + country.getValue() + " | ");
			}
		}
	}

	/**
	 * Based on number of players, this method determines the number of armies
	 * allowed for the initial game play
	 * 
	 * @param noOfPlayers
	 *            Number of players in the game play
	 * @return number of armies allowed.
	 */
	public int determineOfInitialArmy(int noOfPlayers) {
		return 40 - ((noOfPlayers - 2) * 5);
	}

	/**
	 * Add country inside the DataHolder hashmap
	 * 
	 * @param incoming
	 *            Formatted string from the map file
	 * @return Data object of the country
	 */
	private CountryData addCountry(String incoming) {
		String content[] = incoming.split(",");
		CountryData data = new CountryData(content[0],
				Double.parseDouble(content[1]), Double.parseDouble(content[2]),
				content[3]);
		for (int i = 4; i < content.length; i++) {
			data.addNeighbour(content[i]);
		}
		return data;
	}

	/**
	 * Add continent inside the DataHolder hashmap
	 * 
	 * @param incoming
	 *            Formatted string from the map file
	 * @return Data object of the continent
	 */
	private ContinentData addContinent(String incoming) {
		String[] contents = incoming.split("=");
		return new ContinentData(contents[0], Integer.parseInt(contents[1]));
	}

	/**
	 * Adds the map meta data into the DataHolder hasmap
	 * 
	 * @param field
	 *            Name of the field
	 * @param value
	 *            Value of the corresponding.
	 */
	private void addToMapData(String field, String value) {
		if (field.equalsIgnoreCase("image"))
			this.holder.mapData.imageFileName = value;
		if (field.equalsIgnoreCase("wrap"))
			this.holder.mapData.wrap = value.equalsIgnoreCase("yes");
		if (field.equalsIgnoreCase("scroll"))
			this.holder.mapData.scrollType = value;
		if (field.equalsIgnoreCase("author"))
			this.holder.mapData.author = value;
		if (field.equalsIgnoreCase("warn"))
			this.holder.mapData.warn = value.equalsIgnoreCase("yes");
	}
}
