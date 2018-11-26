/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game.Model;

/**
 * Interface for the types of player strategies
 * @author r-naik
 */
public interface PlayerStrategy {
    
    /**
     * This method implements the reinforcement phase 
     * @param armiesToAllocate number of armies to allocate during the phase
     * @param country country name to which the armies to be added
     * @return message of successful allocation
     */
    String reinforcementPhase(int armiesToAllocate, String country);
    
    /**
     * This method implements attack
     * @return number of armies to be moved
     */
    int attackPhase();
    
    /**
     * This method is to move armies from one country to another
     * @param armiesToMove number of armies to move
     */
    void moveArmiesAfterAttack(int armiesToMove);
    
    /**
     * This method implements the fortification phase
     * @param sourceCountry source country name from which armies to be moved
     * @param targetCountry destination country name to which armies to be moved
     * @param noOfArmies number of armies to be moved
     * @return message of successful fortification
     */
    String fortificationPhase(String sourceCountry, String targetCountry, int noOfArmies);
}
