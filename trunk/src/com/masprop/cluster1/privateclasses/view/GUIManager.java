package com.masprop.cluster1.privateclasses.view;

import java.util.Random;

import com.masprop.cluster1.privateclasses.controller.GameManagerMastermind;
import com.masprop.cluster1.privateclasses.controller.GameSolverMastermind;
import com.masprop.cluster1.privateclasses.controller.MastermindGenerator;
import com.masprop.cluster1.privateclasses.model.GameModeType;
import com.masprop.cluster1.privateclasses.model.Mastermind;
import com.masprop.cluster1.shared.model.GameLevelType;

public class GUIManager {
	
	/**
	 * mastermind game object
	 */
	private Mastermind mastermind;
	
	/**
	 * mastermind game manager
	 */
	private GameManagerMastermind gameManager;
	
	/**
	 * Constructor
	 */
	public GUIManager(){
		gameManager = new GameManagerMastermind();
		gameManager.setMastermindGenerator(new MastermindGenerator());
		gameManager.setGameSolverMastermind(new GameSolverMastermind());
	}
	
	/**
	 * Gets mastermind game
	 * 
	 * @return mastermind game
	 */
	public Mastermind getMastermind() {
		return mastermind;
	}

	/**
	 * Sets the mastermind game
	 * 
	 * @param mastermind game
	 */
	public void setMastermind(Mastermind mastermind) {
		this.mastermind = mastermind;
	}
	
	/**
	 *  Creating new mastermind game
	 * 
	 * @param gameLevelType game difficulty level
	 * @param gameModeType game mode type
	 */
	public void createNewGame(GameLevelType gameLevelType, GameModeType gameModeType){
		if(gameModeType == GameModeType.PLAYERvsCOMP){
			mastermind = gameManager.getNewGame(gameLevelType, gameModeType);
			mastermind.getMastermindStatus().setValue(randomCoputeValue(gameLevelType));
		}else{
			// here I need to implement the other two possibilities 
		}
	}
	
	public void check(int[] values){
		if(mastermind.getGameModeType() == GameModeType.PLAYERvsCOMP){
			
		}
	}
	
	/**
	 * This class compute randomly values (colors) which player have to guess
	 * 
	 * @param gameLevelType
	 * @return computed values
	 */
	public int[] randomCoputeValue(GameLevelType gameLevelType){
		
		int numColors;
		if(gameLevelType == GameLevelType.EASY)
			numColors = 4;
		else if(gameLevelType == GameLevelType.MEDIUM)
			numColors = 5;
		else 
			numColors = 6;
		
		int[] i = new int[4];
		
		Random random = new Random();
		for(int k=0; k<4; k++){
			i[k] = random.nextInt(numColors) + 2;
		}
		return i;
	}
	
}
