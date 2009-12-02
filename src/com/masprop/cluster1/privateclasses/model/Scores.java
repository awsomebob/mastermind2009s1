package com.masprop.cluster1.privateclasses.model;

import com.masprop.cluster1.privateclasses.model.diskmanager.MastermindScoreFileParser;
import com.masprop.cluster1.shared.model.GameLevelType;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * This class contents the best 10 scores for appropriate level of difficulty
 *
 * @author Milan Stanic
 */
public class Scores {

    /**
     * top 10 results for appropriate level
     */
    private static int LIMIT = 10;

    private ArrayList<Score> scores;

    /**
     * Class constructor purpose for testing
     */
    public Scores() {
        this.scores = new ArrayList<Score>();
    }

    public Scores(ArrayList<Score> scores) {
        this.setScores(scores);
    }

    /**
     * Class constructor.
     *
     * @param gameLevelType
     *            difficulty level
     * @param parser
     *            returns array of the best 10 results
     */
    public Scores(MastermindScoreFileParser parser, GameLevelType gameLevelType) {
        // in parser we need to have method which reads appropriate
        // file with score and returns array of 10 the best result
        scores = parser.getScoreFromFile(gameLevelType).scores;
    }

    /**
     * @param score
     *            score of current game
     * @return current position of score in top 10 or -1 if that score is not in
     *         top 10
     */
    public int getScore(int score) {
        int position = -1;
        for (Score s : this.scores) {
            if (score < s.getScore()) {
                // put it in the arraylist in this position and then quit the
                // foreach
                position = scores.indexOf(s);
                break;
            }
        }
        /*
         * int temp = 1; for(temp=1; temp<=10; temp++){ if(score < scores[9]){
         * temp = -1; break; } if(score > scores[temp-1]) break; }
         */
        return position;
    }

    /**
     * @param score
     *            score of current game
     * @param position
     *            current position for score
     */
    public void setScore(Score score, int position) {
        scores.add(position, score);
        /*
         * for(int i=9; i>=position; i--){ scores[i] = scores[i-1]; }
         * scores[position-1] = score;
         */
    }

    /**
     * @param score
     *            score of current game
     */
    public void addScore(Score score) {
        // check if the object is a score
        if ((score.getName() != null) && (score.getScore() != 0)) {
            this.scores.add(score);
        }
        this.sortScores();
        this.cutToLimit(LIMIT);
        /*
         * for(int i=9; i>=position; i--){ scores[i] = scores[i-1]; }
         * scores[position-1] = score;
         */
    }

    /**
     *
     * @return top 10 scores for current level
     */
    public ArrayList<Score> getScores() {
        return scores;
    }

    /**
     *
     * @param scores
     *            top 10 scores for current level
     */
    public void setScores(ArrayList<Score> scores) {
        this.scores = scores;
    }

    /**
     * Function should be able to sort an Arraylist of scores
     *
     */
    public void sortScores() {
        Object[] arrScores = scores.toArray();
        Arrays.sort(arrScores);
        ArrayList<Score> scores = new ArrayList<Score>();
        for (Object o : arrScores) {
            // convert to score
            Score score = (Score) o;
            scores.add(score);
        }
        this.scores = scores;
        // sort the arraylist of scores
    }

    public void cutToLimit(int max) {
        if (this.scores.size() >= max) {
            for (int i = max-1; i < this.scores.size(); i++) {
                this.scores.remove(i);
            }
        }
    }
}