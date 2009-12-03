package com.masprop.cluster1.privateclasses.tests;


import com.masprop.cluster1.privateclasses.model.GameModeType;
import com.masprop.cluster1.privateclasses.model.Mastermind;
import com.masprop.cluster1.privateclasses.model.MastermindStatus;
import com.masprop.cluster1.privateclasses.model.MatrixMastermind;
import com.masprop.cluster1.privateclasses.model.diskmanager.MastermindGameFileParser;
import com.masprop.cluster1.shared.model.GameLevelType;

public class MastermindSaveGameTest {

    public void run() {

        // Initialize our game file with empty files
        MastermindGameFileParser parser = new MastermindGameFileParser(false);

        //read the file - USED FOR LOADING A GAME
        Mastermind mastermind = parser.getMastermindFromFile();


        MastermindStatus status = null;
        /**
         * load our game from the file and check if  our file is correctly formatted
         */
        if(mastermind != null) {

             status = mastermind.getMastermindStatus();
        } else {
            //create a new game if old one was not found
            mastermind = new Mastermind(GameLevelType.EASY, GameModeType.PLAYERvsCOMP);
            status = new MastermindStatus();

            /**
             * matrix size (actually depending on the gameleveltype..)
             *
             * @param width
             * @param height
             */
            int width = 6;
            int height = 10;
            status.setMatrixMastermind(new MatrixMastermind(width,height));
            mastermind.setMastermindStatus(status);
        }



        System.out.println("Our initial game");
        System.out.println(mastermind.toString("|"));

        /**
         * parameters for changing value in matrix
         *
         * @param x
         * @param y
         * @param value
         */
        int i = 7;
        int j = 3;
        int value = 4;

        /**
         * change matrix value on defined coordinates please note that i is
         * horizontal position and j is vertical position
         */
        mastermind.getMastermindStatus().getMatrixMastermind().setCellValue(i, j, value);

        //write our game to the file - USED FOR SAVING A GAME
        parser.update(mastermind);


        //read the file with the new values
        mastermind = parser.getMastermindFromFile();

        System.out.println("Our saved game");
        System.out.println(mastermind.toString("|"));
    }

    public static void main(String[] args) {
        MastermindSaveGameTest test = new MastermindSaveGameTest();
        test.run();
    }
}
