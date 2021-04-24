package prj5;

import student.TestCase;

/**
 * @author Shanmuganathan Somashekar (shans)
 * @version 2021.04.23
 *
 */

public class StateTest extends TestCase {
    private State state;
    private LinkedList<Race> races;

    /**
     * set for the testCases
     */
    public void setUp() {

        Race race = new Race("white", 5, 10);
        Race race1 = new Race("black", 54, 10);
        Race race2 = new Race("asian", 57, 100);
        races = new LinkedList<Race>();
        races.add(race);
        races.add(race1);
        races.add(race2);
        state = new State("Virginia", races);
    }


    /**
     * testing the GetName method
     */
    public void testGetName() {
        assertEquals("Virginia", state.getName());
    }


    /**
     * testing the GetRaces method
     */
    public void testGetRaces() {
        assertEquals(races, state.getRaces());
    }

}
