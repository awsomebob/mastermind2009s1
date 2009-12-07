package com.masprop.cluster1.privateclasses.model;

/**
 * This class represents game and contents top 10 scores for current level of difficulty
 * and current level type.
 *
 * @see MastermindFileParser
 * @see GameLevelType
 * @see GameModeType
 * @see MastermindScoreFileParser
 * @see MastermindGameFileParser
 * @see Scores
 * @author Milan Stanic
 */

import com.masprop.cluster1.privateclasses.model.diskmanager.*;
import com.masprop.cluster1.shared.model.GameLevelType;

public abstract class Game {
    /**
     * Top 10 scores for current level of difficulty.
     */
    private Scores scores;
    
    /**
     * Game mode type
     */
    private GameModeType gameModeType;

    /**
     * Game difficulty level.
     */
    private GameLevelType gameLevelType;

    /**
     * Game score parser
     */
    private MastermindScoreFileParser scoreParser;
    
    /**
     * Game parser
     */
    private MastermindGameFileParser gameParser;
    
    /**
     * players score at the end of game
     */
    private int score;

    /**
     * Constructor to make a new game
     *
     * @param gameLevelType game difficulty level
     */
    public Game(GameLevelType gameLevelType, GameModeType gameModeType){
        this.gameLevelType = gameLevelType;
        this.gameModeType = gameModeType;
        scoreParser = new MastermindScoreFileParser();
        gameParser = new MastermindGameFileParser(false);
        scores = new Scores(scoreParser, gameLevelType);
        score = 0;
    }

    /**
     * Gets top 10 scores for current difficulty level
     *
     * @return top 10 scores for current difficulty level
     */
    public Scores getScores() {
        return scores;
    }

    /**
     * Sets top 10 scores for current difficulty level
     *
     * @param scores top 10 scores for current difficulty level
     */
    public void setScores(Scores scores) {
        this.scores = scores;
    }

    /**
     * Gets game level type
     *
     * @return game difficulty level
     */
    public GameLevelType getGameLevelType() {
        return gameLevelType;
    }

    /**
     * Sets game level type
     *
     * @param gameLevelType game difficulty level
     */
    public void setGameLevelType(GameLevelType gameLevelType) {
        this.gameLevelType = gameLevelType;
    }

    /**
     * Gets mastermind file parser
     *
     * @return mastermind file parser
     */
    public MastermindScoreFileParser getScoreParser() {
        return scoreParser;
    }

    /**
     * Sets mastermind file parser
     *
     * @param parser mastermind file parser
     */
    public void setScoreParser(MastermindScoreFileParser scoreParser) {
        this.scoreParser = scoreParser;
    }

    /**
     * Gets game mode type
     * 
     * @return game mode type
     */
	public GameModeType getGameModeType() {
		return gameModeType;
	}

	/**
	 * Sets game mode type
	 * 
	 * @param gameModeType game mode type
	 */
	public void setGameModeType(GameModeType gameModeType) {
		this.gameModeType = gameModeType;
	}

	/**
	 * Gets game parser
	 * 
	 * @return mastermind game file parser
	 */
	public MastermindGameFileParser getGameParser() {
		return gameParser;
	}

	/**
	 * Sets game parser
	 * 
	 * @param gameParser mastermind game file parser
	 */
	public void setGameParser(MastermindGameFileParser gameParser) {
		this.gameParser = gameParser;
	}

	/**
	 * Gets score for current game
	 * 
	 * @return score for current game
	 */
	public int getScore() {
		return score;
	}

	/**
	 * Sets scores for current game
	 * 
	 * @param score current game score
	 */
	public void setScore(int score) {
		this.score = score;
	}

}
