package com.masprop.cluster1.privateclasses.tests;

import com.masprop.cluster1.privateclasses.model.GameModeType;
import com.masprop.cluster1.privateclasses.model.Mastermind;
import com.masprop.cluster1.privateclasses.model.MastermindStatus;
import com.masprop.cluster1.privateclasses.model.Scores;
import com.masprop.cluster1.privateclasses.model.diskmanager.MastermindGameFileParser;
import com.masprop.cluster1.privateclasses.model.diskmanager.MastermindScoreFileParser;
import com.masprop.cluster1.shared.model.GameLevelType;

/**
 * This class is testing classes Mastermind and Game
 *
 * @author Milan Stanic
 *
 */

public class MastermindTest {

    public void run(){
    	/* Changeable variables
         * When wanting other output, please change these values
         */
    	
		/*
	     * Class for testing
	     */
	    Mastermind mastermind;
	    
	    //Which GameLevelType do you want to use?
        //possible values
        //GameLevelType.DIFFICULT;
        //GameLevelType.MEDIUM;
        //GameLevelType.EASY;
        GameLevelType gameLevelType = GameLevelType.DIFFICULT;
        
        //Which GameLevelType do you want to use?
        //possible values
        //GameLevelType.DIFFICULT;
        //GameLevelType.MEDIUM;
        //GameLevelType.EASY
        GameLevelType newGameLevelType = GameLevelType.MEDIUM;
        
        //Which GameModeType do you want to use?
        //Possible values
        //GameModeType.COMPvsPLAYER
        //GameModeType.PLAYERvsCOMP
        //GameModeType.PLAYERvsPLAYER
        GameModeType gameModeType = GameModeType.PLAYERvsCOMP;
        
        //Which GameModeType do you want to use?
        //Possible values
        //GameModeType.COMPvsPLAYER
        //GameModeType.PLAYERvsCOMP
        //GameModeType.PLAYERvsPLAYER
        GameModeType newGameModeType = GameModeType.PLAYERvsPLAYER;
        
        //-------------------------------------------------------------------
        //Do not modify below this line please
        //-------------------------------------------------------------------

        /*
         * Creating new mastermind game
         */
        mastermind = new Mastermind(gameLevelType, gameModeType);

        /*
         * Get the mastermind status from mastermind
         */
        MastermindStatus status = mastermind.getMastermindStatus();
        String result;

        /*
         * Checking is mastermind status generated successful
         */
        if(status != null){
            result = "SUCCESS";
        }else{
            result = "FAIL";
        }
        System.out.println("Result of getting mastermind status: " + result);

        /*
         * Put mastermind status in mastermind
         */
        mastermind.setMastermindStatus(new MastermindStatus());



        /*
         * Changing game level type and set the level type in mastermind
         */
        mastermind.setGameLevelType(newGameLevelType);

        /*
         * Checking is difficulty level correctly changed in mastermind
         */
        gameLevelType = mastermind.getGameLevelType();
        if(gameLevelType == newGameLevelType){
            result = "SUCCESS";
        }else{
            result = "FAIL";
        }
        System.out.println("Result of changing difficulty level: " + result);

        /*
         * Changing game mose type and set the mose type in mastermind
         */
        mastermind.setGameModeType(newGameModeType);

        /*
         * Checking is mode type correctly changed in mastermind
         */
        gameModeType = mastermind.getGameModeType();
        if(gameModeType == newGameModeType){
            result = "SUCCESS";
        }else{
            result = "FAIL";
        }
        System.out.println("Result of changing mode type: " + result);
        
        /*
         * Get the mastermind score file parser from mastermind
         */
        MastermindScoreFileParser parser = mastermind.getScoreParser();

        /*
         * Checking is mastermind file parser generated successful
         */
        if(parser != null){
            result = "SUCCESS";
        }else{
            result = "FAIL";
        }
        System.out.println("Result of getting mastermind file score parser: " + result);
        
        /*
         * Get the mastermind game file parser from mastermind
         */
        MastermindGameFileParser gameParser = mastermind.getGameParser();

        /*
         * Checking is mastermind file game parser generated successful
         */
        if(gameParser != null){
            result = "SUCCESS";
        }else{
            result = "FAIL";
        }
        System.out.println("Result of getting mastermind file game parser: " + result);

        /*
         * Put mastermind score file parser in mastermind
         */
        mastermind.setScoreParser(new MastermindScoreFileParser());

        /*
         * Get the scores from mastermind
         */
        Scores scores = mastermind.getScores();

        /*
         * Checking is mastermind scores generated successful
        */
        if(scores != null){
            result = "SUCCESS";
        }else{
            result = "FAIL";
        }
        System.out.println("Result of getting mastermind scores: " + result);

        /*
         * Put scores in mastermind
         */
        mastermind.setScores(new Scores(parser, gameLevelType));
    
    }
    /**
     * Main constructor for the Mastermind and Game Test
     * @param args
     */
    public static void main(String[] args) {

        MastermindTest test = new MastermindTest();

        test.run();
    }

}
