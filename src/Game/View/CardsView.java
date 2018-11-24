package Game.View;

import Game.Model.CardData;
import Game.Model.PhaseData;
import Game.Model.Player;
import Game.Risk.DataHolder;

import java.awt.event.ActionEvent;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import javax.swing.*;

/**
 * This class is for card view with observable pattern.
 * 
 * @author Jay, ndkcha
 * @version 1.2.0
 */
public class CardsView implements Observer {

    private DataHolder holder = DataHolder.getInstance();
    private JButton btnExchange = new JButton();
    private JPanel panelCard = new JPanel();
    private JList<String> listCard = new JList<>();
    private DefaultListModel<String> listModelCards = new DefaultListModel<>();

    /**
     * Initialize the card view
     */
    CardsView() {
        JScrollPane jScrollPane1 = new JScrollPane();
        JLabel labelCardTitle = new JLabel();

        labelCardTitle.setText("Card");
        listCard.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        btnExchange.setText("Exchange");
        jScrollPane1.setViewportView(listCard);

        javax.swing.GroupLayout Card_panelLayout = new javax.swing.GroupLayout(panelCard);
        panelCard.setLayout(Card_panelLayout);
        Card_panelLayout.setHorizontalGroup(
            Card_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(Card_panelLayout.createSequentialGroup()
                    .addGroup(Card_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(Card_panelLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(Card_panelLayout.createSequentialGroup()
                            .addGap(71, 71, 71)
                            .addComponent(btnExchange)))
                    .addGap(0, 27, Short.MAX_VALUE))
                .addGroup(Card_panelLayout.createSequentialGroup()
                    .addGap(94, 94, 94)
                    .addComponent(labelCardTitle)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Card_panelLayout.setVerticalGroup(
            Card_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(Card_panelLayout.createSequentialGroup()
                    .addComponent(labelCardTitle)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnExchange))
        );

        setVisibilityOfTheView(false);
        this.initializeListeners();
    }

    /**
     * Initialize the action listeners.
     */
    private void initializeListeners() {
        btnExchange.addActionListener((ActionEvent e) -> {
            this.exchangeCard();
        });
    }

    /** exchange the card */
    private void exchangeCard() {
        int[] selected = listCard.getSelectedIndices();
        Player player = holder.getActivePlayer();

        if (selected.length != 3)
            return;

        String[] selectedCards = new String[3];

        for (int i = 0; i < selected.length; i++) {
            selectedCards[i] = player.getCards().get(i);
        }

        if ((selectedCards[0].equalsIgnoreCase(selectedCards[1]) && selectedCards[1].equalsIgnoreCase(selectedCards[2]))) {
            player.removeSimilarThreeCards(selectedCards[0]);
        } else if (!selectedCards[0].equalsIgnoreCase(selectedCards[1]) && !selectedCards[1].equalsIgnoreCase(selectedCards[2])
            && !selectedCards[0].equalsIgnoreCase(selectedCards[2])) {
            player.removeDistinctCards();
        }

        player.cardHasBeenUsed();
        holder.updatePlayer(player);

        holder.sendGameLog(player.getName() + ": Cards have been exchanged. " + (player.getCardsUsedCount()*5) + " armies");

        holder.changePhases();
    }

    /**
     * Shows/hides the entire view
     * @param visibility true if it is to be shown
     */
    private void setVisibilityOfTheView(boolean visibility) {
        listCard.setEnabled(visibility);
        btnExchange.setVisible(visibility);
    }

    /**
     * Return Cards Panel for main risk view.
     *
     * @return panelCard Panel for Cards View.
     */

    public JPanel getPanel() {
        return this.panelCard;
    }


    public void automateCardPhase() {
        Player player = holder.getActivePlayer();

        if (player.haveThreeSameTypeCards()) {
            if (player.haveThreeArtilleryCards()) {
                player.removeSimilarThreeCards(CardData.CARD_TYPE_ARTILLERY);
                player.cardHasBeenUsed();
            } else if (player.haveThreeCavalryCards()) {
                player.removeSimilarThreeCards(CardData.CARD_TYPE_CAVALRY);
                player.cardHasBeenUsed();
            } else if (player.haveThreeInfantryCards()) {
                player.removeSimilarThreeCards(CardData.CARD_TYPE_INFANTRY);
                player.cardHasBeenUsed();
            }
            holder.sendGameLog(player.getName() + ": Cards have been exchanged. " + (player.getCardsUsedCount()*5) + " armies");
        } else if (player.haveDistinctCards()) {
            player.removeDistinctCards();
            player.cardHasBeenUsed();
            holder.sendGameLog(player.getName() + ": Cards have been exchanged. " + (player.getCardsUsedCount()*5) + " armies");
        }

        holder.updatePlayer(player);
    }

    /**
     * Initializes the list for the card phase.
     */
    private void setupCardPhase() {
        Player player = holder.getActivePlayer();
        listModelCards.removeAllElements();

        if (player.getType() == 1) {
            if (player.canAddMoreCards()) {
                holder.changePhases();
                return;
            }
            this.automateCardPhase();
            holder.changePhases();
            return;
        }

        List<String> cards = player.getCards();
        if (cards.size() == 0) {
            setVisibilityOfTheView(false);
            holder.changePhases();
            return;
        }

        setVisibilityOfTheView(true);

        for (String card : cards) {
            listModelCards.addElement(card);
        }

        listCard.setModel(listModelCards);
    }

    /**
     * Displays all the cards in view
     */
    private void displayAllTheCards() {
        Player player = holder.getActivePlayer();
        listModelCards.removeAllElements();

        List<String> cards = player.getCards();
        for (String card : cards) {
            listModelCards.addElement(card);
        }

        listCard.setModel(listModelCards);
    }

    @Override
    public void update(Observable o, Object arg) {
        setVisibilityOfTheView(false);
        // Add the data from CardController to manipulate card exchange.
        if ((arg instanceof String) && (((String) arg).equalsIgnoreCase(PhaseData.CHANGE_PHASE)) &&
            (holder.getCurrentPhase() == PhaseData.CARD_EXCHANGE_PHASE))
            setupCardPhase();
        else
            this.displayAllTheCards();
    }

}
