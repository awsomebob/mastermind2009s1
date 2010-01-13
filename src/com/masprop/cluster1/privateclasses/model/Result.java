package com.masprop.cluster1.privateclasses.model;

/**
 * Validates results and checks if a guess was correct. By checking we mean that
 * it returns if a taken guess is not a good guess because it does not comply
 * with the previous guesses. This states that any new guess should have atleast
 * the same score as the previous guess based on the information we gathered so
 * far.
 * @author Nick Veenhof
 */
public class Result {

    // our result
    public Hit[] hit;

    // our guess
    public Guess guess;

    public Result() {
        init();
    }

    public Result(Guess G, Hit[] hit) {
        init();
        guess = G;
        this.hit = hit;
    }

    public boolean completeHit() {
        return ((hit[0] == Hit.FULL) && (hit[1] == Hit.FULL)
                && (hit[2] == Hit.FULL) && (hit[3] == Hit.FULL));
    }

    private void init() {
        hit = new Hit[4];
        guess = new Guess();
    }

    /**
     * Evaluate the guess and check if our score of a new guess is atleast equal
     * to the previous guesses. More information in the minmax implementation
     *
     * @param comparedGuess
     * @param currentGuess
     * @param AllowDuplicateColors
     * @return
     */
    public static Result evaluateGuess(Guess Correct, Guess Guess) {
        Result ret = new Result();
        ret.guess = Guess;
        boolean[] evaluated = new boolean[4];
        int hitPos = 0;

        for (int n = 0; n < Correct.getCells().length; n++) {
            // we need twice n!
            int CorrectColor = Correct.getCells()[n].getCurrentValue();
            int GuessColor = Guess.getCells()[n].getCurrentValue();
            if (CorrectColor == GuessColor) {
                ret.hit[hitPos] = Hit.FULL;
                evaluated[n] = true;
                hitPos++;
            }
        }

        for (int n = 0; n < Correct.getCells().length; n++) {
            if (!evaluated[n]) {
                for (int m = 0; m < Guess.getCells().length; m++) {
                    if (!evaluated[n] && n != m) {
                        int CorrectColor = Correct.getCells()[n]
                                .getCurrentValue();
                        int GuessColor = Guess.getCells()[m].getCurrentValue();
                        if (CorrectColor == GuessColor) {
                            ret.hit[hitPos] = Hit.HALF;
                            evaluated[n] = true;
                            hitPos++;
                            m = Guess.getCells().length + 1;
                        }
                    }
                }
            }
        }

        return ret;
    }

    /**
     *
     * @param correct
     * @param AllowDuplicateColors
     * @return Functions is executed multiple times to make sure the outcome is
     *         not the same as previous evaluations If we allow this it could be
     *         that we end in infinite loops and we dont want that
     */
    public boolean isGuessConsistent(Guess G) {
        Result r = evaluateGuess(G, guess);
        return ((r.hit[0] == hit[0]) && (r.hit[1] == hit[1])
                && (r.hit[2] == hit[2]) && (r.hit[3] == hit[3]));
    }
}
