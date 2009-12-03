package com.masprop.cluster1.privateclasses.model;

/**
 * Class represents game with a current game and all necessary
 * information for generating, solving
 * or for handling the score of this game.
 *
 * @see MastermindStatus
 *
 * @author Milan Stanic
 */

import com.masprop.cluster1.shared.model.GameLevelType;


public class Mastermind extends Game {

    /**
     * pile will describe this class
     */
    private MastermindStatus mastermindStatus;

    /**
     * Constructor
     *
     * @param gameLevelType game difficulty level
     */
    public Mastermind(GameLevelType gameLevelType, GameModeType gameModeType) {
            super(gameLevelType, gameModeType);
            mastermindStatus = new MastermindStatus();
    }

    /**
     *
     * @return mastermindStaus
     */
    public MastermindStatus getMastermindStatus() {
        return mastermindStatus;
    }

    /**
     *
     * @param mastermindStatus status of current game
     */
    public void setMastermindStatus(MastermindStatus mastermindStatus) {
        this.mastermindStatus = mastermindStatus;
    }

    /**
     * General toString method. Can be used for debugging
     */
    @Override
    public String toString() {
        return "Test";
    }

    /**
     *
     * @param separator
     * @return
     */
    public String toString(String separator) {
        String output ="LEVEL|4,3,4,3|\n";
        output += "0|1|2|3|\n";
        output += "1|2|4|5|\n";
        output += "4|4|2|1|\n";
        output += "7|2|1|0|\n";
        output += "6|1|0|4|\n";
        return output;
    }
}
