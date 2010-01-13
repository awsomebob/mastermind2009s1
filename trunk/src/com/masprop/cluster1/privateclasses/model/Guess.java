/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.masprop.cluster1.privateclasses.model;

import com.masprop.cluster1.shared.model.Cell;

/**
 * A class to encapsulate a row of cells for easy comparision between guesses
 *
 * @author Nick Veenhof
 */
public class Guess {

    // array of cells
    private Cell[] cells;

    /**
     * Constructor Used to set our amount of rows
     */
    public Guess() {
        setCells(new Cell[4]);
    }

    /**
     * Overloading of our main constructor Used to set a new Guess directly with
     * it's color
     *
     * @param color1
     * @param color2
     * @param color3
     * @param color4
     */
    public Guess(int color1, int color2, int color3, int color4) {
        setCells(new Cell[4]);
        getCells()[0] = new Cell(color1, false, false);
        getCells()[1] = new Cell(color2, false, false);
        getCells()[2] = new Cell(color3, false, false);
        getCells()[3] = new Cell(color4, false, false);
    }

    @Override
    public String toString() {
        return getCells()[0].getCurrentValue() + " ; "
                + getCells()[1].getCurrentValue() + " ; "
                + getCells()[2].getCurrentValue() + " ; "
                + getCells()[3].getCurrentValue();
    }

    /**
     * Check to see if we don't use color 0 in our guess
     * @param AllowEmptyColor
     * @return
     */
    public boolean areAllCellsUsableColors(boolean AllowEmptyColor) {
        if (!AllowEmptyColor) {
            return (getCells()[0].getCurrentValue() != 0)
                    && (getCells()[1].getCurrentValue() != 0)
                    && (getCells()[2].getCurrentValue() != 0)
                    && (getCells()[3].getCurrentValue() != 0);
        } else {
            return true;
        }

    }

    /**
     * See if a certain guess object is equal to another one.
     */
    @Override
    public boolean equals(Object guess) {
        if (this == guess)
            return true;
        Guess newGuess = (Guess) guess;
        if ((this.getCells()[0].getCurrentValue() == newGuess.getCells()[0]
                .getCurrentValue())
                && (this.getCells()[1].getCurrentValue() == newGuess.getCells()[1]
                        .getCurrentValue())
                && (this.getCells()[2].getCurrentValue() == newGuess.getCells()[2]
                        .getCurrentValue())
                && (this.getCells()[3].getCurrentValue() == newGuess.getCells()[3]
                        .getCurrentValue()))
            return true;
        return false;
    }

    /**
     * Setter of the cells
     * @param cells
     */
    public void setCells(Cell[] cells) {
        this.cells = cells;
    }

    /**
     * Getter of the cells
     * @return
     */
    public Cell[] getCells() {
        return cells;
    }

}
