package prj5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

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
     * 
     * @throws ParseException
     */
    public DataReader(String fileName) throws FileNotFoundException {
        states = readFile(fileName);
    }


    private LinkedList<State> readFile(String fileName)
        throws FileNotFoundException {
        Scanner file = new Scanner(new File(fileName));
        LinkedList<State> newStates = new LinkedList<State>();
        String[] racesNames = readRaces(file.nextLine().toString().split(","));
        String[] line;
        String stateName;
        LinkedList<Race> newRaces;
        int deaths;
        int infected;

        while (file.hasNextLine()) {
            newRaces = new LinkedList<Race>();
            line = file.nextLine().toString().split(", *");
            stateName = line[0];
            for (int i = 0; i < racesNames.length; i++) {
                deaths = isValid(line[i + 1 + racesNames.length]);
                infected = isValid(line[i + 1]);

                newRaces.add(new Race(racesNames[i], infected, deaths));

            }
            newStates.add(new State(stateName, newRaces));

        }

        for (int i = 0; i < newStates.size(); i++) {
            StateCalculator stateSorter = new StateCalculator(newStates.get(i));
            System.out.println(newStates.get(i).getName());
            stateSorter.sort(true).convertToString();
            System.out.println("=====");
            stateSorter.sort(false).convertToString();
            System.out.println("=====");

        }

        return newStates;
    }


    private int isValid(String checker) {
        if (checker.equals("NA")) {
            return -1;
        }
        else {
            return Integer.valueOf(checker);
        }
    }


    private String[] readRaces(String[] item) {
        String[] races = new String[(item.length - 1) / 2];
        for (int i = 1; i <= races.length; i++) {
            races[i - 1] = item[i].replace("Cases_", "");
        }
        return races;
    }


    /**
     * @return the states
     */
    public LinkedList<State> getStates() {
        return states;
    }
}
