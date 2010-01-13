package com.masprop.cluster1.privateclasses.model;

/**
 * Validates results and checks if a guess was correct. By checking we mean that
 * it returns if a taken guess is not a good guess because it does not comply
 * with the previous guesses. This states that any new guess should have atleast
 * the same score as the previous guess based on the information we gathered so
 * far.
 *
 * @author Nick Veenhof
 */
public class Result {

    // our result
    public Hit[] hit;

    // our guess
    public Guess guess;

    /**
     * Constructor Initializer for the result class
     */
    public Result() {
        init();
    }

    /**
     * Overloading of the Constructor of the result class
     *
     * @param G
     *            guess
     * @param hit
     *            hit array
     */
    public Result(Guess G, Hit[] hit) {
        init();
        guess = G;
        this.hit = hit;
    }

    /**
     * Check if the guess is spot on! So if we found our result.
     *
     * @return
     */
    public boolean completeHit() {
        return ((hit[0] == Hit.FULL) && (hit[1] == Hit.FULL)
                && (hit[2] == Hit.FULL) && (hit[3] == Hit.FULL));
    }

    /**
     * initializer for the result class Generates a hit array of 4 and makes a
     * new Guess object
     */
    private void init() {
        hit = new Hit[4];
        guess = new Guess();
    }

    /**
     * Evaluate the guess and check if our score of a new guess is atleast equal
     * to the previous guesses. More information in the minmax implementation
     * This class can be executed without having initiated a result object. It
     * generates an object if needed
     *
     * @param comparedGuess
     *            (Older guess)
     * @param currentGuess
     *            (New Guess)
     * @return
     */
    public static Result evaluateGuess(Guess comparedGuess, Guess currentGuess) {
        // create new result object
        Result ret = new Result();
        // set our new guess in the object
        ret.guess = currentGuess;
        // create an boolean array to see how this new guess performs
        boolean[] evaluated = new boolean[4];
        // marks position in the array of hits
        int hitPos = 0;

        /*
         * Match the comparedGuess (older guess) to the given Guess. for all the
         * cells in the guess compare the colors. used to set our full hits This
         * can return false positives. It is still up to us to get the correct
         * value out of the generated values table by selecting a value that at
         * least has the same score as our max score of one of the guesses.
         */
        for (int n = 0; n < comparedGuess.getCells().length; n++) {

            int ComparedColor = comparedGuess.getCells()[n].getCurrentValue();
            int GuessColor = currentGuess.getCells()[n].getCurrentValue();

            // if the color and position is the same as in our previous guess
            // then we have a full hit
            if (ComparedColor == GuessColor) {
                // set our hit information
                ret.hit[hitPos] = Hit.FULL;
                // set our evaluation array
                evaluated[n] = true;
                hitPos++;
            }
        }

        /*
         * Generate a scorelist of the half hits so far. The more results we
         * have the longer this list will become.
         */
        for (int n = 0; n < comparedGuess.getCells().length; n++) {
            if (!evaluated[n]) {
                for (int m = 0; m < currentGuess.getCells().length; m++) {
                    if (!evaluated[n] && n != m) {
                        int ComparedColor = comparedGuess.getCells()[n]
                                .getCurrentValue();
                        int GuessColor = currentGuess.getCells()[m]
                                .getCurrentValue();
                        if (ComparedColor == GuessColor) {
                            ret.hit[hitPos] = Hit.HALF;
                            evaluated[n] = true;
                            hitPos++;
                            m = currentGuess.getCells().length + 1;
                        }
                    }
                }
            }
        }

        // return guess evaluation
        return ret;
    }

    /**
     * Functions is executed multiple times to make sure the outcome is not the
     * same as previous evaluations If we allow this it could be that we end in
     * infinite loops and we dont want that
     *
     * @param G
     *            Guess
     * @return Boolean true if guess is consistent to be returned
     */
    public boolean isGuessConsistent(Guess G) {
        Result r = evaluateGuess(G, guess);
        return ((r.hit[0] == hit[0]) && (r.hit[1] == hit[1])
                && (r.hit[2] == hit[2]) && (r.hit[3] == hit[3]));
    }
}
