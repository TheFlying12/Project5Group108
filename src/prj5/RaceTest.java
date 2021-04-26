package prj5;

import student.TestCase;

/**
 * This class tests all of the methods in the Race class
 * 
 * @author Patrick Stock (pstock)
 * @version 4/18/2021
 */
public class RaceTest extends TestCase {

    private Race white;

    /**
     * Sets up the objects for testing
     */
    public void setUp() {
        white = new Race("White", 100, 10);
    }


    /**
     * Tests the getName method
     */
    public void testGetName() {
        assertEquals("White", white.getName());
    }


    /**
     * Tests the getInfected method
     */
    public void testGetInfected() {
        assertEquals(100, white.getInfected());
    }


    /**
     * Tests the getDeaths method
     */
    public void testGetDeaths() {
        assertEquals(10, white.getDeaths());
    }


    /**
     * Tests the getRatio method
     */
    public void testGetRatio() {
        assertEquals(0.1, white.getRatio(), 0.001);
        white.setDeaths(-1);
        assertEquals((float)-.01, white.getRatio(), .01);
        white.setDeaths(10000);
        white.setInfected(-1);
        assertEquals((float)-.01, white.getRatio(), .01);
    }


    /**
     * test the setter methods
     */
    public void testSetters() {
        white.setDeaths(0);
        assertEquals(0, white.getDeaths());
        white.setInfected(0);
        assertEquals(0, white.getInfected());
        white.setName("Black");
        assertEquals("Black", white.getName());
    }


    /**
     * Tests the compareTo method
     */
    public void testCompareTo() {
        assertEquals(1, white.compareTo(new Race("Black", 100, 5)));
        assertEquals(0, white.compareTo(new Race("Asian", 100, 10)));
        assertEquals(-1, white.compareTo(new Race("Hispanic", 100, 15)));
    }


    /**
     * public void test toString
     */
    public void testToString() {
        assertEquals("white: 100 cases, 10% CFR", white.toString());
    }
}
