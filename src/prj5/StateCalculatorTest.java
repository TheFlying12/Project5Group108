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

    public void setUp() {
        LinkedList<Race> races = new LinkedList<Race>();
        races.add(new Race("White", 10, 20));
        races.add(new Race("Black", 10, 20));
        races.add(new Race("Asian", 10, 30));
        State state = new State("VA", races);
        calc = new StateCalculator(state);
    }


    public void testSort() {
        assertEquals("VA", calc.sort(false).getName());
        assertEquals("VA", calc.sort(true).getName());
    }
}
