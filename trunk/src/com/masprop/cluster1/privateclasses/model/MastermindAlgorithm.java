package com.masprop.cluster1.privateclasses.model;

import java.util.Random;

import com.masprop.cluster1.shared.controller.Algorithm;
import com.masprop.cluster1.shared.model.Cell;
import com.masprop.cluster1.shared.model.Game;
import com.masprop.cluster1.shared.model.GameLevelType;
import com.masprop.cluster1.privateclasses.model.Result;

/**
 * @author Nick Veenhof
 * @version 1
 *
 * We will implement a minimax algorithm that can solve a mastermind game
 *
 * The idea is to expand the game tree to the maximum depth, then propagate back
 * the minimum of the maximum etc - When a score is found that equals the score
 * that we just achieved (calculated by the hints) then this is returned. This
 * way we filter our posibbilities that are already excluded from our game and
 * don't give us new hints.
 */
public class MastermindAlgorithm implements Algorithm {

    /* the byte that keeps the counting of how many guesses it already did */
    private byte guessCount;

    /* our result array in which we store our information about the guess */
    private Result[] result;

    /*
     * Max amount of colors, we keep it at 9 because 0 does not count and there
     * is hardly a performance issue so we don't have to code different
     * difficulty levels
     */
    public int color_count;


    /* Used to eliminate the empty color (value 0) from our guessing attempts */
    private boolean allowEmptyColor = false;

    /*
     * Used to save our status. We don't use the solution for taking a guess.
     * Only used as a evaluation term
     */
    private MastermindStatus status;

    /**
     * Constructor for the MastermindAlgorithm class
     *
     * @param status
     *            of the mastermind game to check the properties of the game
     *            that we want to solve
     */
    public MastermindAlgorithm(MastermindStatus status, GameLevelType levelType) {
        this.status = status;
        result = new Result[status.getMatrixMastermind().getHeight()];
        //0-3 easy, 0-4 medium, 0-5 difficult
        if(levelType == GameLevelType.EASY){
            color_count = 4;
        }
        if(levelType == GameLevelType.MEDIUM){
            color_count = 5;
        }
        if(levelType == GameLevelType.DIFFICULT){
            color_count = 6;
        }
        //color_count = 8;
    }

    /**
     * Add a result to the result array for saving a history of the computer
     * guesses
     *
     * @param result
     */
    public void addResult(Result r) {
        result[guessCount] = r;
        guessCount++;
    }

    /**
     * Check if we should stop making guesses or start from a new random guess
     * for better luck
     *
     * @return
     */
    public boolean isGameOver() {
        return guessCount >= result.length;
    }

    /**
     * Generic game solver. Will check if the game object is a mastermind object
     * and redirect to the mastermind performAlgorithmics function
     */
    public void performAlgorithmics(Game game) {
    }

    /**
     * Main function to solve our mastermind riddle
     *
     * 1. Takes a new random guess
     *
     * 2. Validate the guess against the score (check white pegs/black pegs
     *
     * 3.Take a new guess based on the previous validation and filter our
     * possibilities that are not possible
     *
     * 4. go to step 2 if it is not the complete solution
     *
     * 5. When the whole board has been guessed we return the status object with
     * the rows of our guessing
     */
    public void solveMastermind() {
        MastermindStatus solvedStatus = null;
        solvedStatus = this.status;
        MatrixMastermind matrix = solvedStatus.getMatrixMastermind();
        Cell[][] matrixofrows = matrix.getMatrix();

        // Take a new guess based on the previous results in our result
        boolean cont = true;

        while (cont) {
            // System.out.println("Current guesscount:" + guessCount);
            int CurrentRow = guessCount;
            // System.out.println("Current row:" + CurrentRow);
            Guess g = takeCalculatedGuess();
            if (g == null) {
                // we failed to find it so try again with a new random start

                // reset the status rows
                for (int j = 0; j < matrixofrows.length; j++) {
                    for (int k = 0; k < matrixofrows[j].length; k++) {
                        matrixofrows[j][k].setCurrentValue(0);
                    }
                }
                guessCount = 0;
                cont = true;
            } else {
                // System.out.println(g.toString());
                // System.out.println("Result? (1 = Exact hit, 0 = Hit, but
                // wrong place)");
                matrixofrows[CurrentRow] = g.getCells();
                status.setCurrentRow(CurrentRow);

                // get our validator from the status class
                // fully correct
                int numCorrColorAndPosition = status.numCorrectPosition();
                // half correct
                int numCorrColor = status.numWrongPosition();

                // System.out.println("Correct colors :" + numCorrColor);
                // System.out.println("Correct colors and position :"
                // + numCorrColorAndPosition);

                // manual intervention could happen here to say how many are
                // correct and how many are not..! (like HALFHALFFULL)
                Hit[] hit = new Hit[4];
                for (int i = 0; i < numCorrColorAndPosition; i++) {
                    hit[i] = Hit.FULL;
                }

                for (int i = numCorrColorAndPosition; i < numCorrColor
                        + numCorrColorAndPosition; i++) {
                    hit[i] = Hit.HALF;
                }

                // System.out.println(hit[0] + "" + hit[1] + "" + hit[2] + ""
                // + hit[3]);

                Result r = new Result(g, hit);

                if (r.completeHit()
                        || (g.getCells()[0].getCurrentValue() == status
                                .getValue()[0]
                                && g.getCells()[1].getCurrentValue() == status
                                        .getValue()[1]
                                && g.getCells()[2].getCurrentValue() == status
                                        .getValue()[2] && g.getCells()[3]
                                .getCurrentValue() == status.getValue()[3])) {
                    System.out.println("I won!");
                    this.status = solvedStatus;
                    cont = false;
                } else {
                    // add our guess in history
                    addResult(r);
                    if (isGameOver()) {
                        // System.out.println("I give up, end of board");
                        cont = false;
                    }
                } // if CompleteHit
            }
        }
    }

    /**
     * Takes a guess based on the information from previous guesses
     *
     * @return a Guess object (a row of 4 filled with colors)
     */
    public Guess takeCalculatedGuess() {
        // make a new guess object which will contain ouor guess
        Guess ret = new Guess();

        // analyze the mastermind matrix guesses etc and return the row
        // if it is our first guess we return a random guess and see from there.
        if (guessCount == 0) {
            ret = randomGuess();

            // cannot solve 1 4 2 1
            // ret = firstGuess();
            return ret;
        }

        /**
         * Loop through all the possibilities and try to make it a guess. if the
         * guess has usable colors (this is include white colors or not) then we
         * continue to validate the guess with the isGuessConsistent we check if
         * the current score that we assign to a guess is at least equal to the
         * guess attempts that have been made. For more info see the
         * documentation manual.
         */
        for (byte x1 = 0; x1 <= color_count; x1++) {
            for (byte x2 = 0; x2 <= color_count; x2++) {
                for (byte x3 = 0; x3 <= color_count; x3++) {
                    for (byte x4 = 0; x4 <= color_count; x4++) {

                        Guess g = new Guess(x1, x2, x3, x4);

                        if (g.areAllCellsUsableColors(allowEmptyColor)) {
                            if (guessCount == 0)
                                return g;

                            boolean canReturn = true;
                            /* for all the guesses that are already made
                             * check if the new guess is consistent with the old guesses
                             */
                            for (int y = 0; y < guessCount; y++) {
                                if (!result[y].isGuessConsistent(g))
                                    canReturn = false;
                            }

                            if (canReturn)
                                return g;
                        }

                    }
                }
            }
        }

        // if we did not found any possible combination it means that our
        // algorithm was not smart enough to solve the game
        return null;
    }

    /**
     * Based on the algorithm of donald knuth (see wikipedia). We are not using it because it
     * does not always find a solution.. Algorithm needs more improvement to be
     * able to get this working
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

    /**
     * Return a random guess but this guess should not have equal values so we
     * can have a good start
     *
     * @return
     */
    public Guess randomGuess() {
        int r1 = 0;
        int r2 = 0;
        int r3 = 0;
        int r4 = 0;
        boolean goodStart = false;
        while (!goodStart) {
            Random rnd = new Random();
            r1 = rnd.nextInt(color_count);
            r2 = rnd.nextInt(color_count);
            r3 = rnd.nextInt(color_count);
            r4 = rnd.nextInt(color_count);

            goodStart = true;
            //if (r1 == r2 || r1 == r3 || r1 == r4 || r2 == r3 || r2 == r4
            //        || r3 == r4)
            if (r1 == r2 || r1 == r3 || r1 == r4 )
                goodStart = false;
        }
        Guess ret = new Guess(r1, r2, r3, r4);
        return ret;
    }
}
