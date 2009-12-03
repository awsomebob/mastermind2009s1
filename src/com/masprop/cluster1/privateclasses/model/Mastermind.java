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
        return this.toString("|");
    }

   /**
     *
     * @param separator
     * @return
     */
    public String toString(String separator) {
        GameLevelType gameleveltype = super.getGameLevelType();
        int[] value = this.mastermindStatus.getValue();
        String valueString = intarrayToString(value, ",");
        String output = gameleveltype + separator + valueString + separator;
        output += System.getProperty("line.separator");

        MatrixMastermind matrix = this.mastermindStatus.getMatrixMastermind();
        Cell[][] matrixcell = matrix.getMatrix();
        for (int i = 0; i < matrixcell.length; i++) {

            // resize our value array
            if (matrixcell[i] != null) {
                value = new int[matrixcell[i].length];

                for (int j = 0; j < matrixcell[i].length; j++) {
                    value[j] = matrixcell[i][j].getCurrentValue();
                }
                valueString = intarrayToString(value, "|");
                output += valueString;
                output += System.getProperty("line.separator");
            }

        }
        return output;
    }

    /**
     *
     * @param a
     * @param separator
     * @return
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
