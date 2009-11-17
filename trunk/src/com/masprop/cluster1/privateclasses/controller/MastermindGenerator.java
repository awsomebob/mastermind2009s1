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

	
	public Mastermind generateGame(GameLevelType gameLevelType){
		return new Mastermind(gameLevelType);
	}
	
}
