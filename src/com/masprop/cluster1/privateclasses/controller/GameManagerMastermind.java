package com.masprop.cluster1.privateclasses.controller;

import com.masprop.cluster1.privateclasses.model.Mastermind;
import com.masprop.cluster1.shared.model.GameLevelType;

/**
 * 
 * This class provides the management operations on a <tt>Mastermind</tt>
 * 
 * @author Milan Stanic
 *
 */

public class GameManagerMastermind {

	/**
	 * contains mastermind game
	 */
	protected MastermindGenerator mastermindGenerator;
	
	/**
	 * contains algorithm for solving mastermind game 
	 */
	protected GameSolverMastermind gameSolverMastermind;

	/**
	 * Gets mastermind generator
	 * 
	 * @return mastermind generator
	 */
	public MastermindGenerator getMastermindGenerator() {
		return mastermindGenerator;
	}

	/**
	 * Gets game solver
	 * 
	 * @return game solver
	 */
	public GameSolverMastermind getGameSolverMastermind() {
		return gameSolverMastermind;
	}
	
	/**
	 * Returns new mastermind game
	 * 
	 * @param gameLevelType game level difficulty 
	 * @return mastermind game
	 */
	public Mastermind getNewGame(GameLevelType gameLevelType){
		return mastermindGenerator.generateGame(gameLevelType);
	}
	
	/**
	 * Returns solve mastermind game
	 * 
	 * @param mastermind mastermind game
	 * @return solve mastermind game 
	 */
	public Mastermind solveGame(Mastermind mastermind){
		return gameSolverMastermind.solveMastermind(mastermind);
	}
	
	
}
