package com.masprop.cluster1.privateclasses.tests;

import com.masprop.cluster1.privateclasses.controller.GameSolverMastermind;
import com.masprop.cluster1.privateclasses.model.GameModeType;
import com.masprop.cluster1.privateclasses.model.Mastermind;
import com.masprop.cluster1.privateclasses.model.MastermindStatus;
import com.masprop.cluster1.shared.model.GameLevelType;

/**
 * Class for testing the algorithm that will solve the game
 *
 * @author Nick Veenhof
 */
public class MasterMindAlgorithmTest {

    public void run() {
        /* NO CHANGABLE VALUES HERE SINCE THIS IS NOT FINISHED YET
         *
         * Class for testing
         *
         * Here we are testing get and set methods and function for creating new game,
         * function for solving game.
         * We doesn't test here function for saving and open last save game,
         * because it's testing in MastermindSaveGame
         */

        Mastermind mastermind = null;

        /**
         * Difficulty level of game which we want to generate
         */
        GameLevelType gameLevelType = GameLevelType.DIFFICULT;
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
        int[] value = { 1, 2, 3, 4 };
        status.setValue(value);

        /**
         * Put mastermind status in mastermind
         */
        mastermind.setMastermindStatus(status);
        System.out.println(mastermind.toString("|"));

        /**
         * Continue our test with solving the game
         */
        System.out.println("Solved the game");
        GameSolverMastermind GameSolver = new GameSolverMastermind();
        GameSolver.solveMastermind(mastermind);
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