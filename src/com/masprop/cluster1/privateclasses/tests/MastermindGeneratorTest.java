package com.masprop.cluster1.privateclasses.tests;

import com.masprop.cluster1.privateclasses.controller.MastermindGenerator;
import com.masprop.cluster1.privateclasses.model.Mastermind;
import com.masprop.cluster1.shared.model.GameLevelType;

/**
 * This class is testing class MastermindGenerator
 * 
 * @author Milan Stanic
 *
 */

public class MastermindGeneratorTest {
	
	/**
	 *  Class for testing 
	 */
	public MastermindGenerator generator;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		MastermindGeneratorTest test = new MastermindGeneratorTest();
		
		test.generator = new MastermindGenerator();
		
		/**
		 * We want to generate this game
		 */
		Mastermind mastermind = null;
		
		/**
		 * Difficulty level of game which we want to generate
		 */
		GameLevelType gameLevelType = GameLevelType.DIFFICULT; 
		
		/**
		 * Generating new game
		 */
		mastermind = test.generator.generateGame(gameLevelType);
		
		String result;
		
		/**
		 * Checking is game generate successful 
		 */
		if(mastermind != null){
			result = "SUCCESS";
		}else{
			result = "FAIL";
		}
		System.out.println("Result of generating mastermind game: " + result);
	}

}
