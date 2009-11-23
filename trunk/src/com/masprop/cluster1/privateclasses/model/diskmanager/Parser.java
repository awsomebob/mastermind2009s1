package com.masprop.cluster1.privateclasses.model.diskmanager;
import java.util.ArrayList;

import com.masprop.cluster1.shared.model.GameLevelType;

public interface Parser {
    /**
     * @param name
     * @return true if file/database could be created
     * file/database/whatever somebody writes in the interface
     */
    public boolean create();

    /**
     * @param name
     * @return true if our file/database/.. had been deleted
     * used to delete our static file/db/layer
     */
    public boolean delete();

    /**
     * Used to update our with
     * @param value to give our value what we need to write in our layer
     * @param rownumber, defines where in our file we want to write the value
     */
    public void update(Integer rownumber, String[] value);

    public ArrayList<String[]> retrieve();

    public int[] getScore(GameLevelType gameLevelType);

}
