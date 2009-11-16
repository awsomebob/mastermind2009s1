package com.masprop.cluster1.shared.controller;

import java.util.List;

import com.masprop.cluster1.shared.model.Constraint;
import com.masprop.cluster1.shared.model.Game;

/**
 * This Interface provides the management operations on a <tt>Game</tt>
 * 
 * <p>All classes which need to manage operations on <tt>Game</tt> 
 * should implement this interface. Ideally there should be one GameManager
 * per instance of a game application. However the decision is left up
 * to the developer.</p>
 * 
 * <p>The interface provides for retrieving the specific Controllers of
 * a game, the <tt>GameGenerator</tt>, the <tt>GameValidator</tt> and 
 * the <tt>GameSolver</tt> and delegating the client's requests to them</p>
 *
 * <p>Also this interface provides the handle for the <tt>StorageManager</tt><p>
 * 
 * 
 * @see Game
 * @see GameGenerator
 * @see GameSolver
 * @see GameValidator
 * @see StorageManager
 * 
 * @version 1.0
 * @since 1.0
 */
public interface GameManager {

    /**
     * Gets the game generator.
     *
     * @return the game generator
     */
    public GameGenerator getGameGenerator();

    /**
     * Gets the game solver.
     * 
     * @return the game solver
     */
    public GameSolver getGameSolver();

     
    /**
     * Gets the game validator.
     * 
     * @return the game validator
     */
    public GameValidator getGameValidator();

    /**
     * Gets the storage manager.
     *
     * @return the storage manager
     */
    public StorageManager getStorageManager();

     
    /**
     * Gets the new game.
     * 
     * @param constraint the constraint
     * 
     * @return the new game
     */
    public Game getNewGame(Constraint constraint);

     
    /**
     * Validate game.
     * 
     * @param game the game
     * 
     * @return true, if successful
     */
    public boolean validateGame(Game game);

     
    /**
     * Solve game.
     * 
     * @param game the game
     * 
     * @return the game
     */
    public Game solveGame(Game game);

     
    /**
     * Save game.
     * 
     * @param game the game
     */
    public void saveGame(Game game);

     
    /**
     * Load game.
     * 
     * @return the list< game>
     */
    public List<Game> loadGame();

     
    /**
     * Gets the statistics.
     * 
     * @return the statistics
     */
    public List<String> getStatistics();
}

