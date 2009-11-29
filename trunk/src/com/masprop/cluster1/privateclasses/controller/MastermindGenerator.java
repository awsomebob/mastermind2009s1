package com.masprop.cluster1.privateclasses.controller;

import com.masprop.cluster1.privateclasses.model.Mastermind;
import com.masprop.cluster1.shared.model.GameLevelType;

/**
 * This class generates mastermind game
 * 
 * @author Milan
 *
 */

public class MastermindGenerator {
	
	/**
	 * Empty constructor 
	 */
	public MastermindGenerator(){}
	
	/**
	 * This method creates new mastermind game
	 * 
	 * @param gameLevelType game difficulty level
	 * @return new mastermind game
	 */
	public Mastermind generateGame(GameLevelType gameLevelType){
		return new Mastermind(gameLevelType);
	}
	
}
