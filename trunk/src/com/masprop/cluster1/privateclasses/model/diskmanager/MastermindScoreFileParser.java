package com.masprop.cluster1.privateclasses.model.diskmanager;

import java.util.ArrayList;
import java.io.*;
import com.masprop.cluster1.privateclasses.model.*;
import com.masprop.cluster1.shared.model.GameLevelType;

import java.util.Iterator;

/**
 *
 * @author Nick
 *
 */
public class MastermindScoreFileParser implements Parser {
    private File file;

    /**
     * @param name
     *            Function to create a file where we are going to save our data.
     *            Can be used multiple times
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
     * Creating of our file without boolean as described in our interface
     */
    public boolean create(String filename) {
        return this.create(filename, false);
    }

    /**
     * Creating of our file with the option of having it overwritten with a clean new file
     */
    public boolean create(String filename, boolean createnew) {
        file = new File(filename);

        if (createnew == true) {
            file.delete();
        }

        if (!file.exists()) {
            try {
                file.createNewFile();
                return true;
            } catch (IOException io) {
                System.out.println("IO Exception " + io.toString());
            }
        }
        return false;
    }

    /**
     * Deleting of our file
     */
    public boolean delete(String filename) {
        file = new File(filename);
        try {
            file.delete();
            return true;
        } catch (IOError io) {
            System.out.println("IO Error " + io.toString());
        }
        return false;
    }

    /**
     * Within scores we don't use this method
     */
    public void update(String filename) {

    }

    /**
     * Updating of our file. Only used for scores so we don't make this general
     */
    public void update(String filename, Score score) {
        file = new File(filename);

        Scores scores = new Scores(this.retrieve(file));
        // add our score to the filecontent anyway
        scores.addScore(score);
        scores.sortScores();

        try {
            Writer output = null;
            this.delete(filename);
            this.create(filename);
            FileWriter fw = new FileWriter(this.file);
            output = new BufferedWriter(fw);
            Iterator<Score> itr = scores.getScores().iterator();
            while (itr.hasNext()) {

                Score scoreInList = itr.next();
                System.out.print("written to the file\n");
                System.out.print(scoreInList.toString("|") + "\n");
                output.write(scoreInList.toString("|"));
                String newline = System.getProperty("line.separator");
                output.write(newline);
            }
            output.close();
        } catch (IOException io) {
            System.out.println("IO Error " + io.toString());
        }
        System.out.println("Your file has been written");
    }

    /**
     * Get all of our content in an string arraylist
     */
    public ArrayList<Score> retrieve(File file) {

        FileReader fr = null;
        try {
            fr = new FileReader(file);
        } catch (FileNotFoundException file_error) {
            System.out.println("File Error " + file_error.toString());
        }
        // create our new arraylist object
        ArrayList<Score> content = new ArrayList<Score>();
        // buffered reading
        BufferedReader br = new BufferedReader(fr);

        String s;
        try {
            while ((s = br.readLine()) != null) {
                System.out.print("Testing our content");
                System.out.print(s);
                Score score = stringToScore(s, "|");
                content.add(score);
            }
        } catch (IOException io) {
            System.out.println("IO Error " + io.toString());
        }
        return content;
    }

    public ArrayList<Score> getScoreFromFile(GameLevelType gameLevelType) {
        file = new File(gameLevelType.toString());
        ArrayList<Score> data = this.retrieve(file);
        return data;
    }

    // Convert an string to array of strings
    // Delete the seperator string
    public static Score stringToScore(String a, String separator) {
        String[] pieces = a.split("\\" + separator, -1);
        if (pieces.length == 2) {
            Score score = new Score(pieces[0], Integer.getInteger(pieces[1]));
            return score;
        }
        // return an empty score
        return new Score();
    }
}