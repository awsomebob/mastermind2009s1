package com.masprop.cluster1.privateclasses.tests;

import com.masprop.cluster1.privateclasses.controller.MastermindGenerator;
import com.masprop.cluster1.privateclasses.model.GameModeType;
import com.masprop.cluster1.privateclasses.model.Mastermind;
import com.masprop.cluster1.shared.model.GameLevelType;

/**
 * This class is testing class MastermindGenerator
 * 
 * @author Milan Stanic
 *
 */

public class MastermindGeneratorTest {
	
	public void run(){
		/* Changeable variables
         * When wanting other output, please change these values
         */
	
		/*
		 *  Class for testing 
		 */
		MastermindGenerator generator;
	
		generator = new MastermindGenerator();
		
		/*
		 * We want to generate this game
		 */
		Mastermind mastermind = null;
		
		//Which GameLevelType do you want to use?
        //possible values
        //GameLevelType.DIFFICULT;
        //GameLevelType.MEDIUM;
        //GameLevelType.EASY;
		GameLevelType gameLevelType = GameLevelType.DIFFICULT; 
		
		//Which GameModeType do you want to use?
        //Possible values
        //GameModeType.COMPvsPLAYER
        //GameModeType.PLAYERvsCOMP
        //GameModeType.PLAYERvsPLAYER
		GameModeType gameModeType = GameModeType.PLAYERvsCOMP;
		
		//-------------------------------------------------------------------
        //Do not modify below this line please
        //-------------------------------------------------------------------
		
		/*
		 * Generating new game
		 */
		mastermind = generator.generateGame(gameLevelType, gameModeType);
		
		String result;
		
		/*
		 * Checking is game generate successful 
		 */
		if(mastermind != null){
			result = "SUCCESS";
		}else{
			result = "FAIL";
		}
		System.out.println("Result of generating mastermind game: " + result);
	}

	/**
	 * Main constructor for the MastermindGenerator Test
	 * @param args
	 */
	public static void main(String[] args) {
		
		MastermindGeneratorTest test = new MastermindGeneratorTest();
		
		test.run();
	}

}
