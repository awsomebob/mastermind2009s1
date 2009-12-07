package com.masprop.cluster1.privateclasses.view;

import java.util.Random;

import com.masprop.cluster1.privateclasses.controller.GameManagerMastermind;
import com.masprop.cluster1.privateclasses.controller.GameSolverMastermind;
import com.masprop.cluster1.privateclasses.controller.MastermindGenerator;
import com.masprop.cluster1.privateclasses.model.GameModeType;
import com.masprop.cluster1.privateclasses.model.Mastermind;
import com.masprop.cluster1.shared.model.GameLevelType;

/**
 * This class handles whit GUI interface and domain layer and it is not finished yet
 * It's reason because I didn't make tests for all functions in this class
 * 
 * @see Mastermind
 * @see MyGUI
 * @see GameManagerMastermind
 * @see GameLevelType
 * @see GameModeType
 * @see MastermindGenerator
 * @see GameSolverGame
 * @author Milan Stanic
 *
 */

public class GUIManager {

	/**
     * mastermind game object
     */
    private Mastermind mastermind;
    
    /**
     * Is game resolved
     */
    private boolean isResolved;
	
    /**
     * Mastermind game manager
     */
    private GameManagerMastermind gameManager;
        
    /**
     * Constructor
     * 
     * Creates mastermind game generator and mastrmind game solver, and also initiate isResolved to false
     */
    public GUIManager(){
    	gameManager = new GameManagerMastermind();
    	gameManager.setGameSolverMastermind(new GameSolverMastermind());
    	gameManager.setMastermindGenerator(new MastermindGenerator());
    	isResolved = false;
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
	 * Gets mastermind game
	 * 
	 * @return mastermind game
	 */
	public Mastermind getMastermind() {
		return mastermind;
	}

	/**
	 *  Gets mastermind game manager
	 * @return mastermind game manager
	 */
	public GameManagerMastermind getGameManager() {
		return gameManager;
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
	
	/**
	 * 
	 * @return
	 */
	public boolean check(){
		if(mastermind != null){
			if(mastermind.getGameModeType() == GameModeType.PLAYERvsCOMP){
				int currentRow = mastermind.getMastermindStatus().getCurrentRow();
				boolean correct = true;
				for(int i=0; i<4; i++)
					if(isCorrectValue(currentRow, i) == false)
						correct = false;
				if(correct){
					isResolved = mastermind.getMastermindStatus().isCorrectValue();
					return true;
				}
				return false;
			}
			return false;
		}
		else
			return false;
	}
	
	/**
	 * This class compute randomly values (colors) which player have to guess
	 * 
	 * @param gameLevelType
	 * @return computed values
	 */
	public int[] randomCoputeValue(GameLevelType gameLevelType){
		
		int numColors = numColors(gameLevelType);
		
		int[] i = new int[4];
		
		Random random = new Random();
		for(int k=0; k<4; k++){
			i[k] = random.nextInt(numColors);
		}
		return i;
	}
	
	/**
	 * Is sell contenting correct value
	 * 
	 * @param currentRow current row
	 * @param currenPositionInRow current position in row
	 * @param gameLevelType game difficulty level
	 * @return true or false
	 */
	boolean isCorrectValue(int currentRow, int currenPositionInRow){
		return mastermind.getMastermindStatus().getMatrixMastermind().getCell(currentRow, currenPositionInRow).isActive();
	}
	
	/**
	 * Number of colors 
	 * 
	 * @param gameLevelType
	 * @return
	 */
	int numColors(GameLevelType gameLevelType){
		int numColors;
		if(gameLevelType == GameLevelType.EASY)
			numColors = 4;
		else if(gameLevelType == GameLevelType.MEDIUM)
			numColors = 5;
		else 
			numColors = 6;
		return numColors;
	}

    


	/**
	 * Gets the information is game resolved
	 * 
	 * @return is game resolved
	 */
	public boolean isResolved() {
		return isResolved;
	}

	/**
	 * Sets the information is game resolved
	 * 
	 * @param isResolved is game resolved
	 */
	public void setResolved(boolean isResolved) {
		this.isResolved = isResolved;
	}
	
	/**
     * The number of colors on right position
     * 
     * @return the number of colors on right position
     */
    public int numCorrectPosition(){
        return mastermind.getMastermindStatus().numCorrectPosition();
    }

    /**
     * The number of colors on wrong position
     * 
     * @return the number of colors on wrong position
     */
    public int numWrongPosition(){
        return mastermind.getMastermindStatus().numWrongPosition();
    }

    /**
     * Current row in matrix
     * 
     * @return current row in matrix
     */
    public int currentRow(){
        return mastermind.getMastermindStatus().getCurrentRow();
    }

    
}
