/**
 * 
 */
package covid;

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
     */
    public State(String name, LinkedList<Race> races) {
        this.name = name;
        this.races = races;
    }
    /**
     * this method gets the name
     * @return
     */
    public String getName() {
        return name;
    }
    /**
     * this method returns the races. 
     * @return
     */
    public LinkedList<Race> getRaces() {
        return races; 
    }

}
