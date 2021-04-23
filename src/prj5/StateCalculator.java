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
    private Node<Race> sorted;

    public StateCalculator(LinkedList<Race> list) {
        this.list = list;

    }


    public LinkedList<Race> getList() {
        return list;

    }


    public void sortAlpha(Node<Race> headref) {
        // initially, no nodes in sorted list so its set to null
        sorted = null;
        Node<Race> current = headref;
        // traverse the linked list and add sorted node to sorted list
        while (current != null) {
            // Store current.next in next
            Node<Race> next = current.next();
            // current node goes in sorted list
            InsertSortedAlpha(current);
            // now next becomes current
            current = next;
        }
    }


    // insert a new node in sorted list
    public void InsertSortedAlpha(Node<Race> newNode) {
        // for head node
        if (sorted == null || sorted.getData().compareTo(newNode
            .getData()) >= 0) {
            sorted = newNode.next();
            sorted = newNode;
        }
        else {
            Node<Race> current = sorted;
            // find the node and then insert
            while (current.next() != null && current.next().getData().compareTo(
                newNode.getData()) < 0) {
                current = current.next();
            }
            newNode.setNext(current.next());
            current.setNext(newNode);
        }
    }


    public void sortCRF(Node<Race> headref) {
        // initially, no nodes in sorted list so its set to null
        sorted = null;
        Node<Race> current = headref;
        // traverse the linked list and add sorted node to sorted list
        while (current != null) {
            // Store current.next in next
            Node<Race> next = current.next();
            // current node goes in sorted list
            InsertSortedAlpha(current);
            // now next becomes current
            current = next;
        }
    }


    void Insert_sorted(Node<Race> newNode) {
        // for head node
        if (sorted == null || sorted.getData().getRatio() >= newNode.getData()
            .getRatio()) {
            newNode.setNext(sorted);
            sorted = newNode;
        }
        else {
            Node<Race> current = sorted;
            // find the node and then insert
            while (current.next() != null && current.next().getData()
                .getRatio() < newNode.getData().getRatio()) {
                current = current.next();
            }
            newNode.setNext(current.next());
            current.setNext(newNode);
        }
    }


    public LinkedList<Race> sortByCFR() {
        return list;
    }

}
