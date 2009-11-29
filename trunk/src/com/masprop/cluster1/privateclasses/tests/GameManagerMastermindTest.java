package com.masprop.cluster1.privateclasses.tests;

import com.masprop.cluster1.privateclasses.controller.GameManagerMastermind;
import com.masprop.cluster1.privateclasses.controller.GameSolverMastermind;
import com.masprop.cluster1.privateclasses.controller.MastermindGenerator;
import com.masprop.cluster1.privateclasses.model.Mastermind;
import com.masprop.cluster1.shared.model.GameLevelType;


/**
 * This class is testing class GameManagerMastermind
 * 
 * @author Milan Stanic
 *
 */

public class GameManagerMastermindTest {

	/**
	 * Class for testing
	 */
	public GameManagerMastermind manager;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		GameManagerMastermindTest test = new GameManagerMastermindTest();
		
		test.manager = new GameManagerMastermind();
		
		MastermindGenerator generator = new MastermindGenerator();
		
		/**
		 * Put mastermind generator in game mastermind manager
		 */
		test.manager.setMastermindGenerator(generator);
		
		/**
		 * Get the mastermind generator from game mastermind manager
		 */
		generator = test.manager.getMastermindGenerator();
		
		String result;
		
		/**
		 * Checking is mastermind generator got successful 
		 */
		if(generator != null){
			result = "SUCCESS";
		}else{
			result = "FAIL";
		}
		System.out.println("Result of getting mastermind generator: " + result);
		
		GameSolverMastermind solver = new GameSolverMastermind();
		
		/**
		 * Put mastermind game solver in game mastermind manager
		 */
		test.manager.setGameSolverMastermind(solver);
		
		/**
		 * Get the mastermind game solver from game mastermind manager
		 */
		solver = test.manager.getGameSolverMastermind();
		
		/**
		 * Checking is mastermind game solver got successful 
		 */
		if(solver != null){
			result = "SUCCESS";
		}else{
			result = "FAIL";
		}
		System.out.println("Result of getting mastermind game solver: " + result);
		
		Mastermind mastermind;
		
		/**
		 * Generate new mastermind game
		 */
		mastermind = test.manager.getNewGame(GameLevelType.DIFFICULT);
		
		/**
		 * Checking is mastermind game generated successful 
		*/
		if(mastermind != null){
			result = "SUCCESS";
		}else{
			result = "FAIL";
		}
		System.out.println("Result of creating mastermind game: " + result);
		
		/**
		 * Solving mastermind game
		 */
		Mastermind newmastermind = test.manager.solveGame(mastermind);
		
		/**
		 * Checking is mastermind game solved successful 
		*/
		//here we need to add additional checking when Nick implement GameSolverMastermind
		if(newmastermind != null){
			result = "SUCCESS";
		}else{
			result = "FAIL";
		}
		System.out.println("Result of solving mastermind game: " + result);
	}

}
