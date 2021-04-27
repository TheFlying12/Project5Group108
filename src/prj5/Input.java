package prj5;

import java.io.FileNotFoundException;
/**
 * @author tejus
 *
 */

public class Input {

    /**
     * @param args
     * @throws FileNotFoundException
     * @throws java.text.ParseException 
     */
    public static void main(String[] args)
        throws  FileNotFoundException {
        if (args.length == 1) {
            new VisualizerWindow(args[0]);
        }      
        else {
            new VisualizerWindow("Cases_and_Deaths_by_race_CRDT_Sep2020.csv");
        }

    }

}
