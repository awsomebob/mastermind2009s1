package com.masprop.cluster1.privateclasses.model;

import com.masprop.cluster1.privateclasses.model.diskmanager.MastermindScoreFileParser;
import com.masprop.cluster1.shared.model.GameLevelType;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * This class contents the best 10 scores for appropriate level of difficulty
 * And sorts them when a score is added
 *
 * @author Nick Veenhof
 * @see Score
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

    /**
     * Class constructor to instantiate and set our ArrayList of scores
     *
     * @param scores
     */
    public Scores(ArrayList<Score> scores) {
        this.setScores(scores);
    }

    /**
     * Class constructor to instantiate and set our fileParser and the level
     * type Retrieves the scores from the file and sets them in our object
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
     * Gets the position of a given score in the top10
     * @param score
     *            score of current game
     * @return current position of score in top 10 or -1 if that score is not in
     *         top 10
     */
    public int getScore(int score) {
        int position = -1;
        for (Score s : this.scores) {
            if (score > s.getScore()) {
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
     * Sets a given score in a certain position
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
     * Adds a score and sorts the scorelist accordingly
     * Cuts the list to the limit
     * @param score
     *            score of current game
     * @see LIMIT
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
     * Gets our scores
     * @return top 10 scores for current level
     */
    public ArrayList<Score> getScores() {
        return scores;
    }

    /**
     * Sets our scores
     * @param scores
     *            top 10 scores for current level
     */
    public void setScores(ArrayList<Score> scores) {
        this.scores = scores;
    }

    /**
     * Sorts scores in the list
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

    /**
     * Cuts a scores Arraylist to the maximum defined number
     * @param max Maximum of scores allowed in our file
     */
    public void cutToLimit(int max) {
        if (this.scores.size() >= max) {
            for (int i = max - 1; i < this.scores.size(); i++) {
                this.scores.remove(i);
            }
        }
    }
}
