package com.masprop.cluster1.shared.view;

import java.util.List;

import com.masprop.cluster1.shared.controller.GameManager;
import com.masprop.cluster1.shared.model.Constraint;
import com.masprop.cluster1.shared.model.Game;

/**
 * GUIManager is imlementing the action logic, swing workers and other
 * operations invoked from the GUI. GUIManager calls operations on the
 * GameManager in order to carry out the desired user demands.
 * 
 * @author
 */
public abstract class GUIManager {

    /**
     * The actual game (includes matrix and constraints)
     */
    private Game game = null;
    /**
     * Various setings.
     */
    private Constraint constraint = null;
    /**
     * GameManager - game business logic handler.
     */
    private GameManager mGameManager = null;

    /**
     * JFrame definitions, GUI elements, action listener
     */
    private GUI gui = null;

    /**
     * GUIManager handles all the GUI actions.
     * @param gui actual GUI
     */
    public GUIManager(GUI gui) {
        this.gui = gui;
    }

    /**
     * Retrieves a new game object from the
     * GameManager.
     *
     * @param constraint
     * @return a new game instance
     */
    public Game getNewGame(Constraint constraint) {
        return null;
    }

    /**
     * Asks the GameManager to validate the Game.
     *
     * @param game
     * @return true/false, valid game/invalid game
     */
    public boolean validateGame(Game game) {
        return true;
    }

    /**
     * Asks the GameManager for providing the solution for the Game.
     *
     * @param game
     * @return solved game
     */
    public Game solveGame(Game game) {
        return null;
    }

    /**
     * Asks the GameManager to persist the current Game object.
     * @param game to be saved
     */
    public void saveGame(Game game) {
    }

    /**
     * Load a game or a collection of instances of the Game.
     *
     * @return
     */
    public List<Game> loadGame() {
        return null;
    }

    /**
     * Sets all the JForm elements and all proper variables in order to
     * display the correct UI for the player.
     */
    public void displayGame() {
    }

    /**
     * Settings provider.
     * @return current settings.
     */
    public Constraint getConstraint() {
        return constraint;
    }

    /**
     * Sets the setting.
     * @param new settings to be set
     */
    public void setConstraint(Constraint val) {
        this.constraint = val;
    }

    /**
     * Provide the current Game object instance.
     * @return game to be returned
     */
    public Game getGame() {
        return game;
    }

    /**
     * Sets the current Game instance.
     * @param game to be set
     */
    public void setGame(Game val) {
        this.game = val;
    }

    /**
     * Retrieve the statistics.
     * @return statistics
     */
    public List<String> getStatistics() {
        return null;
    }

    /**
     * Notify the controller that the user wishes to exit the application.
     * Exit then...
     */
    public void exit() {

    }
}

