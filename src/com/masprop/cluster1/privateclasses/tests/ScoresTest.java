package com.masprop.cluster1.privateclasses.tests;


import java.util.Random;

import com.masprop.cluster1.privateclasses.model.Score;
import com.masprop.cluster1.privateclasses.model.Scores;
import com.masprop.cluster1.privateclasses.model.diskmanager.MastermindScoreFileParser;
import com.masprop.cluster1.shared.model.GameLevelType;


/**
 * This class is testing class Scores
 *
 * @author Milan Stanic
 *
 */


public class ScoresTest {

    public void run(){

        /* Changeable variables
         * When wanting other output, please change these values

        /**
         *  Class for testing
         */
        Scores scores;

        // Initialize scores
        scores = new Scores();

        // this score we want to add, you can change this value
        int newscore = 78;

        // players name, you can change this value
        String name = "testname";

         //-------------------------------------------------------------------
        //Do not modify below this line please
        //-------------------------------------------------------------------

        /*
         * initiate random score table with 20 values to show that he only saves 10
         */
        for(int i=0; i<20; i++) {
            Random r = new Random();
            Score score = new Score("test",r.nextInt(100));
            scores.addScore(score);
        }


        /*
         * write top 10 scores to standard output
         */
        System.out.println("Top 10 scores for current level:");
        for(Score s : scores.getScores()){
            System.out.println("position "+ scores.getScores().indexOf(s) +": " + s.toString());
        }
        //new test
        Random r = new Random();
        Score score = new Score("test",r.nextInt(100));
        scores.addScore(score);

        System.out.println("Top 10 scores for current level2");
        for(Score s : scores.getScores()){
            System.out.println("position "+ scores.getScores().indexOf(s) +": " + s.toString());
        }
        /*
         * current position of score in top 10 or -1 if that score is not in top 10
         * this variable score you can change to test functionality of class Score
         */
        int position = scores.getScore(newscore);
        System.out.println();
        if(position != 0)
            System.out.println("Current position of score " + newscore + " is: " + position);
        else
            System.out.println("Current score " + newscore + " is not in top 10!");
        System.out.println();

        /*
         * update top 10 scores and write to standard out new top 10 if the result in top 10
         * or just write to standard output that the result is not in top 10
         */

        if(position != -1){
            scores.setScore(new Score(name, newscore), position);
            System.out.println("Top new 10 scores for current level:");
            for(Score s : scores.getScores()){
                System.out.println("position "+ scores.getScores().indexOf(s) +": " + s.toString());
            }
        } else {
            System.out.println("Current score " + newscore + " is not in top 10!");
        }

    }

    /**
     * Main constructor for the Scores Test
     * @param args
     */
    public static void main(String[] args) {

        ScoresTest test = new ScoresTest();
        test.run();

    }

}
