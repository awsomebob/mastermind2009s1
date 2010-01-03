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

    private Result[] result;

    public static final int COLOR_COUNT = 8;

    private boolean allowDuplicateColors;

    private boolean allowEmptyColor;

    private MastermindStatus status;

    public MastermindAlgorithm(MastermindStatus status, boolean AllowDuplicateColors,
            boolean AllowEmptyColor) {
        this.status = status;
        result = new Result[status.getMatrixMastermind().getHeight()];
        guessCount = 0;
        allowDuplicateColors = AllowDuplicateColors;
        allowEmptyColor = AllowEmptyColor;
    }

    public void addResult(Result r) {
        result[guessCount] = r;
        guessCount++;
    }

    public boolean isGameOver() {
        return guessCount >= result.length;
    }

    /**
     * Generic game solver. Will check if the game object is a mastermind object
     * and redirect to the mastermind performAlgorithmics function
     */
    public void performAlgorithmics(Game game) {
    }

    public void solveMastermind() {
        MastermindStatus solvedStatus = null;
        solvedStatus = this.status;
        MatrixMastermind matrix = solvedStatus.getMatrixMastermind();
        Cell[][] matrixofrows = matrix.getMatrix();

        System.out.println("We start our mastermind solving algorithm");

        // Print out the result we would like to guess
        System.out.println("Code to find" + status.getValue()[0] + ""
                + status.getValue()[1] + "" + status.getValue()[2] + ""
                + status.getValue()[3]);

        // Take a new guess based on the previous results in our result
        boolean cont = true;
        while (cont) {
            System.out.println("Current guesscount:"+guessCount);
            int CurrentRow = matrixofrows.length - guessCount - 1;
            System.out.println("Current row:"+CurrentRow);
            Guess g = takeCalculatedGuess();
            if (g == null) {
                System.out.println("I give up, can't make further consistent guesses");
                //reset the status
                //solvedStatus = this.status;
                guessCount = 0;
                cont = true;
            } else {
                System.out.println(g.toString());
                System.out
                        .println("Result? (1 = Exact hit, 0 = Hit, but wrong place)");
                matrixofrows[CurrentRow] = g.getCells();
                // Ask milovan if he wants to change the status functions so
                // we can check the correctpositions straight on a
                // combinations of cells
                status.setCurrentRow(CurrentRow);

                System.out.println(matrixofrows[CurrentRow][0].getCurrentValue()+" ; "+
                                   matrixofrows[CurrentRow][1].getCurrentValue()+" ; "+
                                   matrixofrows[CurrentRow][2].getCurrentValue()+" ; "+
                                   matrixofrows[CurrentRow][3].getCurrentValue()+" ; "
                                   );

                // fully correct
                int numCorrColorAndPosition = status.numCorrectPosition();
                // half correct
                int numCorrColor = status.numWrongPosition();

                System.out.println("Correct colors :" + numCorrColor);
                System.out.println("Correct colors and position :"
                        + numCorrColorAndPosition);

                /*InputStreamReader converter = new InputStreamReader(System.in);
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
                }*/
                Hit[] hit = new Hit[4];
                for(int i = 0; i < numCorrColorAndPosition; i++){
                    hit[i] = Hit.FULL;
                }

                for(int i = numCorrColorAndPosition; i < numCorrColor+numCorrColorAndPosition; i++){
                    hit[i] = Hit.HALF;
                }
                System.out.println(hit[0]+""+hit[1]+""+hit[2]+""+hit[3]);


                Result r = new Result(g, hit);

                if (r.completeHit()) {
                    System.out.println("I won!");
                    this.status = solvedStatus;
                    cont = false;
                } else {
                    // add our guess in history
                    addResult(r);
                    if (isGameOver()) {
                        System.out.println("I give up, end of board");
                        cont = false;
                    }
                } // if CompleteHit

                // MatrixMastermind newmatrix = new
                // MatrixMastermind(matrixofrows);
                // status.setMatrixMastermind(newmatrix);
            }
        }
    }

    public Guess takeCalculatedGuess() {
        Guess ret = new Guess();
        // analyze the mastermind matrix guesses etc and return the row
        // good for improvements afterwards

        if (guessCount == 0) {
            ret = randomGuess();
            System.out.println(ret.toString());
            return ret;
        }

        for (byte x1 = 0; x1 < COLOR_COUNT; x1++) {
            for (byte x2 = 0; x2 < COLOR_COUNT; x2++) {
                for (byte x3 = 0; x3 < COLOR_COUNT; x3++) {
                    for (byte x4 = 0; x4 < COLOR_COUNT; x4++) {

                        if (allowDuplicateColors
                                || (!allowDuplicateColors && x1 != x2
                                        && x1 != x3 && x1 != x4 && x2 != x3
                                        && x2 != x4 && x3 != x4)) {
                            Guess g = new Guess(x1, x2, x3, x4);

                            if (g.areAllCellsUsableColors(allowEmptyColor)) {
                                if (guessCount == 0)
                                    return g;

                                boolean canReturn = true;
                                for (int y = 0; y < guessCount; y++) {
                                    if (!result[y].isGuessConsistent(g,
                                            allowDuplicateColors))
                                        canReturn = false;
                                }

                                if (canReturn)
                                    return g;
                            }

                        }

                    }
                }
            }
        }

        return null;
    }

    /**
     * Based on the algorithm of donald knuth
     *
     * @return
     */
    public Guess firstGuess() {
        int r1 = 1;
        int r2 = 1;
        int r3 = 2;
        int r4 = 2;
        Guess ret = new Guess(r1, r2, r3, r4);
        return ret;
    }

    public Guess randomGuess() {
        int r1 = 0;
        int r2 = 0;
        int r3 = 0;
        int r4 = 0;
        boolean niceStart = false;
        while (!niceStart) {
            Random rnd = new Random();
            r1 = rnd.nextInt(COLOR_COUNT);
            r2 = rnd.nextInt(COLOR_COUNT);
            r3 = rnd.nextInt(COLOR_COUNT);
            r4 = rnd.nextInt(COLOR_COUNT);

            niceStart = true;
            if (r1 == r2 || r1 == r3 || r1 == r4 || r2 == r3 || r2 == r4
                    || r3 == r4)
                niceStart = false;
        }
        Guess ret = new Guess(r1, r2, r3, r4);
        return ret;
    }
}
