package prj5;

import student.TestCase;

/**
 * @author tejus
 * @version 4/25/2021
 *          test stateCalc class
 */
public class StateCalculatorTest extends TestCase {

    private StateCalculator calc;
  
    private LinkedList<Race> races;
    private LinkedList<Race> sorted;

    private LinkedList<Race> sorted1;
    /**
     * set up for the testcase
     */

    public void setUp() {
       Race race3 = new Race("other", 30, 1);
       Race race2 = new Race("asian", 30, 10);
       Race race = new Race("white", 15, 7);
       Race race1 = new Race("black", 15, 7);
            

        races = new LinkedList<Race>();
        races.add(race);
        races.add(race1);
        races.add(race2);
        races.add(race3);

        State state = new State("VA", races);
        calc = new StateCalculator(state);
        sorted = new LinkedList<Race>();
        sorted.add(race2);
        sorted.add(race1);
        sorted.add(race3);
        sorted.add(race);
        
        sorted1 = new LinkedList<Race>();
        sorted1.add(race1);
        sorted1.add(race);
        sorted1.add(race2);
        sorted1.add(race3);

    }


    /**
     * testing the sort method
     */
    public void testSort() {
        assertEquals(sorted1, calc.sort(false).getRaces());
        assertEquals(sorted, calc.sort(true).getRaces());
        assertEquals(sorted, calc.sort(true).getRaces());
        assertEquals(sorted1, calc.sort(false).getRaces());

    }

}
