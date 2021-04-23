package prj5;

import java.io.FileNotFoundException;
/**
 * @author tejus
 *
 */
import bsh.ParseException;

public class Input {

    /**
     * @param args
     * @throws SpaceColonyException
     * @throws FileNotFoundException
     * @throws ParseException
     * @throws java.text.ParseException 
     */
    public static void main(String[] args)
        throws ParseException,
        FileNotFoundException, java.text.ParseException {
        if (args.length == 2) {
            new DataReader(args[0]);
        }
        else {
            new DataReader("Cases_and_Deaths_by_race_CRDT_Sep2020.csv");
        }

    }

}
