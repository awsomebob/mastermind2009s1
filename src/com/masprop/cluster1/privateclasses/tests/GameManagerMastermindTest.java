package com.masprop.cluster1.privateclasses.tests;

import com.masprop.cluster1.privateclasses.controller.GameManagerMastermind;
import com.masprop.cluster1.privateclasses.controller.GameSolverMastermind;
import com.masprop.cluster1.privateclasses.controller.MastermindGenerator;
import com.masprop.cluster1.privateclasses.model.GameModeType;
import com.masprop.cluster1.privateclasses.model.Mastermind;
import com.masprop.cluster1.shared.model.GameLevelType;


/**
 * This class is testing class GameManagerMastermind
 * 
 * @author Milan Stanic
 *
 */

public class GameManagerMastermindTest {

	public void run(){
		/* Changeable variables
         * When wanting other output, please change these values
         */
		
		/*
		 * Class for testing
		 * 
		 * Here we are testing get and set methods and function for creating new game,
		 * function for solving game.
		 * We doesn't test here function for saving and open last save game, 
		 * because it's testing in MastermindSaveGame
		 */
		// Initialize our game mastermind manager
		GameManagerMastermind manager = new GameManagerMastermind();
		
		// Initialize our mastermind generator
		MastermindGenerator generator = new MastermindGenerator();
		
		// Initialize our game mastermind solver
		GameSolverMastermind solver = new GameSolverMastermind();
		
		// game which we want to generate
		Mastermind mastermind = null;
		
		// solved mastermind
		Mastermind solvedMastermind = null;
	    
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
        GameModeType gameModeType = GameModeType.COMPvsPLAYER;
		
		//-------------------------------------------------------------------
        //Do not modify below this line please
        //-------------------------------------------------------------------		
		
		/*
		 * Put mastermind generator in game mastermind manager
		 */
		manager.setMastermindGenerator(generator);
		
		/*
		 * Get the mastermind generator from game mastermind manager
		 */
		generator = manager.getMastermindGenerator();
		
		String result;
		
		/*
		 * Checking is mastermind generator got successful 
		 */
		if(generator != null){
			result = "SUCCESS";
		}else{
			result = "FAIL";
		}
		System.out.println("Result of getting mastermind generator: " + result);
						
		/*
		 * Put mastermind game solver in game mastermind manager
		 */
		manager.setGameSolverMastermind(solver);
		
		/*
		 * Get the mastermind game solver from game mastermind manager
		 */
		solver = manager.getGameSolverMastermind();
		
		/*
		 * Checking is mastermind game solver got successful 
		 */
		if(solver != null){
			result = "SUCCESS";
		}else{
			result = "FAIL";
		}
		System.out.println("Result of getting mastermind game solver: " + result);
		
		
		/*
		 * Generate new mastermind game
		 */
		mastermind = manager.getNewGame(gameLevelType, gameModeType);
		
		/*
		 * Checking is mastermind game generated successful 
		*/
		if(mastermind != null){
			result = "SUCCESS";
		}else{
			result = "FAIL";
		}
		System.out.println("Result of creating mastermind game: " + result);
		
		/*
		 * Solving mastermind game
		 */
		solvedMastermind = manager.solveGame(mastermind);
		
		/*
		 * Checking is mastermind game solved successful 
		*/
		//here I only checking is funtsion solveGame return mastermind game object
		if(solvedMastermind != null){
			result = "SUCCESS";
		}else{
			result = "FAIL";
		}
		System.out.println("Result of solving mastermind game: " + result);
	}
	
	/**
	 * Main constructor for the GameManagerMastermind Test
	 * @param args
	 */
	public static void main(String[] args) {

		GameManagerMastermindTest test = new GameManagerMastermindTest();
		
		test.run();
		
		
	}

}
