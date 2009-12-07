package com.masprop.cluster1.privateclasses.model;

/**
 * Score object that contains a name and a score and is sortable
 *
 * @author Nick Veenhof
 * @see Comparable
 */
public class Score implements Comparable<Score> {
    /**
     * The users score
     */
    private int score;
    /**
     * the users name
     */
    private String name;

    /**
     * Superconstructor for the score
     *
     */
    public Score() {
    }

    /**
     * Constructor for score with a name and a score
     * @param name Name of the player
     * @param score Number of points
     */
    public Score(String name, int score) {
        this.setName(name);
        this.setScore(score);
    }
    /**
     * Getter for the name
     * @return String name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Getter for the score
     * @return int score
     */
    public int getScore() {
        return this.score;
    }

    /**
     * Setter for the name
     * @param name Name of the player
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Setter for the score
     * @param score Score of the player
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * Clone the score object
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    /**
     * Returns the object as a string
     * @return String name and score in a concatenated way
     */
    @Override
    public String toString() {
        return getName() + "|" + getScore();
    }

    /**
     * Returns the object as a string with configurable separator
     * @param separator Separator used when concatenating the fields
     * @return String name and score in a custom concatenated way
     */
    public String toString(String separator) {
        return getName() + separator + getScore();
    }

    /**
     * Comparator to sort our score objects
     * @param GUIScore the score object which we want to compare it with
     */
    public int compareTo(Score score) {
        if ((this.getScore() < score.getScore())) {
            return 1;
        } else {
            return 0;
        }
    }
}
