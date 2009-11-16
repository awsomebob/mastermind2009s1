package com.masprop.cluster1.shared.controller;

import com.masprop.cluster1.shared.model.Game;

// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.7F49EC25-927B-D0A4-005C-F8266B6A2E49]
// </editor-fold> 
/**
 * This Interface provides the method needed to solve a Game.
 * This will be done through a specific algorithm, which will be
 * contained in a class implementing the Algorithm interface.
 *  
 * @see Game
 * @see Algorithm
 * 
 * @version 1.0
 * @since 1.0	
 */
public interface GameSolver {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.DAD71A25-2048-0BE8-DF84-88622DFCD84C]
    // </editor-fold> 
	/**
	 * Solves an instance of Game through the use of a specific Algorithm.
	 * The returning Game instance then will be the solution for the input
	 * Game instance.
	 * 
	 * @param Game game
	 * @return Game	
	 */
    public Game solveGame (Game game);

}

