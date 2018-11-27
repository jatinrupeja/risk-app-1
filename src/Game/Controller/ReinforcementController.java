package Game.Controller;

import java.util.*;
import Game.Model.CountryData;
import Game.Model.ContinentData;
import Game.Risk.DataHolder;
import Game.Model.Player;

/**
 * This controller class is for the reinforcement phase
 *
 * @author r-naik
 * @version 1.2.0
 */
public class ReinforcementController {
	public ReinforcementController() {
	}

	private DataHolder holder = DataHolder.getInstance();

	/**
	 * This function calculates the armies a player avails in each reinforcement
	 * phase
	 *
	 * @param player Player Object.
	 * @return new armies The number of armies available for reinforcement
	 *         phase.
	 */
	public int calculateReinforcementArmies(Player player) {

		// retrieving the player number whose turn is goin on
		System.out.println("Calculating armies for player " + player.getName());
		int newarmies;

		// retrieving the continents conquered by the player
		HashMap<String, Integer> countriesConquered = player
				.getCountriesConquered();
		System.out.println("The countries conquered by " + player.getName()
				+ " is " + countriesConquered.keySet());

		// get armies due to conquering whole continent
		int listSizeOfCountriesConquered;
		int continentAddedArmies = 0;
		for (ContinentData continentData : holder.getContinentDataList()) {// get
																			// data
																			// for
																			// every
																			// continent
			String continentName = continentData.getName();
			List<CountryData> countriesContinent = holder
					.countCountriesInContinent(continentName);// get COuntries of Continent
			int countrySize = countriesContinent.size();// size of the no of countries in continent
			listSizeOfCountriesConquered = 0;
			for (CountryData countryData : countriesContinent) {/// countires in continent loop
				Iterator itForCountriesConquered = countriesConquered.entrySet()
						.iterator();// iterator for countries conqureeed by
									// player
				while (itForCountriesConquered.hasNext()) {
					Map.Entry pair = (Map.Entry) itForCountriesConquered.next();
					String countryName = (String) pair.getKey();
					if (countryData.getName().equalsIgnoreCase(countryName)) {
						listSizeOfCountriesConquered++;
					}
				}
			}
			if (listSizeOfCountriesConquered == countrySize) {
				continentAddedArmies += continentData.getControlValue();
			}
		}

		System.out.println("The number of armies added due to conquering whole continent is: "+ continentAddedArmies);

		// number of countries owned divided by 3 and rounded down if the player
		// owns more than 9 territores otherwise 3 territories
		if (countriesConquered.size() < 9) {
			newarmies = 3 + continentAddedArmies;
		} else {
			int armies = Math.floorDiv((countriesConquered.size()), 3);
			newarmies = armies + continentAddedArmies;
		}

		System.out.println(
				"The number of armies available for reinforcement phase is "
						+ newarmies);
		// holder.setPlayersArmiesList(playerTurn, newarmies);

		return newarmies;
	}

	/**
	 * This function is for adding the calculated reinforcement armies to the
	 * countries as part of the phase
	 *
	 * @param player
	 *            the player whose turn is going on
	 * @param noOfArmies
	 *            number of armies allowed to the player for reinforcement phase
	 */
	public void updateArmiesInCountries(Player player, int noOfArmies) {

		// retrieving the continents conquered by the player
		HashMap<String, Integer> countriesConquered = player
				.getCountriesConquered();
		Scanner scanner = new Scanner(System.in);
		String countryNameForAddArmies = null;
		int numberOfArmies = noOfArmies;
		int newArmiesToAdd = 0;
		int playerType = player.getType();

		while (numberOfArmies > 0) {

			// check if player is human or computer. 0 is human and 1 is
			// computer
			if (playerType == 0) {

				while (!countriesConquered.keySet()
						.contains(countryNameForAddArmies)) {
					System.out.println(
							"\nEnter the country name to which you want to add armies: ");
					countryNameForAddArmies = scanner.nextLine();
				}
				System.out.println("Enter the number of armies to be added: ");
				newArmiesToAdd = Integer.parseInt(scanner.nextLine());
				while (newArmiesToAdd > numberOfArmies) {
					System.out.println(
							"Enter value less than the allowed armies i.e less than or equal to "
									+ numberOfArmies);
					newArmiesToAdd = Integer.parseInt(scanner.nextLine());
				}
			} else {
				// generating random country name from conquered country list
				while (!countriesConquered.keySet()
						.contains(countryNameForAddArmies)) {
					Random generator = new Random();
					Object[] values = countriesConquered.keySet().toArray();
					countryNameForAddArmies = (String) values[generator
							.nextInt(values.length)];
					System.out.println("\nThe country name to which "
							+ player.getName() + " will add armies: "
							+ countryNameForAddArmies);
				}
				// generating armies to add to the country
				Random generator = new Random();
				newArmiesToAdd = generator.nextInt(numberOfArmies);
				System.out
						.println("The armies to be added is " + newArmiesToAdd);
			}

			// update the number of armies in the selected conquered country
			Iterator itForCountriesConquered = countriesConquered.entrySet()
					.iterator();// iterator for countries conqureed by player
			while (itForCountriesConquered.hasNext()) {
				Map.Entry pair = (Map.Entry) itForCountriesConquered.next();
				String countryName = (String) pair.getKey();
				int armies = (int) pair.getValue();
				// System.out.println("Before the value is updated: no of
				// armies: " + pair.getValue() + " of the country " +
				// pair.getKey());
				if (countryName.equalsIgnoreCase(countryNameForAddArmies)) {
					pair.setValue(armies + newArmiesToAdd);
				}
				// System.out.println("The updated armies is " + pair.getValue()
				// + " of the country " + pair.getKey());
			}
			player.setCountriesConquered(countriesConquered);
			// The updated conquered countries list
			System.out.println("The updated counquered country list");
			for (Map.Entry<String, Integer> country : player
					.getCountriesConquered().entrySet()) {
				System.out.print(
						country.getKey() + " - " + country.getValue() + " | ");
			}
			numberOfArmies -= newArmiesToAdd;
			countryNameForAddArmies = null;
		}

		System.out.println(
				"The end of reinforcement phase of " + player.getName());
	}

}
