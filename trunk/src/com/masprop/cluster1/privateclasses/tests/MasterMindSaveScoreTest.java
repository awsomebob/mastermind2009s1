package com.masprop.cluster1.privateclasses.tests;

import java.util.Random;

import com.masprop.cluster1.privateclasses.model.Score;
import com.masprop.cluster1.privateclasses.model.Scores;
import com.masprop.cluster1.privateclasses.model.diskmanager.MastermindScoreFileParser;
import com.masprop.cluster1.shared.model.GameLevelType;

/**
 * This testclass generates 20 random scores and adds 3 manual added scores to
 * it We give you the possibility to manually add a given name/score to the list
 * to check if the score has been added and was sorted in the correct position
 *
 * @author nick
 *
 */
public class MasterMindSaveScoreTest {
    public void run() {
        /*
         * Changeable variables When wanting other output, please change these
         * values
         */
        // Used for writing a new file for our game (meaning that we will load
        // in an empty file)
        // Which GameLevelType do you want to retrieve/modify
        // possible values
        // GameLevelType.DIFFICULT;
        // GameLevelType.MEDIUM;
        // GameLevelType.EASY;
        GameLevelType level = GameLevelType.MEDIUM;

        // Which name do you want to add to the scores?
        String added_name = "Nick";
        // which score do you want to give this person (max random generated
        // score is 100)
        int added_score = 90;

        // create new scores or read from the current file
        boolean create_new_scores = false;
        // -------------------------------------------------------------------
        // Do not modify below this line please
        // -------------------------------------------------------------------

        // Initialize our scores file with empty files (referring to the
        // boolean)
        // change this to false if you want to use the current scores in the
        // file.
        // usefull for modifying scores and testing
        MastermindScoreFileParser parser = new MastermindScoreFileParser(
                create_new_scores);
        // read the file
        Scores scores = parser.getScoreFromFile(level);

        System.out.println("Read from file: ");
        for (Score s : scores.getScores()) {
            System.out.println("position " + scores.getScores().indexOf(s)
                    + ": " + s.toString());
        }
        /**
         * initiate random score table with 20 values to show that he only saves
         * 10
         */
        if (create_new_scores) {
            for (int i = 0; i < 20; i++) {
                Random r = new Random();
                Score score = new Score("testName", r.nextInt(100));
                scores.addScore(score);
            }
        }

        /**
         * Also add some manual scores
         */
        scores.addScore(new Score("randomName1", 8));
        scores.addScore(new Score("randomName2", 90));
        scores.addScore(new Score("randomName3", 70));
        System.out.println();
        System.out.println("Generated scores : ");

        for (Score s : scores.getScores()) {
            System.out.println("position " + scores.getScores().indexOf(s)
                    + ": " + s.toString());
        }

        scores.addScore(new Score(added_name, added_score));
        System.out.println();
        System.out.println("Added " + added_name + " with score " + added_score);
        System.out.println();
        System.out.println("Modified by test : ");
        for (Score s : scores.getScores()) {
            System.out.println("position " + scores.getScores().indexOf(s)
                    + ": " + s.toString());
        }

        // write our scores to the file
        parser.update(level.toString(), scores);

        // read the file with the new values
        scores = parser.getScoreFromFile(level);
        System.out.println();
        System.out.println("Read from file with our modified values: ");
        for (Score s : scores.getScores()) {
            System.out.println("position " + scores.getScores().indexOf(s)
                    + ": " + s.toString());
        }

    }

    public static void main(String[] args) {
        MasterMindSaveScoreTest test = new MasterMindSaveScoreTest();
        test.run();
    }
}
