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

    public void performAlgorithmics(Game game) {
        // TODO Auto-generated method stub

    }


    public void performAlgorithmics(Mastermind mastermind) {
        // TODO Auto-generated method stub

    }

}
