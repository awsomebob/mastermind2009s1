package com.masprop.cluster1.privateclasses.model;

import com.masprop.cluster1.shared.controller.Algorithm;
import com.masprop.cluster1.shared.model.Game;

/**
 * @author nick
 * @version 0.1
 *
 * We will implement a minimax algorithm that can solve
 * a mastermind game
 *
 * The idea is to expand the game tree to the
 * maximum depth, then propagate back the
 * minimum of the maximum etc - alternating
 * which at each alternate level.
 * depth starts off at the desired number of levels
 * to search - when depth is zero, or when a node has
 * no children then the score of that node is returned.
 */
public class MastermindAlgorithm implements Algorithm {

    /**
     * Generic game solver.
     * Will check if the game object is a mastermind object and redirect to the mastermind
     * performAlgorithmics function
     */
    public void performAlgorithmics(Game game) {
        // TODO Auto-generated method stub

    }

    /**
     * Mastermind solver
     * @param mastermind
     */
    public void performAlgorithmics(Mastermind mastermind) {
        // TODO Auto-generated method stub
        //Solve the game here!
    }

	@Override
	public void performArlogrithmics(Game game) {
		// TODO Auto-generated method stub
		
	}

}
