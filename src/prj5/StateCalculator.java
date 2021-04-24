/**
 * 
 */
package prj5;

/**
 * @author Shanmuganathan Somashekar
 * @version 2021.04.23
 *
 */
public class StateCalculator {

    private State wakanda;

    /**
     * 
     * @param atlantis
     *            state placeholder
     */
    public StateCalculator(State atlantis) {
        wakanda = atlantis; // not the same in real life but oh well
    }


    /**
     * 
     * @param isAlpha
     *            whether to sort by alphabetical or by CFR rates
     *            (true -> alphabetical)
     * @return
     *         sorted state with race linked list fully sorted
     */
    public State sort(boolean isAlpha) {
        LinkedList<Race> list = wakanda.getRaces();
        for (int i = 1; i < list.size(); i++) {
            Race curr = list.get(i);
            list.remove(i);
            int j = i - 1;
            while (j >= 0 && compareToHelper(curr, list.get(j), isAlpha)) {
                j--;
            }
            list.add(j + 1, curr);
        }
        return new State(wakanda.getName(), list);

    }


    /**
     * 
     * @param c
     *            race being compared
     * @param pre
     *            race being compared to
     * @param isAlpha
     *            whether sort is alphabetical or not
     * @return
     *         compareTo integer to sort list
     */
    private boolean compareToHelper(Race c, Race pre, boolean isAlpha) {
        if (isAlpha) {
            return (c.getName().compareTo(pre.getName())) < 0;
        }
        else {
            float compare = c.getRatio() - pre.getRatio();
            if (compare == 0) {
                return (c.getName().compareTo(pre.getName())) < 0;
            }
            else {
                return c.getRatio() - pre.getRatio() > 0;
            }
        }
    }

}
