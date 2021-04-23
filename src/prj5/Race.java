package prj5;

/**
 * This class represents a Race object which has a name and numbers for infected
 * and dead people
 * 
 * @author Patrick Stock (pstock)
 * @version 4/18/2021
 */
public class Race {

    private String name;
    private int infected;
    private int deaths;

    /**
     * Creates a new Race object
     * 
     * @param n
     *            name
     * @param inf
     *            infected people
     * @param de
     *            dead people
     */
    public Race(String n, int inf, int de) {
        name = n;
        infected = inf;
        deaths = de;
    }


    /**
     * Getter method for the name
     * 
     * @return the name of the race
     */
    public String getName() {
        return name;
    }


    /**
     * Getter method for the infected people
     * 
     * @return the number of infected people
     */
    public int getInfected() {
        return infected;
    }


    /**
     * Getter method for the dead people
     * 
     * @return the number of dead people
     */
    public int getDeaths() {
        return deaths;
    }


    /**
     * Gets a ratio of the deaths and infected as a floating point number
     * 
     * @return the ratio of dead people to infected people
     */
    public float getRatio() {
        return (float)deaths / (float)infected;
    }


    /**
     * Allows the comparison of two races based on their ratios
     * 
     * @param other
     *            Race object to compare to
     * @return 1 if greater than, 0 if the same, -1 if less than
     */
    public int compareTo(Race other) {
        if (this.getRatio() > other.getRatio()) {
            return 1;
        }
        else if (this.getRatio() == other.getRatio()) {
            return 0;
        }
        else {
            return -1;
        }
    }
}
