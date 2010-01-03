/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.masprop.cluster1.privateclasses.model;

import com.masprop.cluster1.shared.model.Cell;

/**
 *
 * @author Nick Veenhof
 */
public class Guess {


    private Cell[] cells;

    public Guess() {
        setCells(new Cell[4]);
    }


    public Guess(int color1, int color2, int color3, int color4) {
        setCells(new Cell[4]);
        getCells()[0] = new Cell(color1,false,false);
        getCells()[1] = new Cell(color2,false,false);
        getCells()[2] = new Cell(color3,false,false);
        getCells()[3] = new Cell(color4,false,false);
    }

    public @Override String toString() {
        return getCells()[0].getCurrentValue() + " ; " + getCells()[1].getCurrentValue() + " ; " + getCells()[2].getCurrentValue() + " ; " + getCells()[3].getCurrentValue();
    }

    public boolean areAllCellsUsableColors(boolean AllowEmptyColor) {
        if(!AllowEmptyColor) {
            return  (getCells()[0].getCurrentValue() != 0) &&
                    (getCells()[1].getCurrentValue() != 0) &&
                    (getCells()[2].getCurrentValue() != 0) &&
                    (getCells()[3].getCurrentValue() != 0);
        } else {
            return true;
        }

    }

    @Override
    public boolean equals(Object guess) {
        // TODO Auto-generated method stub
        if( this == guess) return true;
        Guess newGuess = (Guess)guess;
        if((this.getCells()[0].getCurrentValue() == newGuess.getCells()[0].getCurrentValue()) &&
           (this.getCells()[1].getCurrentValue() == newGuess.getCells()[1].getCurrentValue()) &&
           (this.getCells()[2].getCurrentValue() == newGuess.getCells()[2].getCurrentValue()) &&
           (this.getCells()[3].getCurrentValue() == newGuess.getCells()[3].getCurrentValue())
        ) return true;
        return false;
    }


    public void setCells(Cell[] cells) {
        this.cells = cells;
    }


    public Cell[] getCells() {
        return cells;
    }


}
