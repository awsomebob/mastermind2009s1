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
 * We will implement a minimax algorithm that can solve a mastermind game
 *
 * The idea is to expand the game tree to the maximum depth, then propagate back
 * the minimum of the maximum etc - alternating which at each alternate level.
 * depth starts off at the desired number of levels to search - when depth is
 * zero, or when a node has no children then the score of that node is returned.
 */
public class MastermindAlgorithm implements Algorithm {

    private byte guessCount;
    public static final int COLOR_COUNT = 4;

    /**
     * Generic game solver. Will check if the game object is a mastermind object
     * and redirect to the mastermind performAlgorithmics function
     */
    public void performAlgorithmics(Game game) {
    }

    /**
     * Mastermind solver
     *
     * @param mastermind
     */
    public void performAlgorithmics(Mastermind mastermind, boolean solveall) {
        // get the settings from the mastermind game
        // solve the matrix if (g == null) {
        MastermindStatus status = mastermind.getMastermindStatus();
        solveMastermind(status, solveall);
        // set our status back so the user can see what happened
        mastermind.setMastermindStatus(status);
    }

    public void solveMastermind(MastermindStatus status, boolean all) {
        MatrixMastermind matrix = status.getMatrixMastermind();
        Cell[][] matrixofrows = matrix.getMatrix();

        int guessCount = 0;
        // start from the bottom
        for (int i = matrixofrows.length - 1; i >= 0; i--) {
            int countvalue = 0;
            boolean solvedarow = false;
            // start from the left

            for (int j = 0; matrixofrows[i].length > j; j++) {
                countvalue += matrixofrows[i][j].getCurrentValue();
            }
            if (countvalue == 0) {
                matrixofrows[i] = takeCalculatedGuess(matrixofrows[i], status);
                if (matrixofrows[i] == null) {
                    // no answer was found
                    System.out.println("I give up, can't make further consistent guesses");
                    break;
                } else {

                }

                MatrixMastermind newmatrix = new MatrixMastermind(matrixofrows);
                status.setMatrixMastermind(newmatrix);
                solvedarow = true;
                guessCount++;
            }
            if (solvedarow) {
                if (!all) {
                    break;
                }
            }
        }
    }

    public Cell[] takeCalculatedGuess(Cell[] row, MastermindStatus status) {
        // analyze the mastermind matrix guesses etc and return the row
        // MatrixMastermind matrix = status.getMatrixMastermind();
        // row = this.produceGuess();
        // for(int i = 0; row.length > i;i++ ){
        // row[i].setCurrentValue(i);
        // }
        //is it the first row?
        int height = status.getMatrixMastermind().getHeight()-1;
        //int width = status.getMatrixMastermind().getWidth();
        //since we are working with a matrix of 4 rows we dont do a foreach
        //good for improvements afterwards
        Cell[][] matrix = status.getMatrixMastermind().getMatrix();
        System.out.println(matrix[height][0].getCurrentValue());
        System.out.println(matrix[height][1].getCurrentValue());
        System.out.println(matrix[height][2].getCurrentValue());
        System.out.println(matrix[height][3].getCurrentValue());
        if((matrix[height][0].getCurrentValue() == 0) &&
            (matrix[height][1].getCurrentValue() == 0) &&
            (matrix[height][2].getCurrentValue() == 0) &&
            (matrix[height][3].getCurrentValue() == 0))
        {
            //first row so take a random guess
            return this.randomGuess();
        } else {

            return this.randomGuess();
        //otherwise we take a more calculated guess based on the results in our matrix/status
        Cell r1 = new Cell(0, false, false);
        Cell r2 = new Cell(0, false, false);
        Cell r3 = new Cell(0, false, false);
        Cell r4 = new Cell(0, false, false);

        //go through all the colors
        for (byte x1 = 0; x1 < COLOR_COUNT; x1++) {
            for (byte x2 = 0; x2 < COLOR_COUNT; x2++) {
                for (byte x3 = 0; x3 < COLOR_COUNT; x3++) {
                    for (byte x4 = 0; x4 < COLOR_COUNT; x4++) {

                        if ((x1 != x2 && x1 != x3 && x1 != x4 && x2 != x3 && x2 != x4 && x3 != x4)) {
                            r1.setCurrentValue(x1);
                            r2.setCurrentValue(x2);
                            r3.setCurrentValue(x3);
                            r4.setCurrentValue(x4);
                            row[0] = r1;
                            row[1] = r2;
                            row[2] = r3;
                            row[3] = r4;

                            //check if the colors are usable
                            //if (g.areAllStonesUsableColors(allowEmptyColor)) {
                                if (guessCount == 0) {
                                    //if we still dont have a guess return out of safety
                                    //normally this is not necessairy
                                    return row;
                                }

                                boolean canReturn = true;
                                for (int y = 0; y < guessCount; y++) {
                                    //here we check if our guess fits all the information that was given in our previous guesses
                                    //so we make sure we dont give guesses that are unnecessairy
                                    if (!result[y].isGuessConsistent(row, allowDuplicateColors)) {
                                        //if our guess is a consistent guess return it
                                        canReturn = false;
                                    }
                                }

                                if (canReturn)
                                    return g;
                            //}

                        }

                    }
                }
            }
        }

        return row;*/

        }
    }

    public Cell[] randomGuess() {
        Cell r1 = new Cell(0, false, false);
        Cell r2 = new Cell(0, false, false);
        Cell r3 = new Cell(0, false, false);
        Cell r4 = new Cell(0, false, false);
        boolean niceStart = false;
        while (!niceStart) {
            Random rnd = new Random();
            // TODO depending on the difficulty - adjust this color number
            r1.setCurrentValue(rnd.nextInt(COLOR_COUNT));
            r2.setCurrentValue(rnd.nextInt(COLOR_COUNT));
            r3.setCurrentValue(rnd.nextInt(COLOR_COUNT));
            r4.setCurrentValue(rnd.nextInt(COLOR_COUNT));
            niceStart = true;
            // we want different colors in every line so we compare all of them
            // and if it's the same we repeat our random generator
            if (r1.getCurrentValue() == r2.getCurrentValue()
                    || r1.getCurrentValue() == r3.getCurrentValue()
                    || r1.getCurrentValue() == r4.getCurrentValue()
                    || r2.getCurrentValue() == r3.getCurrentValue()
                    || r2.getCurrentValue() == r4.getCurrentValue()
                    || r3.getCurrentValue() == r4.getCurrentValue())
            {
                niceStart = false;
            }
            // TODO: for amount of color add a row
        }
        Cell[] row = { r1, r2, r3, r4 };
        return row;
    }

    public boolean isGuessConsistent(Guess G, boolean AllowDuplicateColors) {

        Result r = evaluateGuess(G, guess, AllowDuplicateColors);
        return (r.hit[0] == hit[0] && r.hit[1] == hit[1] && r.hit[2] == hit[2] && r.hit[3] == hit[3]);
    }

}
