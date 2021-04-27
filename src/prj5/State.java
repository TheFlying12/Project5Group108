/**
 * 
 */
package prj5;

/**
 * @author Shanmuganathan Somashekar (shans)
 * @version 2021.04.23
 *
 */
public class State {
    private String name;
    private LinkedList<Race> races;

    /**
     * This class gets the data releated to the state
     * 
     * @param name
     *            name of state
     * @param races
     *            linked list of races
     */
    public State(String name, LinkedList<Race> races) {
        this.name = name;
        this.races = races;
    }


    /**
     * this method gets the name
     * 
     * @return name
     *         name of thing
     */
    public String getName() {
        return name;
    }


    /**
     * sets stateName
     * 
     * @param newName
     *            new name to be set for this state
     */
    public void setName(String newName) {
        this.name = newName;
    }


    /**
     * this method returns the races.
     * 
     * @return races
     *         all of the races
     */
    public LinkedList<Race> getRaces() {
        return races;
    }


    /**
     * convert the state to a string representation
     */
    public void convertToString() {
        for (int i = 0; i < this.races.size(); i++) {
            System.out.println(this.getRaces().get(i).toString());
        }

    }

}
