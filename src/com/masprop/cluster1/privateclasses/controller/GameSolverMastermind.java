package com.masprop.cluster1.privateclasses.controller;

import com.masprop.cluster1.privateclasses.model.*;
import com.masprop.cluster1.shared.controller.*;
import com.masprop.cluster1.shared.model.Game;

/**
 * This class manages how the algorithm is used and provides functions to solve
 * the entire Game A general Game solver exists together with a mastermind
 * solver. The general should check if the game object is a mastermind object
 * and then solve the game.
 *
 * @author Nick Veenhof
 *
 */
public class GameSolverMastermind implements GameSolver {

    /**
     * Solve a generic game
     *
     * @param game
     *            General game object
     */
    public Game solveGame(Game game) {
        return game;
    }

    /**
     * Function to solve a mastermind game
     *
     * @param mastermind
     *            a mastermind object
     * @return mastermind object with the solved solution inside
     */
    public Mastermind solveMastermind(Mastermind mastermind) {
        MastermindAlgorithm Algo = new MastermindAlgorithm();
        Algo.performAlgorithmics(mastermind);
        return mastermind;
    }

}
