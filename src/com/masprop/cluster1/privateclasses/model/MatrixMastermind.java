package com.masprop.cluster1.privateclasses.model;

import com.masprop.cluster1.shared.model.Cell;
import com.masprop.cluster1.shared.model.Matrix;

/**
 * Matrix of cell that player will guess
 * it is always 7 x 4, but for implementation of
 * level difficulty we use more values,
 * actually more colors
 *
 * @see Cell
 * @see Matrix
 *
 * @author Milovan Duric
 */
public class MatrixMastermind implements Matrix {
    private Cell[][] matrix;

    /**
     * class constructor
     *
     * @param width
     * @param height
     */
    public MatrixMastermind(int width, int height) {
        this.matrix = new Cell[height][width];
        for (int i = 0; i < height; i++)
            for (int j = 0; j < width; j++)
                if(i == 0)
                    this.matrix[i][j] = new Cell(0, true, false);
                else
                    this.matrix[i][j] = new Cell(0, false, false);
    }

    /**
     * class constructor that use matrix
     * like argument and just instantiate matrix with it
     *
     * @param matrix
     */
    public MatrixMastermind(Cell[][] matrix) {
        this.matrix = matrix;
    }

    /**
     *
     * @return matrix
     */
    public Cell[][] getMatrix() {
        return this.matrix;
    }

    /**
     * return cell from coordinates i, j
     *
     * @param i
     * @param j
     * @return Cell
     */
    public Cell getCell(int i, int j) {
        return this.matrix[i][j];
    }


    /**
     * set cell on coordinates i, j
     *
     * @param i
     * @param j
     * @param cell
     */
    public void setCell(int i, int j, Cell cell) {
        this.matrix[i][j] = cell;
    }


    /**
     * set cell value on coordinates i, j
     * with value parameter
     *
     * @param i
     * @param j
     * @param value
     */
    public void setCellValue(int i, int j, int value) {
        this.matrix[i][j].setCurrentValue(value);
    }

    /**
     * return cell value on coordinates i, j
     *
     * @param i
     * @param j
     * @return
     */
    public int getCellValue(int i, int j) {
        return this.matrix[i][j].getCurrentValue();
    }


    /**
     *
     * @return matrix width
     */
    public int getWidth() {
        return this.matrix[0].length;
    }


    /**
     *
     * @return matrix height
     */
    public int getHeight() {
        return this.matrix.length;
    }


}
