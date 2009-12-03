package com.masprop.cluster1.privateclasses.tests;

import com.masprop.cluster1.privateclasses.model.GameModeType;
import com.masprop.cluster1.privateclasses.model.Mastermind;
import com.masprop.cluster1.privateclasses.model.MastermindStatus;
import com.masprop.cluster1.privateclasses.model.Scores;
import com.masprop.cluster1.privateclasses.model.diskmanager.MastermindScoreFileParser;
import com.masprop.cluster1.shared.model.GameLevelType;

/**
 * This class is testing classes Mastermind and Game
 *
 * @author Milan Stanic
 *
 */

public class MastermindTest {

    /**
     * Class for testing
     */
    public Mastermind mastermind;

    /**
     * @param args
     */
    public static void main(String[] args) {

        MastermindTest test = new MastermindTest();

        /**
         * Difficulty level of game which we want to generate
         */
        GameLevelType gameLevelType = GameLevelType.DIFFICULT;
        
        GameModeType gameModeType = GameModeType.PLAYERvsCOMP;

        /**
         * Creating new mastermind game
         */
        test.mastermind = new Mastermind(gameLevelType, gameModeType);

        /**
         * Get the mastermind status from mastermind
         */
        MastermindStatus status = test.mastermind.getMastermindStatus();
        String result;

        /**
         * Checking is mastermind status generated successful
         */
        if(status != null){
            result = "SUCCESS";
        }else{
            result = "FAIL";
        }
        System.out.println("Result of getting mastermind status: " + result);

        /**
         * Put mastermind status in mastermind
         */
        test.mastermind.setMastermindStatus(new MastermindStatus());



        /**
         * Changing game level type and set the level type in mastermind
         */
        test.mastermind.setGameLevelType(GameLevelType.MEDIUM);

        /**
         * Checking is difficulty level correctly changed in mastermind
         */
        gameLevelType = test.mastermind.getGameLevelType();
        if(gameLevelType == GameLevelType.MEDIUM){
            result = "SUCCESS";
        }else{
            result = "FAIL";
        }
        System.out.println("Result of changing difficulty level: " + result);

        /**
         * Changing game mose type and set the mose type in mastermind
         */
        test.mastermind.setGameModeType(GameModeType.PLAYERvsPLAYER);

        /**
         * Checking is mode type correctly changed in mastermind
         */
        gameModeType = test.mastermind.getGameModeType();
        if(gameModeType == GameModeType.PLAYERvsPLAYER){
            result = "SUCCESS";
        }else{
            result = "FAIL";
        }
        System.out.println("Result of changing mode type: " + result);
        
        /**
         * Get the mastermind file parser from mastermind
         */
        MastermindScoreFileParser parser = test.mastermind.getParser();

        /**
         * Checking is mastermind file parser generated successful
         */
        if(parser != null){
            result = "SUCCESS";
        }else{
            result = "FAIL";
        }
        System.out.println("Result of getting mastermind file parser: " + result);

        /**
         * Put mastermind file parser in mastermind
         */
        test.mastermind.setParser(new MastermindScoreFileParser());

        /**
         * Get the scores from mastermind
         */
        Scores scores = test.mastermind.getScores();

        /**
         * Checking is mastermind scores generated successful
        */
        if(scores != null){
            result = "SUCCESS";
        }else{
            result = "FAIL";
        }
        System.out.println("Result of getting mastermind scores: " + result);

        /**
         * Put scores in mastermind
         */
        test.mastermind.setScores(new Scores(parser, gameLevelType));
    }

}
