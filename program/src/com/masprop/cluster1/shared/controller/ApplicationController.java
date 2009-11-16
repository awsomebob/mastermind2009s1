package com.masprop.cluster1.shared.controller;

import java.lang.reflect.InvocationTargetException;

import com.masprop.cluster1.shared.model.GameType;
import com.masprop.cluster1.shared.view.GUIManager;

/**
 * This class provides the skeleton implementation for any <tt>Game</tt>
 * Application Controller.
 * <p>
 * It provides a singleton handle reference to itself based on a
 * <tt>GameType</tt> for any client application to get access to the different
 * controllers for a <tt>Game</tt>
 * </p>
 * <p>
 * It is composed of a <tt>GUIManager</tt> and a <tt>GameManager</tt> and it has
 * an application level scope. It serves as the necessary delegation layer
 * between the <tt>GUIManager</tt> and <tt>GameManager</tt>
 * </p>
 * 
 * @see GUIManager
 * @see GameManager
 * @see Game
 * @see GameType
 * @since 1.0
 * @version 1.0
 */
public abstract class ApplicationController {

	/**
	 * The singleton handler for the Game Application.
	 * 
	 */
	private static ApplicationController uniqueInstance;
	/**
	 * The reference to the GameManager.
	 * */
	private GameManager gameManager;
	/**
	 * The GameType for which the singleton instance would be returned. To be
	 * read from a system file, system property or constant file.
	 * */
	private static GameType gameToPlay;
	/** The reference to the GUIManager for the Game Application. */
	private GUIManager guiManager;

	/**
	 * Gets the single instance of ApplicationController.
	 * 
	 * @param gameType
	 *            the game type
	 * 
	 * @return single instance of ApplicationController
	 */
	public static ApplicationController getInstance(GameType gameType) {

		//setGameToPlay(getGameToPlay() == null ? gameType : getGameToPlay());
		
		try {
			Class<?> gameController;
			if (gameType == GameType.SUDOKU) {

				gameController = Class
						.forName("com.masprop.cluster1.sudoku.controller.SudokuApplicationController");
				return (ApplicationController) gameController.getMethod(
						"getSudokuApplicationController", null).invoke(
						gameController, null);
			}
			if (gameType == GameType.HIDATO) {
				gameController = Class
						.forName("com.masprop.cluster1.hidato.controller.HidatoApplicationController");
				return (ApplicationController) gameController.getMethod(
						"getHidatoApplicationController", null).invoke(
						gameController, null);
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		throw new IllegalArgumentException(
				"Cannot Create a Game Controller for " + gameType);

	}

	/**
	 * Gets the game manager.
	 * 
	 * @return the game manager
	 */
	public GameManager getGameManager() {
		return gameManager;
	}

	/**
	 * Sets the game manager.
	 * 
	 * @param val
	 *            the new game manager
	 */
	public void setGameManager(GameManager val) {
		this.gameManager = val;
	}

	/**
	 * Gets the game to play.
	 * 
	 * @return the game to play
	 */
	public static GameType getGameToPlay() {
		return gameToPlay;
	}

	/**
	 * Gets the gui manager.
	 * 
	 * @return the gui manager
	 */
	public GUIManager getGuiManager() {
		return guiManager;
	}

	/**
	 * This is an internal delegation operation which signal the GUIManager to
	 * create the necessary components for the view.
	 */
	protected void generateGUI() {
	}

	/**
	 * This is an internal delegation operation to initialize all the components
	 * related to start a Game Application.
	 */
	protected void initalizeComponents() {
		
		
	}

	/**
	 * Sets the gui manager.
	 * 
	 * @param guiManager
	 *            the new gui manager
	 */
	void setGuiManager(GUIManager guiManager) {
		this.guiManager = guiManager;
	}
	
	

	public static ApplicationController getUniqueInstance() {
		return uniqueInstance;
	}

	public static void setUniqueInstance(ApplicationController uniqueInstance) {
		ApplicationController.uniqueInstance = uniqueInstance;
	}

	public static void setGameToPlay(GameType gameToPlay) {
		ApplicationController.gameToPlay = gameToPlay;
	}
}
