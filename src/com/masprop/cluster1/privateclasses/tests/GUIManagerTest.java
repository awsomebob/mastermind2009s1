package com.masprop.cluster1.privateclasses.tests;

import com.masprop.cluster1.privateclasses.view.GUIManager;
import com.masprop.cluster1.shared.model.GameLevelType;
/**
 *
 * This class is testing some functions in GUIManager
 *
 * @author Milan Stanic
 *
 */
public class GUIManagerTest {

	public void run(){
		
		/* Changeable variables
         * When wanting other output, please change these values
		 */
		 
		/*
		 * Class for testing
		 */
		GUIManager gui;
		
		gui = new GUIManager();
		
		//Which GameLevelType do you want to use?
        //possible values
        //GameLevelType.DIFFICULT;
        //GameLevelType.MEDIUM;
        //GameLevelType.EASY;
        GameLevelType gameLevelType = GameLevelType.DIFFICULT;
        
        //-------------------------------------------------------------------
        //Do not modify below this line please
        //-------------------------------------------------------------------
		

        // compute randomly values (colors) which player have to guess
        // for current game difficulty level
        int[] values = new int [4];
        values = gui.randomCoputeValue(gameLevelType);
        for(int i=0; i<4; i++)
            System.out.print(" " + values[i]);
	}
	
    

    /**
     * Main constructor for the GUIManager
     * @param args
     */
    public static void main(String[] args) {

        GUIManagerTest test = new GUIManagerTest();

        test.run();
    }

}
