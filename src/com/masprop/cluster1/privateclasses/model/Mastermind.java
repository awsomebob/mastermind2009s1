package com.masprop.cluster1.privateclasses.model;

/**
 * Class represents game with a current game and all necessary
 * information for generating, solving
 * or for handling the score of this game.
 * 
 * @see MasterminStatus
 * 
 * @author Milan Stanic
 */

import com.masprop.cluster1.shared.model.GameLevelType;


public class Mastermind extends Game {
	
	/**
	 * pile will describe this class
	 */
	private MastermindStatus mastermindStatus;
	
	/**
	 * Constructor
	 * 
	 * @param gameLevelType game difficulty level
	 */
	public Mastermind(GameLevelType gameLevelType) {
			super(gameLevelType);
			mastermindStatus = new MastermindStatus();
	}

	/**
	 * 
	 * @return mastermindStaus
	 */
	public MastermindStatus getMastermindStatus() {
		return mastermindStatus;
	}

	/**
	 * 
	 * @param mastermindStatus status of current game
	 */
	public void setMastermindStatus(MastermindStatus mastermindStatus) {
		this.mastermindStatus = mastermindStatus;
	}
	
	

}
