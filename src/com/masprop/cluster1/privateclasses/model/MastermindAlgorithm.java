package com.masprop.cluster1.privateclasses.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

import com.masprop.cluster1.shared.controller.Algorithm;
import com.masprop.cluster1.shared.model.Cell;
import com.masprop.cluster1.shared.model.Game;
import com.masprop.cluster1.privateclasses.model.Result;

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

    public static final int COLOR_COUNT = 8;
    private Result[] result;

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
    public void performAlgorithmics(Mastermind mastermind, boolean solveall, boolean allowDuplicateColors) {
        // get the settings from the mastermind game
        // solve the matrix if (g == null) {
        result = new Result[10];
        guessCount = 0;

        MastermindStatus status = mastermind.getMastermindStatus();
        solveMastermind(status, solveall, allowDuplicateColors);
        // set our status back so the user can see what happened
        mastermind.setMastermindStatus(status);

    }

    public void solveMastermind(MastermindStatus status, boolean all, boolean allowDuplicateColors) {
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

                // Take a new guess based on the previous results in our result
                // row
                matrixofrows[i] = takeCalculatedGuess(matrixofrows[i], status, allowDuplicateColors);
                if (matrixofrows[i] == null) {

                    // no answer was found
                    System.out
                            .println("I give up, can't make further consistent guesses");
                            Cell[] cellrow = new Cell[4];
                            Cell c1 = new Cell(0, false, false);
                            Cell c2 = new Cell(0, false, false);
                            Cell c3 = new Cell(0, false, false);
                            Cell c4 = new Cell(0, false, false);
                            cellrow[0] =c1;
                            cellrow[1] =c2;
                            cellrow[2] =c3;
                            cellrow[3] =c4;
                            matrixofrows[i] = cellrow;
                    break;
                } else {
                    System.out.println("Computer guess"
                            + matrixofrows[i][0].getCurrentValue() + ""
                            + matrixofrows[i][1].getCurrentValue() + ""
                            + matrixofrows[i][2].getCurrentValue() + ""
                            + matrixofrows[i][3].getCurrentValue());
                    // set the current row in the status for easy access to our
                    // row numbers
                    status.setCurrentRow(i);

                    // fully correct
                    int numCorrColorAndPosition = status.numCorrectPosition();
                    // half correct
                    int numCorrColor = status.numWrongPosition();

                    System.out.println("Code to find" + status.getValue()[0]
                            + "" + status.getValue()[1] + ""
                            + status.getValue()[2] + "" + status.getValue()[3]);
                    System.out
                            .println("Result? (1 = Exact hit, 0 = Hit, but wrong place)");
                    System.out.println("Correct colors :" + numCorrColor);
                    System.out.println("Correct colors and position :"
                            + numCorrColorAndPosition);

                    InputStreamReader converter = new InputStreamReader(
                            System.in);
                    BufferedReader in = new BufferedReader(converter);
                    String x = "";
                    try {
                        x = in.readLine();
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }

                    Hit[] hit = new Hit[4];

                    for (byte n = 0; n < x.length(); n++) {
                        hit[n] = x.substring(n, n + 1).equals("1") ? Hit.FULL
                                : Hit.HALF;
                    }

                     /*for (int j = 0; j < numCorrColor;
                         j++) { hit[j] = Hit.HALF;
                     }
                     for (int j = 0; j < numCorrColorAndPosition; j++) {
                         hit[j] = Hit.FULL;
                     }*/

                    Result r = new Result(matrixofrows[i], hit);
                    if (r.completeHit()) {
                        System.out.println("I won!");
                        break;
                        //keepPlaying = yesOrNo("Keep playing?");
                        // cont = false;
                    } else {
                        //add our guess in history
                        result[this.guessCount] = r;
                        this.guessCount++;

                        // if the end of our board is reached quit playing
                        if (this.guessCount >= matrixofrows.length) {
                            System.out.println("I give up, end of board");
                        }
                    } // if CompleteHit
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

    public Cell[] takeCalculatedGuess(Cell[] guess, MastermindStatus status, boolean allowDuplicateColors) {
        // analyze the mastermind matrix guesses etc and return the row
        // MatrixMastermind matrix = status.getMatrixMastermind();
        // row = this.produceGuess();
        // for(int i = 0; row.length > i;i++ ){
        // row[i].setCurrentValue(i);
        // }
        // is it the first row?
        int height = status.getMatrixMastermind().getHeight() - 1;
        // int width = status.getMatrixMastermind().getWidth();
        // since we are working with a matrix of 4 rows we dont do a foreach
        // good for improvements afterwards
        Cell[][] matrix = status.getMatrixMastermind().getMatrix();
        // if it is the first row and this is empty return a first guess
        if ((matrix[height][0].getCurrentValue() == 0)
                && (matrix[height][1].getCurrentValue() == 0)
                && (matrix[height][2].getCurrentValue() == 0)
                && (matrix[height][3].getCurrentValue() == 0)) {

            Cell[] randomGuess = this.randomGuess();
            //Cell[] randomGuess = this.firstGuess();
            return randomGuess;

        } else {
            // otherwise we take a more calculated guess based on the results in
            // our matrix/status
            Cell r1 = new Cell(0, false, false);
            Cell r2 = new Cell(0, false, false);
            Cell r3 = new Cell(0, false, false);
            Cell r4 = new Cell(0, false, false);

            // go through all the colors
            for (byte x1 = 0; x1 < COLOR_COUNT; x1++) {
                for (byte x2 = 0; x2 < COLOR_COUNT; x2++) {
                    for (byte x3 = 0; x3 < COLOR_COUNT; x3++) {
                        for (byte x4 = 0; x4 < COLOR_COUNT; x4++) {

                            if (allowDuplicateColors
                                    || (!allowDuplicateColors && x1 != x2
                                            && x1 != x3 && x1 != x4 && x2 != x3
                                            && x2 != x4 && x3 != x4))
                            {

                                r1.setCurrentValue(x1);
                                r2.setCurrentValue(x2);
                                r3.setCurrentValue(x3);
                                r4.setCurrentValue(x4);
                                guess[0] = r1;
                                guess[1] = r2;
                                guess[2] = r3;
                                guess[3] = r4;

                                if (this.guessCount == 0) {
                                    // if we still dont have a guess return out
                                    // of safety
                                    // normally this is not necessairy
                                    return guess;
                                }

                                boolean canReturn = true;
                                for (int y = 0; y < this.guessCount; y++) {
                                    // here we check if our guess fits all the
                                    // information that was given in our
                                    // previous guesses
                                    // so we make sure we dont give guesses that
                                    // are unnecessairy
                                    if (!result[y].isGuessConsistent(guess,
                                            false)) {
                                        canReturn = false;
                                    }
                                }

                                if (canReturn) {
                                    // if our guess is a consistent guess return
                                    // it
                                    return guess;
                                }

                            }

                        }
                    }
                }
            }

            return null;

        }
    }

    /**
     * Based on the algorithm of donald knuth
     *
     * @return
     */
    public Cell[] firstGuess() {
        Cell r1 = new Cell(0, false, false);
        Cell r2 = new Cell(0, false, false);
        Cell r3 = new Cell(1, false, false);
        Cell r4 = new Cell(1, false, false);
        Cell[] guess = { r1, r2, r3, r4 };
        return guess;
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
                    || r3.getCurrentValue() == r4.getCurrentValue()) {
                niceStart = false;
            }
            // TODO: for amount of color add a row
        }
        Cell[] guess = { r1, r2, r3, r4 };
        return guess;
    }

}
