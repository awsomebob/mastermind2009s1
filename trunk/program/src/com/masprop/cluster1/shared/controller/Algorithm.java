package com.masprop.cluster1.shared.controller;

import com.masprop.cluster1.shared.model.Game;

// TODO: Auto-generated Javadoc
// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.7C93EA8C-17C2-FD5F-84F4-9410B867A429]
// </editor-fold> 
/**
 * The interface to implement if there are specific algorithms
 * that have been implemented for <tt>Game</tt> operations.
 * Should be injected into the Controllers.
 * 
 * @see Game
 * @see GameGenerator
 * @see GameSolver
 * @see GameValidator
 * @see GameManager
 * @version 1.0
 * @since 1.0
 */
public interface Algorithm {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.84180A70-9CFF-D143-0013-17AC1E83CA83]
    // </editor-fold> 
    /**
     * Perform the operations defined by the algorithm on the Game.
     * 
     * @param game the game
     */
    public void performArlogrithmics(Game game);
}

