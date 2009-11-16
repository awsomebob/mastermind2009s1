package com.masprop.cluster1.shared.controller;

import java.util.List;

import com.masprop.cluster1.shared.model.Game;

// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.B8E2A051-949E-9900-E575-F43603649F43]
// </editor-fold> 
/**
 * This interface handles Statistics management
 * It permits to get and set a score to a specific game
 * and to return a top10 list of scores
 *
 */
public interface StatisticsManager {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.330006DB-53CB-D376-4D75-FC9270C8AF8C]
    // </editor-fold>
    /**
     * Gets score for a specific game.
     *
     * @param game the game
     */
    public void getScoreFor(Game game);

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.878445D4-4946-A1D0-75B2-835CE40D8427]
    // </editor-fold>
    /**
     * Sets score for a specific game.
     *
     * @param game the game
     */
    public void setScoreFor(Game game);

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.AC3508DC-43E3-A6B4-713A-BB38D66360BA]
    // </editor-fold> 
    /**
     * Load game
     * @return
     */
    public List<Game> loadGame();

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.F5B1B416-033A-FFBF-39D2-EECFAB92B2E6]
    // </editor-fold>
    /**
     * Save game.
     *
     * @param game the game
     *
     */
    public void saveGame(Game game);

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.D6F0BAE3-BB45-33E5-AA4E-E6EE031092EB]
    // </editor-fold> 
    /**
     * Get statistics
     * @return top 10 of games scores
     */
    public List<String> getStatistics();
}

