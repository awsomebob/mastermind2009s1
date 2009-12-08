package com.masprop.cluster1.privateclasses.model.diskmanager;

import java.io.*;
import java.util.ArrayList;

import com.masprop.cluster1.privateclasses.model.*;
import com.masprop.cluster1.shared.model.Cell;
import com.masprop.cluster1.shared.model.GameLevelType;

/**
 * Saves a MasterMindGame object to csv
 *
 * @author Nick Veenhof
 * @see parser
 * @see MastermindFileParser
 */
public class MastermindGameFileParser extends MastermindFileParser {

    /**
     * @param name
     *            Function to create a file where we are going to save our data.
     *            Can be used multiple times
     */
    public MastermindGameFileParser(boolean createnew) {
        this.create("SAVEDGAME", createnew);
    }

    /**
     * Updating of our file. Only used for game
     *
     * @param mastermind
     *            our game object
     */
    public void update(Mastermind mastermind) {
        File file = new File(System.getProperty("user.dir") + "/SAVEDGAME");
        try {
            Writer output = null;
            this.delete("SAVEDGAME");
            this.create("SAVEDGAME");
            FileWriter fw = new FileWriter(file);
            output = new BufferedWriter(fw);
            output.write(mastermind.toString("|"));
            String newline = System.getProperty("line.separator");
            output.write(newline);
            output.close();
        } catch (IOException io) {
            System.out.println("IO Error " + io.toString());
        }
    }

    /**
     * Get all of our content in an string arraylist
     *
     * @param file
     *            file used to retrieve the information from
     */
    public Mastermind retrieve(File file) {

        FileReader fr = null;
        try {
            fr = new FileReader(file);
        } catch (FileNotFoundException file_error) {
            System.out.println("File Error " + file_error.toString());
        }

        // buffered reading
        BufferedReader br = new BufferedReader(fr);
        // initial value of our mastermind game
        // we initiate it with a easy level. In the case that we cannot retrieve
        // it
        // from the file
        Mastermind mastermind = null;
        String s;
        Cell[][] matrix = null;
        ArrayList<Cell[]> matrixList = new ArrayList<Cell[]>();
        boolean firstline = true;
        /*
         * because we are reading a file it's wise to do this in a try loop
         */
        try {
            while ((s = br.readLine()) != null) {
                if (s.length() > 0) {
                    if (firstline) {
                        // its some game data
                        mastermind = stringToMastermind(s, "|");
                        firstline = false;
                    } else {
                        // it's our cells
                        Cell[] value = stringToMatrixMastermindRow(s, "|");
                        matrixList.add(value);
                    }
                }
            }
            matrix = new Cell[matrixList.size()][];
            for (int i = 0; i < matrixList.size(); i++) {
                matrix[i] = matrixList.get(i);
            }
            if (mastermind != null) {
                MastermindStatus status = mastermind.getMastermindStatus();
                MatrixMastermind matrixMastermind = new MatrixMastermind(matrix);
                status.setMatrixMastermind(matrixMastermind);
            }

        } catch (IOException io) {
            System.out.println("IO Error " + io.toString());
        }
        return mastermind;
    }

    /**
     * Gets a mastermind game object out of the defined file
     *
     * @return mastermind object
     */
    public Mastermind getMastermindFromFile() {
        // TODO: convert this SAVEDGAME to a constant field
        File file = new File(System.getProperty("user.dir") + "/SAVEDGAME");
        if (file.canRead()) {
            Mastermind data = retrieve(file);
            return data;
        } else {
            Mastermind mastermind = null;
            return mastermind;
        }
    }

    /**
     * Convert an string to a mastermind object + including matrix if possible
     *
     * @param a
     *            our mastermind string object
     * @param separator
     *            the used separator to split our strings
     * @return a mastermind object or empty mastermind object if failed
     * @see Mastermind
     * @see MatrixMastermind
     */
    public Mastermind stringToMastermind(String a, String separator) {
        String[] pieces = a.split("\\" + separator, -1);
        Mastermind mastermind = null;
        // TODO implement a better check to say that our file is an mastermind
        // object!
        if (pieces.length == 4) {
            try {
                // initiate our type from the file
                GameLevelType gameLevelType = GameLevelType.valueOf(pieces[0]);
                GameModeType gameModeType = GameModeType.valueOf(pieces[1]);
                String value = pieces[2];
                String currentRow = pieces[3];

                // make the gameleveltype from the readout
                mastermind = new Mastermind(gameLevelType, gameModeType);

                // return an empty status so they can fill it
                MastermindStatus mastermindStatus = new MastermindStatus();
                mastermindStatus.setCurrentRow(Integer.parseInt(currentRow));
                mastermindStatus.setValue(stringToMastermindValue(value, ","));
                mastermind.setMastermindStatus(mastermindStatus);
                return mastermind;
            } catch (Exception e) {
                return mastermind = null;
            }
        }

        return mastermind;
    }

    /**
     * Convert a string to a MatrixMastermindRow
     *
     * @param a
     *            the row as a string
     * @param separator
     *            the used separator between the values in the row
     * @return Cell[] cell array with cell objects
     * @see MatrixMastermind
     * @see Cell
     */
    public Cell[] stringToMatrixMastermindRow(String a, String separator) {
        String[] pieces = a.split("\\" + separator, -1);
        Cell[] row = null;
        try {
            row = new Cell[pieces.length];
            int i = 0;
            for (String color : pieces) {
                Cell cell = new Cell(Integer.parseInt(color), false, false);
                row[i] = cell;
                i++;
            }
            return row;
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return row;
    }

    /**
     * Convert a string into a Mastermind game object
     *
     * @param a the game object as a string
     * @param separator used between the values in our string
     * @return Mastermind object
     * @see Mastermind
     */
    public int[] stringToMastermindValue(String a, String separator) {
        String[] pieces = a.split("\\" + separator, -1);
        int[] row = null;
        try {
            row = new int[pieces.length];
            int i = 0;
            for (String j : pieces) {
                row[i] = Integer.parseInt(j);
                i++;
            }
            return row;
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return row;
    }
}