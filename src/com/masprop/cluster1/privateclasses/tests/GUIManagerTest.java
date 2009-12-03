package com.masprop.cluster1.privateclasses.tests;

import com.masprop.cluster1.privateclasses.view.GUIManager;
import com.masprop.cluster1.shared.model.GameLevelType;

public class GUIManagerTest {

	public GUIManager gui;	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		GUIManagerTest test = new GUIManagerTest(); 
		
		test.gui = new GUIManager();
		
		int[] values = new int [4]; 
		values = test.gui.randomCoputeValue(GameLevelType.MEDIUM);
		for(int i=0; i<4; i++)
			System.out.print(" " + values[i]);
	}

}
