package com.masprop.cluster1.shared.controller;

import com.masprop.cluster1.shared.model.Game;


// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.C8D07294-3D59-26AB-D54F-8B5CABB7B6AD]
// </editor-fold> 
/**
 * This Interface provides the method needed to check if a <tt>Game</tt>
 * instance is solvable.
 *  
 * @see Game
 * 
 * @version 1.0
 * @since 1.0	
 */
public interface GameValidator {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.0FCDBB12-75D4-0429-980D-2587A41ED922]
    // </editor-fold> 
	/**
	 * Validates the instance of Game which is passed as parameter
	 * using the specific algorithm.
	 * 
	 * @param Game game
	 */
    public boolean validateGame (Game game);

}

