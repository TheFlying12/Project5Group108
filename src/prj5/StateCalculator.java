/**
 * 
 */
package prj5;

import prj5.LinkedList.Node;

/**
 * @author Shanmuganathan Somashekar
 * @version 2021.04.23
 *
 */
public class StateCalculator {

    private LinkedList<Race> list;

    public StateCalculator(LinkedList<Race> list) {
        this.list = list;

    }


    public LinkedList<Race> getList() {
        return list;

    }


    public LinkedList<Race> sortAlpha() {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getName().compareTo(list.get(i).getName()) == 1) {
                LinkedList<Race> sorted = new LinkedList<Race>();
                Node<Race> current = sorted.getHead();
                while (current != null) {
                    Node<Race> next = current.next();
                    sortedInsert(current);
                    current.setNext(next);
                }
                sorted.head = sorted;

            }
        }

        return list;
    }


    public void sortedInsert(Node<Race> newnode) {
        Node<Race> current = newnode;
        while (current.next() != null && (current.next().getData().compareTo(
            newnode.getData()) == -1)) {
            current = current.next();
        }
        newnode.setNext(current.next());
        current.setNext(newnode);

    }


    public LinkedList<Race> sortByCFR() {
        return list;
    }

}
