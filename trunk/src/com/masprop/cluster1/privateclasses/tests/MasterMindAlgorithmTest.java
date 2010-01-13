package com.masprop.cluster1.privateclasses.tests;

import com.masprop.cluster1.privateclasses.model.GameModeType;
import com.masprop.cluster1.privateclasses.model.Mastermind;
import com.masprop.cluster1.privateclasses.model.MastermindAlgorithm;
import com.masprop.cluster1.privateclasses.model.MastermindStatus;
import com.masprop.cluster1.shared.model.GameLevelType;

/**
 * Class for testing the algorithm that will solve the game
 *
 * @author Nick Veenhof
 */
public class MasterMindAlgorithmTest {

    public void run() {
        /*
         * Class for testing
         *
         * Here we are testing get and set methods and function for creating new game,
         * function for solving game.
         * We doesn't test here function for saving and open last save game,
         * because it's testing in MastermindSaveGame
         */
        int[] value = { 4, 3, 2, 3 };

        /* DO NOT CHANGE ANYTHING BELOW THIS LINE */

        Mastermind mastermind = null;

        /**
         * Difficulty level of game which we want to generate
         */
        GameLevelType gameLevelType = GameLevelType.MEDIUM;
        GameModeType gameModeType = GameModeType.PLAYERvsCOMP;

        /**
         * Creating new mastermind game
         */
        mastermind = new Mastermind(gameLevelType, gameModeType);

        /**
         * Get the mastermind status from mastermind
         */
        MastermindStatus status = mastermind.getMastermindStatus();

        /**
         * Set our color value. Integers are mapped to a certain color in the
         * GUI
         */
        status.setValue(value);

        /**
         * Put mastermind status in mastermind
         */
        mastermind.setMastermindStatus(status);
        System.out.println(mastermind.toString("|"));

        /**
         * Continue our test with solving the game
         */
        System.out.println("Solving the game");
        // Print out the result we would like to guess
        System.out.println("Code to find" + status.getValue()[0] + "" +
        status.getValue()[1] + "" + status.getValue()[2] + "" +
        status.getValue()[3]);

        //run our mastermind game trough the solver/guesser.
        //TODO: add parameters to ask for a new guess or to solve the whole game
        MastermindAlgorithm algorithm = new MastermindAlgorithm(status, gameLevelType);
        algorithm.solveMastermind();

        //set our solved status back
        mastermind.setMastermindStatus(status);

        //print for checking what he did
        System.out.println(mastermind.toString("|"));
    }

    /**
     * @param args
     */
    public static void main(String[] args) {

        MasterMindAlgorithmTest test = new MasterMindAlgorithmTest();
        test.run();


    }

}
