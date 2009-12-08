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
import com.masprop.cluster1.shared.model.Cell;

public class Mastermind extends Game {

    /**
     * Mastermind game status
     * 
     * @see MastermindStatus
     */
    private MastermindStatus mastermindStatus;

    /**
     * Constructor calls game constructor and creates new mastermind game status
     *
     * @param gameLevelType game difficulty level
     */
    public Mastermind(GameLevelType gameLevelType, GameModeType gameModeType) {
        super(gameLevelType, gameModeType);
        mastermindStatus = new MastermindStatus();
    }

    /**
     * Gets the mastermind status
     *
     * @return mastermindStaus
     */
    public MastermindStatus getMastermindStatus() {
        return mastermindStatus;
    }

    /**
     * Sets the mastermind status
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
        return this.toString("|");
    }

    /**
     * toString function used for writing to a csv or other kind of file that uses any kind of separator
     * Added when trying to save the game objects
     * @author Nick Veenhof
     * @param separator separator used to join the values
     * @return String of a mastermind object
     * @see GameLevelType
     * @see GameModeType
     * @see MatrixMastermind
     * @see Cell
     */
    public String toString(String separator) {
        GameLevelType gameLevelType = super.getGameLevelType();
        GameModeType gameModeType = super.getGameModeType();
        int[] value = this.mastermindStatus.getValue();
        String valueString = intarrayToString(value, ",");
        String currentRowString = String.valueOf(mastermindStatus.getCurrentRow());
        String output = gameLevelType + separator + gameModeType + separator + valueString + separator + currentRowString;
        output += System.getProperty("line.separator");
        MatrixMastermind matrix = this.mastermindStatus.getMatrixMastermind();
        Cell[][] matrixcell = matrix.getMatrix();

        for (int i = 0; i < matrixcell.length; i++) {
            for (int j = 0; j < matrixcell[i].length; j++) {
                // everything except last value
                if ((matrixcell[i].length - j) != 1) {
                    output += matrixcell[i][j].getCurrentValue() + separator;
                } else {
                    output += matrixcell[i][j].getCurrentValue();
                }
            }
            output += System.getProperty("line.separator");
        }
        return output;
    }

    /**
     * This method converts array of integer to string
     *
     * @param a
     * @param separator
     * @return converted array of integer to string
     */
    public static String intarrayToString(int[] a, String separator) {
        StringBuffer result = new StringBuffer();
        if (a.length > 0) {
            result.append(a[0]);
            for (int i = 1; i < a.length; i++) {
                result.append(separator);
                result.append(a[i]);
            }
        }
        return result.toString();
    }
}
