package com.masprop.cluster1.privateclasses.controller;

import com.masprop.cluster1.privateclasses.model.*;
import com.masprop.cluster1.shared.controller.*;
import com.masprop.cluster1.shared.model.Game;

public class GameSolverMastermind implements GameSolver {
    public GameSolverMastermind() {
        // TODO Auto-generated constructor stub
    }

    public Game solveGame(Game game) {
        MastermindAlgorithm Algo = new MastermindAlgorithm();
        Algo.performArlogrithmics(game);

        return game;
    }

}
