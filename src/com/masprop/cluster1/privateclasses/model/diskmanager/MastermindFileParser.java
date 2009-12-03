package com.masprop.cluster1.privateclasses.model.diskmanager;

import java.io.*;

/**
 * General File Parser functions for the mastermind project Creating/Deleting of
 * a file is provided here
 *
 * @author Nick Veenhof
 * @See Parser
 * @see MastermindGameFileParser
 * @see MastermindScoreFileParser
 */
public class MastermindFileParser implements Parser {
    /**
     *
     * Superconstructor
     */
    public MastermindFileParser() {

    }

    /**
     * Function to create a file where we are going to save our data. Can be
     * used multiple times
     *
     * @param filename
     *            Name of the file in which we want to save it
     */
    public MastermindFileParser(String filename) {
        this.create(filename, false);
    }

    /**
     * Overloading of the superconstructor by adding a boolean that defines if
     * the file should be erased and a new file should be created to write the
     * game in
     *
     * @param filename
     *            Name of the file in which we want to save it
     * @param createnew
     *            Boolean that defines if we want a new file or not
     */
    public MastermindFileParser(String filename, boolean createnew) {
        this.create(filename, createnew);
    }

    /**
     * Creating of our file without boolean as described in our interface
     */
    public boolean create(String filename) {
        return this.create(filename, false);
    }

    /**
     * Creating of our file with the option of having it overwritten with a
     * clean new file
     */
    public boolean create(String filename, boolean createnew) {
        File file = new File(System.getProperty("user.dir") + "/" + filename);

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
        File file = new File(System.getProperty("user.dir") + "/" + filename);
        try {
            file.delete();
            return true;
        } catch (IOError io) {
            System.out.println("IO Error " + io.toString());
        }
        return false;
    }

    /**
     * We don't use this general function here yet. Could be used for a general
     * Array to CSV string.
     *
     */
    public void update(String filename) {
        // TODO : To be defined
    }
}