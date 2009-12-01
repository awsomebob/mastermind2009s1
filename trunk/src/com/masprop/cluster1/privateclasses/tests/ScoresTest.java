package com.masprop.cluster1.privateclasses.tests;

import java.util.ArrayList;
import java.util.Random;

import com.masprop.cluster1.privateclasses.model.Score;
import com.masprop.cluster1.privateclasses.model.Scores;


/**
 * This class is testing class Scores
 *
 * @author Milan Stanic
 *
 */


public class ScoresTest {

    /**
     *  Class for testing
     */
    public Scores scores;

    /**
     * @param args
     */
    public static void main(String[] args) {

        ScoresTest test = new ScoresTest();
        test.scores = new Scores();

        /**
         * initiate array temp with some values
         */
        for(int i=0; i<20; i++) {
            Random r = new Random();
            Score score = new Score("test",r.nextInt(100));
            test.scores.addScore(score);
        }


        /**
         * write top 10 scores to standard output
         */
        System.out.println("Top 10 scores for current level:");
        for(Score s : test.scores.getScores()){
            System.out.println("position "+ test.scores.getScores().indexOf(s) +": " + s.toString());
        }

        /**
         * current position of score in top 10 or -1 if that score is not in top 10
         * this variable score you can change to test functionality of class Score
         */
        int score = 13;
        String name = "testname";
        int position = test.scores.getScore(score);
        System.out.println();
        if(position != -1)
            System.out.println("Current position of score " + score + " is: " + position);
        else
            System.out.println("Current score " + score + " is not in top 10!");
        System.out.println();

        /**
         * update top 10 scores and write to standard out new top 10 if the result in top 10
         * or just write to standard output that the result is not in top 10
         */

        if(position != -1){
            test.scores.setScore(new Score(name, score), position);
            System.out.println("Top new 10 scores for current level:");
            for(Score s : test.scores.getScores()){
                System.out.println("position "+ test.scores.getScores().indexOf(s) +": " + s.toString());
            }
        } else {
            System.out.println("Current score " + score + " is not in top 10!");
        }

    }

}
