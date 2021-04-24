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
    public DataReader(String fileName)
        throws FileNotFoundException {
        states = readFile(fileName);
    }


    private LinkedList<State> readFile(String fileName)
        throws FileNotFoundException {
        Scanner file = new Scanner(new File(fileName));
        LinkedList<State> newStates = new LinkedList<State>();
        LinkedList<Race> newRaces = new LinkedList<Race>();
        String[] line = file.nextLine().split("Cases_");

        for (int i = 1; i < line.length - 1; i++) {
            newRaces.add(new Race(line[i], 0, 0));
        }
        newRaces.add(new Race("Other", 0, 0));

        while (file.hasNext()) {
            line = file.nextLine().split(",");
            for (int i = 1; i < 6; i++) {
                if (line[i].equals("NA")) {
                    newRaces.get(i - 1).setInfected(-1);
                }
                newRaces.get(i - 1).setInfected(Integer.valueOf(line[i]));
            }
            for (int i = 6; i < line.length; i++) {
                if (line[i].equals("NA")) {
                    newRaces.get(i - 1).setDeaths(-1);
                }
                newRaces.get(i - 6).setDeaths(Integer.valueOf(line[i]));
            }
            newStates.add(new State(line[0], newRaces));
        }
        for(int i =0; i<newStates.size(); i++) {
            System.out.println(newStates.get(i).getName());
            for(int j = 0; j<newStates.get(i).getRaces().size(); j++) {
            System.out.println(newStates.get(j).getRaces().get(j).getName() +": "+newStates.get(j).getRaces().get(j).getRatio());
        }
            System.out.println("=====");
        }

        return newStates;
    }
   
    
    
}
