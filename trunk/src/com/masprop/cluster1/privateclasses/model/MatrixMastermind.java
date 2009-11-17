package com.masprop.cluster1.privateclasses.model;

import com.masprop.cluster1.shared.model.Cell;
import com.masprop.cluster1.shared.model.Matrix;

public class MatrixMastermind implements Matrix {
	private Cell[][] matrix;

	/**
	 * class constructor
	 * 
	 * @param width
	 * @param height
	 */
	public MatrixMastermind(int width, int height) {
		matrix = new Cell[height][width];
		for (int i = 0; i < height; i++)
			for (int j = 0; j < width; j++)
				matrix[i][j] = new Cell(0, false, false);
	}

	public Cell[][] getMatrix() {
		return matrix;
	}

	public Cell getCell(int i, int j) {
		return matrix[i][j];
	}

	public void setCell(int i, int j, Cell cell) {
		matrix[i][j] = cell;
	}

	public void setCellValue(int i, int j, int value) {
		matrix[i][j].setCurrentValue(value);
	}

	public int getCellValue(int i, int j) {
		return matrix[i][j].getCurrentValue();
	}

	public int getWidth() {
		return matrix[0].length;
	}

	public int getHeight() {
		return matrix.length;
	}

}
