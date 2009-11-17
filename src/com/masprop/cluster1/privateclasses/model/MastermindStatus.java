package com.masprop.cluster1.privateclasses.model;

public class MastermindStatus {
	
	/**
	 * correct value 
	 * that computer or player produced
	 */
	private int value[];
	private MatrixMastermind matrixMastermind;
	
	/**
	 * row until whether 
	 * computer or player already played 
	 */
	private int currentRow;
	
	
	/**
	 * class constructor
	 * 
	 * @no params
	 * @instantiate all parameters on null
	 * @except matrix which is instantiated on default size
	 */
	public MastermindStatus() {
		super();
		value = new int[4];
		matrixMastermind = new MatrixMastermind(4, 10);
		currentRow = 0;
	}
	
	public int[] getValue() {
		return value;
	}
	
	public void setValue(int[] value) {
		this.value = value;
	}
	
	public MatrixMastermind getMatrixMastermind() {
		return matrixMastermind;
	}
	
	public void setMatrixMastermind(MatrixMastermind matrixMastermind) {
		this.matrixMastermind = matrixMastermind;
	}
	
	public int getCurrentRow() {
		return currentRow;
	}
	
	public void setCurrentRow(int currentRow) {
		this.currentRow = currentRow;
	}
	
	/**
	 * check if player have correct value
	 * whether is that computer or human
	 */
	public boolean isCorrectValue(){
		for(int i=0; i<4; i++){
			if(matrixMastermind.getCellValue(currentRow, i) != value[i]) 
				return false;
		}
		return true;
	}
}
