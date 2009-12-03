package com.masprop.cluster1.privateclasses.model.diskmanager;

import java.io.*;
import java.util.ArrayList;

import com.masprop.cluster1.privateclasses.model.*;
import com.masprop.cluster1.shared.model.Cell;
import com.masprop.cluster1.shared.model.GameLevelType;

/**
 *
 * @author Nick
 *
 */
public class MastermindGameFileParser extends MastermindFileParser {

    /**
     * @param name
     *            Function to create a file where we are going to save our data.
     *            Can be used multiple times
     */
    public MastermindGameFileParser() {
        this.create("SAVEDGAME", true);
    }

    /**
     * Updating of our file. Only used for game
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
        //initial value of our mastermind game
        //we initiate it with a easy level. In the case that we cannot retrieve it
        //from the file
        Mastermind mastermind = new Mastermind(GameLevelType.EASY);
        String s;
        Cell[][] matrix = null;
        ArrayList<Cell[]> matrixList = new ArrayList<Cell[]>();
        boolean firstline = true;
        /*
         * because we are reading a file it's wise to do this in a try loop
         */
        try {
            while ((s = br.readLine()) != null) {
                if(firstline){
                    //its some game data
                    firstline = false;
                    mastermind = stringToMastermind(s,"|");
                } else {
                    //it's our cells
                    Cell[] value = stringToMatrixMastermindRow(s,"|");
                    matrixList.add(value);
                }
            }
            matrix = new Cell[matrixList.size()][];
            for(int i = 0; i < matrixList.size(); i++){
                matrix[i] = matrixList.get(i);
            }
            
            MastermindStatus status = mastermind.getMastermindStatus();
            MatrixMastermind matrixMastermind = new MatrixMastermind(matrix);
            status.setMatrixMastermind(matrixMastermind);

        } catch (IOException io) {
            System.out.println("IO Error " + io.toString());
        }
        return mastermind;
    }

    public Mastermind getMastermindFromFile() {
        //TODO: convert this to a field
        File file = new File(System.getProperty("user.dir") + "/SAVEDGAME");
        if (file.canRead()) {
            Mastermind data = retrieve(file);
            return data;
        } else {
            Mastermind mastermind = new Mastermind(GameLevelType.EASY);
            return mastermind;
        }
    }

    // Convert an string to array of strings
    // Delete the seperator string
    public Mastermind stringToMastermind(String a, String separator) {
        String[] pieces = a.split("\\" + separator, -1);
        if (pieces.length == 2) {

            //initiate our type from the file
            GameLevelType type = GameLevelType.valueOf(pieces[0]);

            //make the gameleveltype from the readout
            Mastermind mastermind = new Mastermind(type);

            //return an empty status
            MastermindStatus mastermindStatus = new MastermindStatus();
            mastermind.setMastermindStatus(mastermindStatus);
            return mastermind;
        }
        Mastermind mastermind = new Mastermind(GameLevelType.DIFFICULT);
        MastermindStatus mastermindStatus = new MastermindStatus();
        mastermind.setMastermindStatus(mastermindStatus);
        return mastermind;
    }

    public Cell[] stringToMatrixMastermindRow(String a, String separator) {
        String[] pieces = a.split("\\" + separator, -1);
        Cell[] row = null;
        if (pieces.length > 2) {
            row = new Cell[pieces.length];
            int i = 0;
            for(String color: pieces){
                Cell cell = new Cell(Integer.parseInt(color),false,false);
                row[i] = cell;
                i++;
            }
            return row;
        }
        return row;
    }
}