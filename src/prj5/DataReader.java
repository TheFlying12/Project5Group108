package prj5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.text.ParseException;

/**
 * Reads the data from a file and create State objects containing Races
 * 
 * @author Patrick Stock (pstock)
 * @version 4/23/2021
 */
public class DataReader {

    private LinkedList<State> states;

    /**
     * Reads the input from a csv file
     */
    public DataReader(String fileName)
        throws FileNotFoundException,
        ParseException {
        states = readFile(fileName);
    }


    private LinkedList<State> readFile(String fileName) throws FileNotFoundException, ParseException {
        Scanner file = new Scanner(new File(fileName));
        LinkedList<State> newStates = new LinkedList<State>();
        LinkedList<Race> newRaces = new LinkedList<Race>();
        String[] line = file.nextLine().split(" Cases_");
        if (line.length != 6) {
            throw new ParseException("Incorrect formatting of csv", 0);
        }
        for (int i = 1; i < line.length - 1; i++) {
            newRaces.add(new Race(line[i], 0, 0));
        }
        newRaces.add(new Race("Other", 0, 0));
        
        while (file.hasNext()) {
            line = file.nextLine().split(" ");
            if (line.length != 11) {
                throw new ParseException("Incorrect formatting of csv", 0);
            }
            for (int i = 1; i < 6; i++) {
                newRaces.get(i - 1).setInfected(Integer.valueOf(line[i]));
            }
            for (int i = 6; i < line.length; i++) {
                newRaces.get(i - 6).setDeaths(Integer.valueOf(line[i]));
            }
            newStates.add(new State(line[0], newRaces));
        }
        
        return newStates;
    }


    /**
     * Getter method for states for testing
     */
    public LinkedList<State> getStates() {
        return states;
    }
}
