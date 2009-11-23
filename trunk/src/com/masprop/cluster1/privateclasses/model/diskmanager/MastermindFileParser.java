package com.masprop.cluster1.privateclasses.model.diskmanager;

import java.util.ArrayList;
import java.io.*;

import com.masprop.cluster1.shared.model.GameLevelType;
import java.util.StringTokenizer;

/**
 *
 * @author Nick
 *
 */
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
    public void update(Integer rownumber, String[] value) {
        //read all our file into a arraylist
        ArrayList<String[]> filecontent = this.retrieve();
        //TODO check our string value
        filecontent.set(rownumber, value);
    }

    /**
     * Get all of our content in an string arraylist
     */
    public ArrayList<String[]> retrieve() {

        FileReader fr = null;
        try {
            fr = new FileReader(this.file);
        } catch (FileNotFoundException file) {
            System.out.println("File Error " + file.toString());
        }
        //create our new arraylist object
        ArrayList<String[]> content = new ArrayList<String[]>();
        //buffered reading
        BufferedReader br = new BufferedReader(fr);

        String s;
        try {
            while((s = br.readLine()) != null) {
                String[] newline = stringToArray(s,",");
                content.add(newline);
            }
        } catch (IOException io) {
            System.out.println("IO Error " + io.toString());
        }
        return content;
    }

    public int[] getScore(GameLevelType gameLevelType) {
        // TODO Auto-generated method stub
        return null;
    }

    //  Convert an array of strings to one string.
    //  Put the 'separator' string between each element.
    public static String arrayToString(String[] a, String separator) {
        StringBuffer result = new StringBuffer();
        if (a.length > 0) {
            result.append(a[0]);
            for (int i=1; i<a.length; i++) {
                result.append(separator);
                result.append(a[i]);
            }
        }
        return result.toString();
    }

    //  Convert an string to array of strings
    //  Delete the seperator string
    public static String[] stringToArray(String a, String separator) {
        String[] pieces = a.split(separator);
        return pieces;
    }

}
