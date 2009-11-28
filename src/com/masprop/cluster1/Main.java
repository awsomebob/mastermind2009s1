/**
 * Import our packages
 */
package com.masprop.cluster1;
import java.io.Console;
import java.io.File;
import com.masprop.cluster1.privateclasses.controller.*;
import com.masprop.cluster1.privateclasses.model.*;
import com.masprop.cluster1.privateclasses.model.diskmanager.MastermindFileParser;
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
        MastermindFileParser file = new MastermindFileParser("MastermindScores.csv");
        //put some content in our file
        //rownumbers go from 1 to ...
        /*String[] scores = {"milan","8","difficult"};
        file.update(0, scores);
        String[] scores1 = {"nick","6","easy"};
        file.update(1, scores1);

        String[] scores2 = {"pile","10","difficult"};
        file.update(0, scores2);
        //get the content in our file as a list of stringarrays
*/

        // Instantiate the Models
        GameManagerMastermind manager =  new GameManagerMastermind();


        Mastermind mastermind = manager.getNewGame(GameLevelType.DIFFICULT);
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
