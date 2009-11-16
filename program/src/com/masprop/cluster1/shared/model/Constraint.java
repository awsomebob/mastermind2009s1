package com.masprop.cluster1.shared.model;

/**
 * Class handles game parameters such as difficulty level,
 * number of cells already filled and game variant.
 *
 * @author Andrea Gritti
 */
public class Constraint {

    /**
     * Game difficulty level.
     */
    private GameLevelType gameLevelType;
    /**
     * Game variant keeps information about board shape and size
     */
    private GameVariant gameVariant;
    /**
     * Number of cells already filled.
     */
    private int noOfFilledCells;

    /**
     * Class constructor.
     *
     * @param gameLevelType difficulty level
     * @param gameVariant information about board shape and size
     * @param noOfFilledCells number of cells already filled
     */
    public Constraint(GameLevelType gameLevelType, GameVariant gameVariant, int noOfFilledCells) {
        this.gameLevelType = gameLevelType;
        this.gameVariant = gameVariant;
        this.noOfFilledCells = noOfFilledCells;
    }

    /**
     * @return gameLevel level of the game
     */
    public GameLevelType getGameLevelType() {
        return this.gameLevelType;
    }

    /**
     * @param gameLevelType represents difficulty level of game
     */
    public void setGameLevelType(GameLevelType gameLevelType) {
        this.gameLevelType = gameLevelType;
    }

    /**
     * @return gameVariant information about board shape and size
     */
    public GameVariant getGameVariant() {
        return this.gameVariant;
    }

    /**
     * @param gameVariant information about board shape and size
     */
    public void setGameVariant(GameVariant gameVariant) {
        this.gameVariant = gameVariant;
    }

    /**
     * @return noOfFilledCells number of cells already filled
     */
    public int getNoOfFilledCells() {
        return noOfFilledCells;
    }

    /**
     * @param noOfFilledCells number of cells already filled
     */
    public void setNoOfFilledCells(int noOfFilledCells) {
        this.noOfFilledCells = noOfFilledCells;
    }
}