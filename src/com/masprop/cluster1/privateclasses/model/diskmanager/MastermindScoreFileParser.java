package com.masprop.cluster1.privateclasses.model.diskmanager;

import java.io.*;
import com.masprop.cluster1.privateclasses.model.*;
import com.masprop.cluster1.shared.model.GameLevelType;

import java.util.Iterator;

/**
 *
 * @author Nick
 *
 */
public class MastermindScoreFileParser extends MastermindFileParser {
    /**
     * @param name
     * Function to create a file where we are going to save our data.
     * Can be used multiple times
     */
    public MastermindScoreFileParser() {
        for (GameLevelType g : GameLevelType.values()) {
            this.create(g.toString(), false);
        }
    }

    public MastermindScoreFileParser(boolean createnew) {
        for (GameLevelType g : GameLevelType.values()) {
            this.create(g.toString(), createnew);
        }
    }

    /**
     * Updating of our file. Only used for scores so we don't make this general
     */
    public void update(String filename, Scores scores) {
        File file = new File(System.getProperty("user.dir")+"/"+filename);
        try {
            Writer output = null;
            this.delete(filename);
            this.create(filename);
            FileWriter fw = new FileWriter(file);
            output = new BufferedWriter(fw);
            Iterator<Score> itr = scores.getScores().iterator();
            while (itr.hasNext()) {

                Score scoreInList = itr.next();
                output.write(scoreInList.toString("|"));
                String newline = System.getProperty("line.separator");
                output.write(newline);
            }
            output.close();
        } catch (IOException io) {
            System.out.println("IO Error " + io.toString());
        }
    }

    /**
     * Get all of our content in an string arraylist
     */
    public Scores retrieve(File file) {

        FileReader fr = null;
        try {
            fr = new FileReader(file);
        } catch (FileNotFoundException file_error) {
            System.out.println("File Error " + file_error.toString());
        }
        //new Scores object
        Scores scores = new Scores();
        // buffered reading
        BufferedReader br = new BufferedReader(fr);

        String s;
        try {
            while ((s = br.readLine()) != null) {
                Score score = stringToScore(s, "|");
                scores.addScore(score);
            }
        } catch (IOException io) {
            System.out.println("IO Error " + io.toString());
        }
        return scores;
    }


    public Scores getScoreFromFile(GameLevelType gameLevelType) {
        File file = new File(System.getProperty("user.dir")+"/"+gameLevelType.toString());
        if(file.canRead()) {
            Scores data = retrieve(file);
            return data;
        } else {
            Scores scores = new Scores();
            return scores;
        }
    }

    // Convert an string to array of strings
    // Delete the seperator string
    public Score stringToScore(String a, String separator) {
        String[] pieces = a.split("\\" + separator, -1);
        if (pieces.length == 2) {
            String name = pieces[0];
            int score_nr = Integer.parseInt(pieces[1]);
            Score score = new Score(name, score_nr);
            return score;
        }
        return new Score("NULL",0);
    }
}