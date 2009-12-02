package com.masprop.cluster1.privateclasses.tests;

import com.masprop.cluster1.privateclasses.model.Mastermind;
import com.masprop.cluster1.privateclasses.model.MastermindStatus;
import com.masprop.cluster1.privateclasses.model.Scores;
import com.masprop.cluster1.privateclasses.model.diskmanager.MastermindScoreFileParser;
import com.masprop.cluster1.shared.model.GameLevelType;

/**
 *
 * @author nick
 * Class for testing the algorithm that will solve the game
 */
public class MasterMindAlgorithmTest {
    /**
     * Class for testing
     */
    public Mastermind mastermind;

    /**
     * @param args
     */
    public static void main(String[] args) {

        MasterMindAlgorithmTest test = new MasterMindAlgorithmTest();

        /**
         * Difficulty level of game which we want to generate
         */
        GameLevelType gameLevelType = GameLevelType.DIFFICULT;

        /**
         * Creating new mastermind game
         */
        test.mastermind = new Mastermind(gameLevelType);


        /**
         * Get the mastermind status from mastermind
         */
        MastermindStatus status = test.mastermind.getMastermindStatus();
        /**
         * Set our color value. Integers are mapped to a certain color in the GUI
         */
        int[] value = {1,2,3,4};
        status.setValue(value);


        /**
         * Put mastermind status in mastermind
         */
        test.mastermind.setMastermindStatus(status);


        /**
         * Get the mastermind file parser from mastermind
         */
        MastermindScoreFileParser parser = test.mastermind.getParser();

        /**
         * Put mastermind file parser in mastermind
         */
        test.mastermind.setParser(new MastermindScoreFileParser());

        /**
         * Get the scores from mastermind
         */
        Scores scores = test.mastermind.getScores();



    }

}
