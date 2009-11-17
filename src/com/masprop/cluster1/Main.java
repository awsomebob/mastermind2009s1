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
        if (!new File("scores.csv").exists()) {
            // create our file and load it in db
            MastermindFileParser file = new MastermindFileParser("MastermindScores");
            ArrayList<String> list = file.retrieve();
            for (String s : list) {
                System.out.println(s);
            }

        } else {
            // create our scores file
            // db = new Database();
        }

        // Instantiate the Models
        //Game model = new Game(db);

        // Instantiate the Views

        // Instantiate the Controllers

        // Start some gui stuff maybe?
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }

}
