package com.masprop.cluster1.privateclasses.controller;

import com.masprop.cluster1.privateclasses.model.*;
import com.masprop.cluster1.shared.controller.*;
import com.masprop.cluster1.shared.model.Game;
/**
 * This class manages how the algorithm is used
 *
 * @author nick
 *
 */
public class GameSolverMastermind implements GameSolver {
    public GameSolverMastermind() {
        // TODO Auto-generated constructor stub
    }

    public Game solveGame(Game game) {
        MastermindAlgorithm Algo = new MastermindAlgorithm();
        Algo.performAlgorithmics(game);
        return game;
    }


    //milan add this, because argument must be Mastermind
    // probably we can fix that on different way
    public Mastermind solveMastermind(Mastermind mastermind) {
        MastermindAlgorithm Algo = new MastermindAlgorithm();
        Algo.performAlgorithmics(mastermind);

        return mastermind;
    }


}
