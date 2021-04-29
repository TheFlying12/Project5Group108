package prj5;

import student.TestCase;

/**
 * 
 * @author tejus
 * @version 4/25/2021
 *          test stateCalc class
 */
public class StateCalculatorTest extends TestCase {

    private StateCalculator calc;
    private Race race;
    private Race race1;
    private Race race2;


    /**
     * set up for the testcase
     */

    public void setUp() {
        LinkedList<Race> races = new LinkedList<Race>();
        races.add(new Race("White", 10, 20));
        races.add(new Race("Black", 10, 20));
        races.add(new Race("Asian", 10, 30));
        State state = new State("VA", races);
        calc = new StateCalculator(state);
        race = new Race("white", 5, 10);
        race1 = new Race("black", 54, 10);
        race2 = new Race("asian", 54, 10);
       
    }


    /**
     * testing the sort method
     */
    public void testSort() {
        assertEquals("VA", calc.sort(false).getName());
        assertEquals("VA", calc.sort(true).getName());
    }
    
    public void testCompareToHelper() {
        assertEquals(true, calc.compareToHelper(race, race1, false) );
        assertEquals(false, calc.compareToHelper(race1, race, false) );
        assertEquals(false, calc.compareToHelper(race, race1, true) );
        assertEquals(true, calc.compareToHelper(race1, race, true) );
        assertEquals(true, calc.compareToHelper(race2, race1, false) );
        assertEquals(false, calc.compareToHelper(race1, race2, false) );
        
    }
    

}
