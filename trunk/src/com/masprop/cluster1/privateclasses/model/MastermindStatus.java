package com.masprop.cluster1.privateclasses.model;

/**
 * this class contains current status
 * with all information for playing Mastermind
 *
 * @see MatrixMastermind
 *
 * @author Milovan Duric
 */
public class MastermindStatus {

    /**
     * correct value
     * that computer or player produced
     */
    private int value[];

    /**
     * matrix which holds values
     * that player guess
     */
    private MatrixMastermind matrixMastermind;

    /**
     * row until whether
     * computer or player already played
     */
    private int currentRow;


    /**
     * class constructor
     *
     * matrix which is instantiated on default size
     * initiate all values on 0
     */
    public MastermindStatus() {
        super();
        value = new int[4];
        matrixMastermind = new MatrixMastermind(4, 10);
        currentRow = 0;
    }


    /**
     *
     * @return correct value
     */
    public int[] getValue() {
        return value;
    }

    /**
     * set correct value
     * @param value
     */
    public void setValue(int[] value) {
        this.value = value;
    }

    /**
     *
     * @return matrix
     */
    public MatrixMastermind getMatrixMastermind() {
        return matrixMastermind;
    }

    /**
     * set matrix
     * @param matrixMastermind
     */
    public void setMatrixMastermind(MatrixMastermind matrixMastermind) {
        this.matrixMastermind = matrixMastermind;
    }


    /**
     *
     * @return current row
     */
    public int getCurrentRow() {
        return currentRow;
    }

    /**
     * set current row
     * @param currentRow
     */
    public void setCurrentRow(int currentRow) {
        this.currentRow = currentRow;
    }

    /**
     * check if player have correct value
     * whether is that computers or humans
     */
    public boolean isCorrectValue(){
        for(int i=0; i<4; i++){
            if(matrixMastermind.getCellValue(currentRow, i) != value[i])
                return false;
        }
        return true;
    }

    /**
     *
     * @return the number of colors on right position
     */
    public int numCorrectPosition(){
        int cnt = 0;
        for(int i=0; i<4; i++){
            if(matrixMastermind.getCellValue(currentRow, i) == value[i])
                cnt++;
        }
        return cnt;
    }

    /**
     *
     * @return the number of colors on wrong position
     */
    public int numWrongPosition(){
        int cnt = 0;
        boolean[] tempCorrect = new boolean[4];
        boolean[] tempBusy = new boolean[4];
        boolean[] corBusy = new boolean[4];
        for(int i=0; i<4; i++)
            tempCorrect[i] = false;
        for(int i=0; i<4; i++)
            tempBusy[i] = false;
        for(int i=0; i<4; i++)
            corBusy[i] = false;

        for(int i=0; i<4; i++){
            if(matrixMastermind.getCellValue(currentRow, i) == value[i]){
                tempCorrect[i] = true;
               // System.out.println("Poklopile se boje na poziciji " + i);
            }
        }

        for(int i=0; i<4; i++)
            for(int j=0; j<4; j++){
                if(!(tempCorrect[i] || tempCorrect[j] || tempBusy[j] || corBusy[i])){
                    if(matrixMastermind.getCellValue(currentRow, j) == value[i]){
                        cnt++;
                        tempBusy[j] = true;
                        corBusy[i] = true;
                    }
                }
            }
        return cnt;
    }
}
