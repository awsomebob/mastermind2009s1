package com.masprop.cluster1.privateclasses.model.diskmanager;
import com.masprop.cluster1.privateclasses.model.*;
import java.io.File;
import java.util.ArrayList;
/**
 * Interface that defines what we need for a generic fileparser
 *
 * @author nick
 *
 */
public interface Parser {
    /**
     * @param name
     * @return true if file/database could be created
     * file/database/whatever somebody writes in the interface
     */
    public boolean create(String filename);

    /**
     * @param name
     * @return true if our file/database/.. had been deleted
     * used to delete our static file/db/layer
     */
    public boolean delete(String filename);

    /**
     * Used to update our with
     * @param value to give our value what we need to write in our layer
     * @param rownumber, defines where in our file we want to write the value
     */
    public void update(String filename);

    public ArrayList<Score> retrieve(File file);
}
