package com.masprop.cluster1.shared.model;

/**
 * This class represents single element of the game grid
 * with current value of cell and other settings.
 *
 * @author Matus Pleva
 */
public class Cell {

    /**
     * Current value of the cell.
     */
    private int currentValue;
    /**
     * Indicates if user is allowed to edit this cell.
     */
    private boolean editable;
    /**
     * Indicates if cell is active,
     * inactive cells are used in case of
     * game shapes which are not rectangle.
     */
    private boolean active;

    /**
     * Class constructor.
     *
     * @param currentValue current value of cell
     * @param editable indicates if user is allowed to edit this cell
     * @param active indicates if cell is active
     */
    public Cell(int currentValue, boolean editable, boolean active) {
        this.currentValue = currentValue;
        this.editable = editable;
        this.active = active;
    }

    /**
     * @return true if cell is active
     */
    public boolean isActive() {
        return this.active;
    }

    /**
     * @param active indicates if cell is active
     */
    public void setActive(boolean active) {
        this.active = active;
    }

    /**
     * @return current value of cell
     */
    public int getCurrentValue() {
        return this.currentValue;
    }

    /**
     * @param currentValue value of the cell
     */
    public void setCurrentValue(int currentValue) {
        this.currentValue = currentValue;
    }

    /**
     * @return true if cell is editable
     */
    public boolean isEditable() {
        return this.editable;
    }

    /**
     * @param editable indicates if cell is editable by user
     */
    public void setEditable(boolean editable) {
        this.editable = editable;
    }
}

