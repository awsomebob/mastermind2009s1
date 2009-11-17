package com.masprop.cluster1.privateclasses.model;

/**
 *  This class represents game and contents top 10 scores for current level of difficulty
 *  and current level type.
 *  
 *  @see MastermindParser
 *  @see Scores
 *  @author Milan Stanic
 */

import com.masprop.cluster1.privateclasses.model.diskmanager.MastermindFileParser;
import com.masprop.cluster1.shared.model.GameLevelType;

public abstract class Game {
	/**
	 * Top 10 scores for current level of difficulty.
	 */
	private Scores scores;
	
    /**
     * Game difficulty level.
     */
	private GameLevelType gameLevelType;
	
	/**
	 * Game parser 
	 * Nick will describe functions for him
	 */
	private MastermindFileParser parser;
	
	/**
	 * Constructor
	 * 
	 * @param gameLevelType game difficulty level
	 */
	public Game(GameLevelType gameLevelType){
		this.gameLevelType = gameLevelType;
		parser = new MastermindFileParser();
		scores = new Scores(parser, gameLevelType);
	}
	
	/**
	 * 
	 * @return top 10 scores for current difficulty level
	 */
	public Scores getScores() {
		return scores;
	}

	/**
	 * 
	 * @param scores top 10 scores for current difficulty level 
	 */
	public void setScores(Scores scores) {
		this.scores = scores;
	}

	/**
	 * 
	 * @return game difficulty level
	 */
	public GameLevelType getGameLevelType() {
		return gameLevelType;
	}

	/**
	 * 
	 * @param gameLevelType game difficulty level
	 */
	public void setGameLevelType(GameLevelType gameLevelType) {
		this.gameLevelType = gameLevelType;
	}
	
	
}
