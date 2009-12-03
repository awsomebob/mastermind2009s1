package com.masprop.cluster1.privateclasses.model;

/**
 *
 * @author Nick
 *
 */
public class Score implements Comparable<Score> {
    private int score;

    private String name;

    public Score() {
        // default constructor but is not used
    }

    public Score(String name, int score) {
        this.setName(name);
        this.setScore(score);
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return getName() + "|" + getScore();
    }

    public String toString(String separator) {
        return getName() + separator + getScore();
    }

    public int compareTo(Score score) {
        if ((this.getScore() < score.getScore())) {
            return 1;
        } else {
            return 0;
        }
    }
}
