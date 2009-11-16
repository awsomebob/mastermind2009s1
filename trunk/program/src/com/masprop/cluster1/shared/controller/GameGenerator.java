package com.masprop.cluster1.shared.controller;

import com.masprop.cluster1.shared.model.Constraint;
import com.masprop.cluster1.shared.model.Game;

// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.E7F8DC8B-37D6-1BDD-2282-0DFB7A837DB9]
// </editor-fold> 
/**
 * This Interface provides the method needed to retrieve a newly generated
 * <tt>Game</tt>.
 *  
 * @see Game
 * @see GameManager
 * 
 * @version 1.0
 * @since 1.0
 */
public interface GameGenerator {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.21E81485-6016-A042-DF52-89668D5A714C]
    // </editor-fold> 
    /**
     *	This method generates and return a complete Game to the caller.
     *
     *  @return Game
     */
    public Game generateGame(Constraint constraint);
}

