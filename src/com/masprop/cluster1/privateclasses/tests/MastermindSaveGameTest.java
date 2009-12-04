package com.masprop.cluster1.privateclasses.tests;

import com.masprop.cluster1.privateclasses.model.GameModeType;
import com.masprop.cluster1.privateclasses.model.Mastermind;
import com.masprop.cluster1.privateclasses.model.MastermindStatus;
import com.masprop.cluster1.privateclasses.model.MatrixMastermind;
import com.masprop.cluster1.privateclasses.model.diskmanager.MastermindGameFileParser;
import com.masprop.cluster1.shared.model.GameLevelType;

/**
 * Test for saving and loading a game, and changing a value in the matrix
 *
 * @author Nick Veenhof
 *
 */
public class MastermindSaveGameTest {
    public void run() {
        /*
         * Changeable variables When wanting other output, please change these
         * values
         */
        // Used for writing a new file for our game (meaning that we will load
        // in an empty file)
        boolean writenewfile = false;

        // Which GameModeType do you want to use?
        // Possible values
        // GameModeType.COMPvsPLAYER
        // GameModeType.PLAYERvsCOMP
        // GameModeType.PLAYERvsPLAYER
        GameModeType mode = GameModeType.COMPvsPLAYER;

        // Which GameLevelType do you want to use?
        // possible values
        // GameLevelType.DIFFICULT;
        // GameLevelType.MEDIUM;
        // GameLevelType.EASY;
        GameLevelType level = GameLevelType.DIFFICULT;

        /*
         * parameters for changing value in matrix
         *
         * matrix_y : which line matrix_x : which row value : which colorcode
         * (currently any int value is ok for testing)
         */
        int matrix_y = 10;
        int matrix_x = 3;
        int value = 4;

        // -------------------------------------------------------------------
        // Do not modify below this line please
        // -------------------------------------------------------------------

        // Initialize our game file with empty files
        MastermindGameFileParser parser = new MastermindGameFileParser(
                writenewfile);

        // read the file - USED FOR LOADING A GAME
        // also sets the status to null since we want to load our new status
        // into that
        Mastermind mastermind = parser.getMastermindFromFile();
        MastermindStatus status = null;

        /*
         * load our game from the file and check if our file is correctly
         * formatted
         */
        if (mastermind != null) {

            status = mastermind.getMastermindStatus();
        } else {
            // create a new game if old one was not found
            mastermind = new Mastermind(level, mode);
            status = new MastermindStatus();

            // these values are not changable since our gui will only have this
            // grid
            int width = 4;
            int height = 8;
            status.setMatrixMastermind(new MatrixMastermind(width, height));
            mastermind.setMastermindStatus(status);
        }

        // Debug information
        System.out.println("Our initial game");
        System.out.println(mastermind.toString("|"));

        /*
         * change matrix value on defined coordinates please note that i is
         * horizontal position and j is vertical position
         */
        mastermind.getMastermindStatus().getMatrixMastermind().setCellValue(
                matrix_y, matrix_x, value);

        // write our game to the file - USED FOR SAVING A GAME
        parser.update(mastermind);

        // read the file with the new values
        mastermind = parser.getMastermindFromFile();

        System.out.println("Our saved game");
        System.out.println(mastermind.toString("|"));
    }

    /**
     * Main constructor for the Save - Load Game Test
     *
     * @param args
     */
    public static void main(String[] args) {
        MastermindSaveGameTest test = new MastermindSaveGameTest();
        test.run();
    }
}
