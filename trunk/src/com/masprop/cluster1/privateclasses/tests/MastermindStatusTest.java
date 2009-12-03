package com.masprop.cluster1.privateclasses.tests;

import com.masprop.cluster1.privateclasses.model.MastermindStatus;

/**
 *
 * @author ?
 *
 */
public class MastermindStatusTest {
    public MastermindStatus mastermindStatus;

    public static void main(String[] args) {
        /**
         * parameters for testing
         * @param  value is value that opposite player computed
         * @param  currentRow is last row that player play
         * @param  currnetRowValue is value that player set
         */
        int value[] = {0,2,3,4};
        int currentRow = 3;
        int currentRowValue[] = {0,2,3,3};


        MastermindStatusTest test = new MastermindStatusTest();
        test.mastermindStatus = new MastermindStatus();

        /**
         * instantiate MastermindStatus values
         */
        test.mastermindStatus.setValue(value);
        test.mastermindStatus.setCurrentRow(currentRow);
        for(int i =0; i<4; i++){
            test.mastermindStatus.getMatrixMastermind().setCellValue(currentRow,
                    i, currentRowValue[i]);

        }

        /**
         * write MastermindStatus on standard output
         */
        int height = test.mastermindStatus.getMatrixMastermind().getHeight();
        int width = test.mastermindStatus.getMatrixMastermind().getWidth();

        for (int ii = 0; ii < height; ii++) {
            System.out.print("row: " + ii + "   ");
            for (int jj = 0; jj < width; jj++)
                System.out.print(" " + test.mastermindStatus.getMatrixMastermind().getCellValue(ii, jj));
            System.out.println("");
        }
        System.out.println("-------------------------------");
        System.out.println("Current row " + currentRow);
        System.out.print("Current row value: ");
        for (int jj = 0; jj < width; jj++)
            System.out.print(" " + test.mastermindStatus.getMatrixMastermind
                    ().getCellValue(currentRow, jj));
        System.out.println();
        System.out.print("Computed value:     ");
        for(int i = 0; i<4;) System.out.print(value[i++] + " ");
        System.out.println();
        System.out.println("-------------------------------");


        /**
         * write MastermindStatus result on standard output
         */

        System.out.print("Current row value is equal computed value: " +
                test.mastermindStatus.isCorrectValue());

    }

}
