package com.masprop.cluster1.privateclasses.view;

import java.util.Random;

import com.masprop.cluster1.privateclasses.controller.GameManagerMastermind;
import com.masprop.cluster1.privateclasses.controller.GameSolverMastermind;
import com.masprop.cluster1.privateclasses.controller.MastermindGenerator;
import com.masprop.cluster1.privateclasses.model.GameModeType;
import com.masprop.cluster1.privateclasses.model.Mastermind;
import com.masprop.cluster1.shared.model.GameLevelType;

public class GUIManager {

    /**
     * mastermind game object
     */
    private Mastermind mastermind;

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
