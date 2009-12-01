/**
 * Import our packages
 */
package com.masprop.cluster1;
import java.io.Console;
import java.io.File;
import com.masprop.cluster1.privateclasses.controller.*;
import com.masprop.cluster1.privateclasses.model.*;
import com.masprop.cluster1.privateclasses.model.diskmanager.*;
import com.masprop.cluster1.privateclasses.view.*;
import com.masprop.cluster1.shared.controller.*;
import com.masprop.cluster1.shared.model.*;
import com.masprop.cluster1.shared.view.*;
import java.util.ArrayList;

/**
 * @author nick
 *
 */
public class Main {
    public void run() {
        // Initialize Database abstraction layers
        // Initialize our scores file
        MastermindScoreFileParser file = new MastermindScoreFileParser();
        //put some content in our file
        //rownumbers go from 1 to ...

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
        Main main = new Main();
        main.run();
    }

}
