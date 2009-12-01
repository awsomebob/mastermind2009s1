package com.masprop.cluster1.privateclasses.tests;

import com.masprop.cluster1.privateclasses.model.Score;
import com.masprop.cluster1.privateclasses.model.Scores;
import com.masprop.cluster1.privateclasses.model.diskmanager.MastermindScoreFileParser;
import com.masprop.cluster1.shared.model.GameLevelType;

public class MasterMindSaveScoreTest {
    public void run() {

        // Initialize our scores file with empty files (referring to the boolean)
        MastermindScoreFileParser file = new MastermindScoreFileParser(true);

        //put some scores in our files
        file.update(GameLevelType.EASY.toString(), new Score("milan", 8));
        file.update(GameLevelType.EASY.toString(), new Score("nick", 20));
        file.update(GameLevelType.EASY.toString(), new Score("pile",10));

        Scores scores = new Scores(file.getScoreFromFile(GameLevelType.EASY));

        for(Score s : scores.getScores()){
            System.out.print("Some scores");
            System.out.print(s.toString());
        }

        //get the content in our file as a list of stringarrays
        // Instantiate the Models
        //GameManagerMastermind manager =  new GameManagerMastermind();


        //Mastermind mastermind = manager.getNewGame(GameLevelType.DIFFICULT);
        //MastermindStatus status = mastermind.getMastermindStatus();
        //MatrixMastermind matrix = status.getMatrixMastermind();
        //System.out.println("matrixwidth");
        //System.out.println(matrix.getWidth());

        //GameSolverMastermind solver = new GameSolverMastermind();
        //mastermind  = solver.solveMastermind(mastermind);

        // Instantiate the Views

        // Instantiate the Controllers

        // Start some gui stuff maybe?
    }

    public static void main(String[] args) {
        MasterMindSaveScoreTest test = new MasterMindSaveScoreTest();
        test.run();
    }
}
