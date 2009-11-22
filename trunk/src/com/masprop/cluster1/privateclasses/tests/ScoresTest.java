package com.masprop.cluster1.privateclasses.tests;

import com.masprop.cluster1.privateclasses.model.Scores;

/**
 * This class is testing class Scores
 * 
 * @author Milan Stanic
 *
 */


public class ScoresTest {

	public Scores scores;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		ScoresTest test = new ScoresTest();
		test.scores = new Scores();
		
		int[] temp = new int[10];
		for(int i=0; i<10; i++)
			temp[i] = (10-i)*5;
		
		// set scores
		test.scores.setScores(temp);
		
		// write top 10 scores to standard output
		System.out.println("Top 10 scores for current level:");
		for(int i=0; i<10; i++){
			System.out.println("position "+ (i+1) +": " + test.scores.getScores()[i]);
		}
		
		//current position of score in top 10 or -1 if that score is not in top 10
		int score = 66;
		int position = test.scores.getScore(score);
		System.out.println();
		if(position != -1)
			System.out.println("Current position of score " + score + " is: " + position);
		else
			System.out.println("Current score " + score + " is not in top 10!");
		System.out.println();
		
		//update top 10 scores and write to standard out new top 10 if the result in top 10
		//or just write to standard output that the result is not in top 10
		if(position != -1){
			test.scores.setScore(score, position);
			System.out.println("Top new 10 scores for current level:");
			for(int i=0; i<10; i++){
				System.out.println("position "+ (i+1) +": " + test.scores.getScores()[i]);
			}
		}else
			System.out.println("Current score " + score + " is not in top 10!");
		
	}

}
