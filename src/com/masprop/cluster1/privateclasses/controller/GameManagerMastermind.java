package com.masprop.cluster1.privateclasses.controller;

import com.masprop.cluster1.privateclasses.model.GameModeType;
import com.masprop.cluster1.privateclasses.model.Mastermind;
import com.masprop.cluster1.shared.model.GameLevelType;

/**
 * 
 * This class provides the management operations on the mastermind game
 * 
 * @author Milan Stanic
 *
 */

public class GameManagerMastermind {

	/**
	 * Generates mastermind game
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
	public Mastermind getNewGame(GameLevelType gameLevelType, GameModeType gameModeType){
		return mastermindGenerator.generateGame(gameLevelType, gameModeType);
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
	
	/**
	 * Sets the mastermind generator game
	 * 
	 * @param mastermindGenerator
	 */

	public void setMastermindGenerator(MastermindGenerator mastermindGenerator) {
		this.mastermindGenerator = mastermindGenerator;
	}
	
	/**
	 *  Sets the mastermind game solver
	 * 
	 * @param gameSolverMastermind
	 */
	public void setGameSolverMastermind(GameSolverMastermind gameSolverMastermind) {
		this.gameSolverMastermind = gameSolverMastermind;
	}
	
	/**
	 * Save current mastermind game
	 * 
	 * @param mastermind mastermind game
	 */
	public void saveMastermindGame(Mastermind mastermind){
		mastermind.getGameParser().update(mastermind);
	}
	
	/**
	 * Open the last saved mastermind game
	 * 
	 * @param mastermind mastermind game
	 * @return the last saved mastermind game
	 */
	public Mastermind openLastSaveMastermindGame(Mastermind mastermind){
		return mastermind.getGameParser().getMastermindFromFile();
	}
}
