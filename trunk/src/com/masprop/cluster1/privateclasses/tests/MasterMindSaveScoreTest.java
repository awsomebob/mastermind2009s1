package com.masprop.cluster1.privateclasses.tests;

import java.util.Random;

import com.masprop.cluster1.privateclasses.model.Score;
import com.masprop.cluster1.privateclasses.model.Scores;
import com.masprop.cluster1.privateclasses.model.diskmanager.MastermindScoreFileParser;
import com.masprop.cluster1.shared.model.GameLevelType;

/**
 *
 * @author nick
 *
 */
public class MasterMindSaveScoreTest {
    public void run() {

        // Initialize our scores file with empty files (referring to the boolean)
        //change this to false if you want to use the current scores in the file.
        //usefull for modifying scores and testing
        MastermindScoreFileParser parser = new MastermindScoreFileParser(true);
        //read the file
        Scores scores = parser.getScoreFromFile(GameLevelType.EASY);

        /**
         * initiate random score table with 20 values to show that he only saves 10
         */
        for(int i=0; i<20; i++) {
            Random r = new Random();
            Score score = new Score("testName",r.nextInt(100));
            scores.addScore(score);
        }

        /**
         * Also add some manual scores
         */
        scores.addScore(new Score("milan", 8));
        scores.addScore(new Score("nick", 90));
        scores.addScore(new Score("pile", 70));

        //write our scores to the file
        parser.update(GameLevelType.EASY.toString(), scores);


        //read the file with the new values
        scores = parser.getScoreFromFile(GameLevelType.EASY);

        System.out.println("Some scores");
        for(Score s : scores.getScores()){
            System.out.println(s.toString());
        }
    }

    public static void main(String[] args) {
        MasterMindSaveScoreTest test = new MasterMindSaveScoreTest();
        test.run();
    }
}