package Game.Model;

import java.io.Serializable;
import java.util.Observable;

/**
 * This class will control the phases of gameplay.
 * 
 * @author ndkcha
 * @version 1.2.0
 */
public class PhaseData extends Observable implements Serializable {
    public static final String CHANGE_TURN = "change:turn";
    public static final String CHANGE_PHASE = "change:phase";
    public static final String END_GAME = "end:game";

    public static final int CARD_EXCHANGE_PHASE = 0;
    public static final int REINFORCEMENT_PHASE = 1;
    public static final int ATTACK_PHASE = 2;
    public static final int FORTIFICATION_PHASE = 3;

    private int currentPhase;
    private int playerTurn;
    private int totalPlayers;

    /** Switch the control to the next player */
    private void nextPlayer() {
        this.playerTurn++;
        if (this.playerTurn == this.totalPlayers)
            this.playerTurn = 0;
    }

    /** Initializes the new instance of the class. */
    public PhaseData() {
        this.currentPhase = -1 ;
        this.playerTurn = 0;
        this.totalPlayers = 0;
    }

    /**
     * Set total number of players
     * @param totalPlayers number players playing the game.
     */
    public void setTotalPlayers(int totalPlayers) {
        this.totalPlayers = totalPlayers;
    }

    /** Return the index of the current phase
     * @return currentPhase Current Phase
     */
    public int getCurrentPhase() {
        return currentPhase;
    }

    /** Returns the index of the active player 
     * 
     * @return playerTurn Current player.
     */
    public int getPlayerTurn() {
        return playerTurn;
    }

    /** Changes player turn */
    public void changeTurn() {
        this.nextPlayer();
        this.setChanged();
        this.notifyObservers(CHANGE_TURN);
    }

    /**
     * Changes the phases in each turn.
     * It automatically changes the player turn
     */
    public void changePhase() {
        if (this.currentPhase == 3) {
            this.nextPlayer();
            this.currentPhase = -1;
        }
        this.currentPhase++;
        this.setChanged();
        this.notifyObservers(CHANGE_PHASE);
    }

    /**
     * Notifies end of the game
     */
    public void forceEnd() {
        this.setChanged();
        this.notifyObservers(END_GAME);
    }
    
}
