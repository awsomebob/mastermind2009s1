package com.masprop.cluster1.privateclasses.tests;

import java.util.Random;

import com.masprop.cluster1.privateclasses.model.Mastermind;
import com.masprop.cluster1.privateclasses.model.MastermindStatus;
import com.masprop.cluster1.privateclasses.model.MatrixMastermind;
import com.masprop.cluster1.privateclasses.model.diskmanager.MastermindGameFileParser;

public class MastermindSaveGameTest {

    public void run() {

        // Initialize our game file with empty files
        MastermindGameFileParser parser = new MastermindGameFileParser();

        //read the file
        Mastermind mastermind = parser.getMastermindFromFile();

        /**
         * initiate random matrix field and save it in the status
         */
        MastermindStatus status = mastermind.getMastermindStatus();
        /**
         * matrix size
         *
         * @param width
         * @param height
         */
        int width = 6;
        int height = 10;

        status.setMatrixMastermind(new MatrixMastermind(width,height));
        MatrixMastermind matrix = status.getMatrixMastermind();
        /**
         * parameters for changing value in matrix
         *
         * @param x
         * @param y
         * @param value
         */
        int i = 8;
        int j = 3;
        int value = 6;

        /**
         * change matrix value on defined coordinates please note that i is
         * horizontal position and j is vertical position
         */
        matrix.setCellValue(i, j, value);

        //write our game to the file
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
