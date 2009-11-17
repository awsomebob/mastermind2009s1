package com.masprop.cluster1.privateclasses.model.diskmanager;

import java.util.ArrayList;
import java.io.*;

public class MastermindFileParser implements Parser {
    private File file;
    private String name;
    /**
     * @param name
     * Function to create a file where we are going to save our data.
     * Can be used multiple times
     */
    public MastermindFileParser(String name) {
        this.name = name;
        this.create();
    }

    /**
     * Creating of our file
     */
    public boolean create() {
        this.file = new File(name);
        if (!this.file.exists()) {
            try {
                this.file.createNewFile();
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
    public boolean delete() {
        try {
            this.file.delete();
            return true;
        } catch (IOError io) {
            System.out.println("IO Error " + io.toString());
        }
        return false;
    }

    /**
     * Updating of our file
     */
    public void update(String rownumber, String value) {

    }

    /**
     * Get all of our content in an string arraylist
     */
    public ArrayList<String> retrieve() {
        ArrayList<String> content = new ArrayList<String>();
        content.add(new String("Test1"));
        content.add(new String("Test2"));
        content.add(new String("Test3"));
        return content;
    }

}
