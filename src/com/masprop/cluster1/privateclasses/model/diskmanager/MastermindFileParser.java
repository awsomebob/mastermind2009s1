package com.masprop.cluster1.privateclasses.model.diskmanager;

import java.io.*;

/**
 *
 * @author Nick
 *
 */
public class MastermindFileParser implements Parser {
    /**
     *
     * Superconstructor
     */
    public MastermindFileParser() {

    }

    /**
     * @param name
     *            Function to create a file where we are going to save our data.
     *            Can be used multiple times
     */
    public MastermindFileParser(String filename) {
            this.create(filename, false);
    }

    /**
     *
     * @param filename
     * @param createnew
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
     * Creating of our file with the option of having it overwritten with a clean new file
     */
    public boolean create(String filename, boolean createnew) {
        File file = new File(System.getProperty("user.dir")+"/"+filename);

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
        File file = new File(System.getProperty("user.dir")+"/"+filename);
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
}