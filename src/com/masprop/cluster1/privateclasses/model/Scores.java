package com.masprop.cluster1.privateclasses.model;
/**
 *This class contents the best 10 scores for appropriate level of difficulty 
 *
 *@author Milan Stanic
*/

import com.masprop.cluster1.privateclasses.diskmanager.MastermindParser;
import com.masprop.cluster1.shared.model.GameLevelType;

public class Scores {
	
    /**
     * top 10 results for appropriate level
     */	
	private int[] scores;
	
    /**
     * Class constructor.
     *
     * @param gameLevelType difficulty level
     * @param parser returns array of the best 10 results
     */
	public Scores(MastermindParser parser, GameLevelType gameLevelType){
		// in parser we need to have method which reads appropriate
		// file with score and returns array of 10 the best result
		scores =	parser.getScore(gameLevelType);
	}
	
	/**
	 * @param score score of current game
	 * @return current position of score in top 10 or -1 if that score is not in top 10
	 */
	int getScore(int score){
		int temp = 1;
		for(temp=1; temp<=10; temp++){
			if(score > scores[temp-1]) break;
			if(temp == 10) temp = -1;
		}
		return temp;
	}
	
	/**
	 * @param score score of current game
	 * @param position current position for score
	*/
	void setScore(int score, int position){
		for(int i=9; i>=position; i++){
			scores[i] = scores[i-1];
		}
		scores[position-1] = score;
	}

	/**
	 * 
	 * @return top 10 scores for current level
	 */
	public int[] getScores() {
		return scores;
	}

	/**
	 * 
	 * @param scores top 10 scores for current level
	 */
	public void setScores(int[] scores) {
		this.scores = scores;
	}
	
	
}
