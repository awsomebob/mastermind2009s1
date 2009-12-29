package com.masprop.cluster1.privateclasses.model;

import java.util.Iterator;
import java.util.Random;

import mastermindsolver.Guess;
import mastermindsolver.Result;
import mastermindsolver.Stone;

import com.masprop.cluster1.shared.controller.Algorithm;
import com.masprop.cluster1.shared.model.Cell;
import com.masprop.cluster1.shared.model.Game;

/**
 * @author Nick Veenhof
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

    private byte guessCount;
    public static final int COLOR_COUNT = 4;

    /**
     * Generic game solver.
     * Will check if the game object is a mastermind object and redirect to the mastermind
     * performAlgorithmics function
     */
    public void performAlgorithmics(Game game) {
    }

    /**
     * Mastermind solver
     * @param mastermind
     */
    public void performAlgorithmics(Mastermind mastermind) {
        //get the settings from the mastermind game
        //solve the matrix
        MastermindStatus status = mastermind.getMastermindStatus();
        solveMastermind(status, true);
        //set our status back so the user can see what happened
        mastermind.setMastermindStatus(status);
    }

    public void solveMastermind(MastermindStatus status, boolean all) {
        MatrixMastermind matrix = status.getMatrixMastermind();
        Cell[][] matrixofrows = matrix.getMatrix();

        int guessCount = 0;
        //start from the bottom
        for(int i = matrixofrows.length-1; i >= 0 ; i--){
            int countvalue = 0;
            boolean solvedarow = false;
            //start from the left

            for(int j = 0; matrixofrows[i].length > j; j++){
                countvalue += matrixofrows[i][j].getCurrentValue();
            }
            if(countvalue == 0){
                matrixofrows[i] = takeCalculatedGuess(matrixofrows[i], status );
                MatrixMastermind newmatrix = new MatrixMastermind(matrixofrows);
                status.setMatrixMastermind(newmatrix);
                solvedarow = true;
                guessCount++;
            }
            if(solvedarow){
                if(!all){
                    break;
                }
            }
        }
    }

    public Cell[] takeCalculatedGuess(Cell[] row, MastermindStatus status){
        //analyze the mastermind matrix guesses etc and return the row
        //MatrixMastermind matrix = status.getMatrixMastermind();
        for(int i = 0; row.length > i;i++ ){
            row[i].setCurrentValue(i);
        }
        return row;

    }

    public Guess produceGuess() {
        Guess ret = new Guess();

        if (guessCount == 0) {
            int r1 = 0;
            int r2 = 0;
            int r3 = 0;
            int r4 = 0;
            boolean niceStart = false;
            while (!niceStart) {
                Random rnd = new Random();
                //TODO depending on the difficulty - adjust this color number
                r1 = rnd.nextInt(COLOR_COUNT);
                r2 = rnd.nextInt(COLOR_COUNT);
                r3 = rnd.nextInt(COLOR_COUNT);
                r4 = rnd.nextInt(COLOR_COUNT);
                niceStart = true;
                //we want different colors to start with so we compare all of them and if it's the same we repeat our random generator
                if (r1 == r2 || r1 == r3 || r1 == r4 || r2 == r3 || r2 == r4 || r3 == r4) niceStart = false;
            }
            return new Guess(r1, r2, r3, r4);
        }

        for (byte x1 = 0; x1 < COLOR_COUNT; x1++){
            for (byte x2 = 0; x2 < COLOR_COUNT; x2++) {
                for (byte x3 = 0; x3 < COLOR_COUNT; x3++) {
                    for (byte x4 = 0; x4 < COLOR_COUNT; x4++) {

                        //dont allow duplicate colors
                        if (x1 != x2 && x1 != x3 && x1 != x4 && x2 != x3 && x2 != x4 && x3 != x4) {

                            Guess g = new Guess(x1, x2, x3, x4);
                            if (guessCount == 0) {
                                return g;
                            }
                            boolean canReturn = true;
                            for (int y = 0; y < guessCount; y++) {
                              if (!result[y].isGuessConsistent(g, allowDuplicateColors)) {
                                  canReturn = false;
                              }
                            }
                            if (canReturn) {
                                return g;
                            }

                        }


                    }
                }
            }
        }

        return null;
    }

    public boolean isGuessConsistent(Guess G, boolean AllowDuplicateColors) {

        Result r = evaluateGuess(G, guess, AllowDuplicateColors);
        return (r.hit[0] == hit[0] &&
                r.hit[1] == hit[1] &&
                r.hit[2] == hit[2] &&
                r.hit[3] == hit[3]);
    }




}
