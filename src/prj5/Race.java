package prj5;

import java.text.DecimalFormat;

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
    private DecimalFormat deci;

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
        deci = new DecimalFormat("0.#");
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
     * Setter method for the name
     * 
     * @param name
     *            name to be set
     */
    public void setName(String name) {
        this.name = name;
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
     * Setter method for the infected people
     * 
     * @param inf
     *            thing to get points
     */
    public void setInfected(int inf) {
        infected = inf;
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
     * Setter method for the dead people
     * 
     * @param de
     *            total deaths
     */
    public void setDeaths(int de) {
        deaths = de;
    }


    /**
     * Gets a ratio of the deaths and infected as a floating point number
     * 
     * @return the ratio of dead people to infected people
     */
    public float getRatio() {
        if (infected == -1 || deaths == -1) {
            return (float)-.01;
        }
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


    /**
     * @return string of Race
     */
    public String toString() {
        String str = this.getName().toLowerCase() + ": " + this.infected
            + " cases, " + deci.format(this.getRatio() * 100) + "% CFR";
        return str;
    }
}
