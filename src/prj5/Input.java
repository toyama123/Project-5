package prj5;

import java.io.FileNotFoundException;
import bsh.ParseException;

/**
 * This is the Input class
 * @author Jared Joo (jaredjoo)
 * @version (11.17.2020)
 */
public class Input {

    public static void main(String[] args)
        throws FileNotFoundException,
        ParseException{
        CoronaReader reader;
        int length = args.length;
        reader = new CoronaReader("Cases_and_Deaths_by_race_CRDT_Sep2020.csv");
    }

}
