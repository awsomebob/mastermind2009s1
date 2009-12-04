package com.masprop.cluster1.privateclasses.tests;

import com.masprop.cluster1.privateclasses.model.MatrixMastermind;


/**
 * Testing class for the MatrixMastermind 
 * 
 * @see MatrixMastermind
 * 
 * @author Milovan Duric
 *
 */
public class MatrixMastermindTest {
	public MatrixMastermind matrix;

	public static void main(String args[]) {

		/**
		 * matrix size
		 * 
		 * @param width
		 * @param height
		 */
		int width = 6;
		int height = 10;
		
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
		 * instantiate matrix all values are 0
		 */

		MatrixMastermindTest test = new MatrixMastermindTest();
		test.matrix = new MatrixMastermind(width, height);

		/**
		 * write matrix on standard output
		 */
		System.out.println("Matrix dimensions " + test.matrix.getHeight()
				+ " X " + test.matrix.getWidth());
		System.out.println("-------------------------------");

		for (int ii = 0; ii < height; ii++) {
			System.out.print("row: " + i + "   ");
			for (int jj = 0; jj < width; jj++)
				System.out.print(" " + test.matrix.getCellValue(ii, jj));
			System.out.println("");
		}
		System.out.println("-------------------------------");
		
		

		/**
		 * change matrix value on defined coordinates please note that i is
		 * horizontal position and j is vertical position
		 */
		test.matrix.setCellValue(i, j, value);

		/**
		 * write updated matrix on standard output
		 */
		System.out.println("");
		System.out.println("Updated matrix");
		System.out.println("-------------------------------");
		for (int ii = 0; ii < height; ii++) {
			System.out.print("row: " + ii + "   ");
			for (int jj = 0; jj < width; jj++)
				System.out.print(" " + test.matrix.getCellValue(ii, jj));
			System.out.println("");
		}
		System.out.println("-------------------------------");

	}
}
