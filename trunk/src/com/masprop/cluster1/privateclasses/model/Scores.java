package com.masprop.cluster1.privateclasses.model;
import com.masprop.cluster1.privateclasses.model.diskmanager.MastermindScoreFileParser;
import com.masprop.cluster1.shared.model.GameLevelType;
import java.util.ArrayList;
/**
 *This class contents the best 10 scores for appropriate level of difficulty
 *
 *@author Milan Stanic
*/
public class Scores {

    /**
     * top 10 results for appropriate level
     */
    private ArrayList<Score> scores;

    /**
     * Class constructor
     * purpose for testing
     */
    public Scores(){
        for(int i=0; i<10; i++) {
            scores.add(new Score("Name",5));
        }
    }

    public Scores(ArrayList<Score> scores){
        this.setScores(scores);
    }
    /**
     * Class constructor.
     *
     * @param gameLevelType difficulty level
     * @param parser returns array of the best 10 results
     */
    public Scores(MastermindScoreFileParser parser, GameLevelType gameLevelType){
        // in parser we need to have method which reads appropriate
        // file with score and returns array of 10 the best result
        scores = parser.getScoreFromFile(gameLevelType);
    }




    /**
     * @param score score of current game
     * @return current position of score in top 10 or -1 if that score is not in top 10
     */
    public int getScore(int score){
        //our value should atleast have a count greater then the size-10;
        //if the size is
        int position = -1;
        for(Score s : this.scores) {
            if(score > s.getScore()){
                //put it in the arraylist in this position and then quit the foreach
                position = scores.indexOf(s);
                break;
            }
        }
        /*int temp = 1;
        for(temp=1; temp<=10; temp++){
            if(score < scores[9]){ temp = -1; break; }
            if(score > scores[temp-1]) break;
        }*/
        return position;
    }

    /**
     * @param score score of current game
     * @param position current position for score
    */
    public void setScore(Score score, int position){
        scores.add(position, score);
        /*for(int i=9; i>=position; i--){
            scores[i] = scores[i-1];
        }
        scores[position-1] = score;*/
    }

    /**
     * @param score score of current game
    */
    public void addScore(Score score){
        scores.add(score);

        /*for(int i=9; i>=position; i--){
            scores[i] = scores[i-1];
        }
        scores[position-1] = score;*/
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
     * @param scores top 10 scores for current level
     */
    public void setScores(ArrayList<Score> scores) {
        this.scores = scores;
    }

    /**
     * Function should be able to sort an Arraylist of scores
     *
     */
    public void sortScores() {
        //sort the arraylist of scores
    }

}
