package prj5;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * linked list this
 * 
 * @author tejus
 *
 * @param <E>
 * 
 * @version 4/25/2021
 */
public class LinkedList<E> {

    /**
     * This represents a node in a singly linked list. This node stores data
     * along with having a pointer to the next node in the list
     *
     * @param <E>
     * @author tejus (tejusj)
     * @version 4/25/2021
     * 
     */
    public static class Node<E> {

        // The data element stored in the node.
        private E data;

        // The next node in the sequence.
        private Node<E> next;

        /**
         * Creates a new node with the given data
         *
         * @param d
         *            the data to put inside the node
         */
        public Node(E d) {
            data = d;
        }


        /**
         * Sets the node after this node
         *
         * @param n
         *            the node after this one
         */
        public void setNext(Node<E> n) {
            next = n;
        }


        /**
         * Gets the next node
         *
         * @return the next node
         */
        public Node<E> next() {
            return next;
        }


        /**
         * Gets the data in the node
         *
         * @return the data in the node
         */
        public E getData() {
            return data;
        }

    }

    private Node<E> head;

    // the size of the linked list
    private int size;

    /**
     * Creates a new LinkedList object
     */
    public LinkedList() {
        setHead(null);
        size = 0;

    }


    /**
     * Gets the number of elements in the list
     *
     * @return the number of elements
     */

    public int size() {
        return size;
    }


    /**
     * 
     * @return head node
     */
    public Node<E> getHead() {
        return head;
    }


    /**
     * Adds the object to the position in the list
     *
     * @precondition obj cannot be null
     * @param index
     *            where to add the object
     * @param obj
     *            the object to add
     * @throws IndexOutOfBoundsException
     *             if index is less than zero or greater than size
     * @throws IllegalArgumentException
     *             if obj is null
     */
    public void add(int index, E obj) {
        // check if the object is null
        if (obj == null) {
            throw new IllegalArgumentException("Object is null");
        }

        // check if the index is out of bounds
        if ((index < 0) || (index > size())) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }

        Node<E> current = getHead();

        // empty stack case
        if (isEmpty()) {
            setHead(new Node<E>(obj));
        }

        // all other cases
        else {
            if (index == 0) {
                Node<E> newNode = new Node<E>(obj);
                newNode.setNext(getHead());
                setHead(newNode);
            }
            else {
                int currentIndex = 0;
                while (current != null) {
                    if ((currentIndex + 1) == index) {
                        Node<E> nextNext = current.next;
                        Node<E> newNode = new Node<E>(obj);
                        current.setNext(newNode);
                        newNode.setNext(nextNext);

                    }
                    currentIndex++;
                    current = current.next();
                }
            }
        }
        size++;
    }


    /**
     * Adds the object to the end of the list.
     *
     * @precondition obj cannot be null
     * @param obj
     *            the object to add
     * @throws IllegalArgumentException
     *             if obj is null
     */

    public void add(E obj) {
        // check if the object is null
        if (obj == null) {
            throw new IllegalArgumentException("Object is null");
        }

        Node<E> current = getHead();

        // empty stack case
        if (isEmpty()) {
            setHead(new Node<E>(obj));
        }

        // other cases
        else {
            while (current.next != null) {
                current = current.next;
            }
            current.setNext(new Node<E>(obj));
        }
        size++;
    }


    /**
     * Checks if the array is empty
     *
     * @return true if the array is empty
     */

    public boolean isEmpty() {
        return (size == 0);
    }


    /**
     * Removes the first instance of the given object from the list
     *
     * @param obj
     *            the object to remove
     * @return true if successful
     */

    public boolean remove(E obj) {
        Node<E> current = getHead();

        // account for matching head
        if ((null != getHead()) && (obj.equals(current.data))) {
            setHead(getHead().next);
            size--;
            return true;
        }

        // account for 2+ size
        while (size() >= 2 && (current.next != null)) {
            if ((obj.equals(current.next.data))) {
                if (current.next.next != null) {
                    current.setNext(current.next.next);
                }
                else {
                    current.setNext(null);
                }
                size--;
                return true;
            }
            current = current.next;
        }

        // this accounts for the isEmpty case or the object does not exist
        return false;
    }


    /**
     * Removes the object at the given position
     *
     * @param index
     *            the position of the object
     * @return true if the removal was successful
     * @throws IndexOutOfBoundsException
     *             if there is not an element at the index
     */

    public boolean remove(int index) {
        // if the index is invalid
        if (index < 0 || getHead() == null) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
        else {
            Node<E> current = getHead();
            int currentIndex = 0;
            if (size == 1) {
                setHead(null);
                size--;
                return true;
            }
            if (index == 0) {
                setHead(getHead().next);
                size--;
                return true;
            }
            while (current.next != null) {
                if ((currentIndex + 1) == index) {
                    Node<E> newNext = current.next.next;
                    current.setNext(newNext);
                    size--;
                    return true;
                }

                current = current.next;
                currentIndex++;
            }

            // if the element was never found, this also handles empty case
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
    }


    /**
     * Gets the object at the given position
     *
     * @param index
     *            where the object is located
     * @return The object at the given position
     * @throws IndexOutOfBoundsException
     *             if no node at the given index
     */

    public E get(int index) {
        Node<E> current = getHead();
        int currentIndex = 0;
        E data = null;

        while (current != null) {
            if (currentIndex == index) {
                data = current.data;
            }
            currentIndex++;
            current = current.next;
        }

        // check if the data was null...
        if (data == null) {
            // ... if so throw an exception
            throw new IndexOutOfBoundsException("Index exceeds the size.");
        }
        return data;
    }


    /**
     * Checks if the list contains the given object
     *
     * @param obj
     *            the object to check for
     * @return true if it contains the object
     */

    public boolean contains(E obj) {
        Node<E> current = getHead();
        while (current != null) {
            if (obj.equals(current.data)) {
                return true;
            }
            current = current.next;
        }

        return false;
    }


    /**
     * Removes all of the elements from the list
     */

    public void clear() {
        // make sure we don't call clear on an empty list
        if (getHead() != null) {
            getHead().setNext(null);
            setHead(null);
            size = 0;
        }
    }


    /**
     * Gets the last time the given object is in the list
     *
     * @param obj
     *            the object to look for
     * @return the last position of it. -1 If it is not in the list
     */

    public int lastIndexOf(E obj) {
        int lastIndex = -1;
        Node<E> current = getHead();
        int currentIndex = 0;
        while (current != null) {
            if (obj.equals(current.data)) {
                lastIndex = currentIndex;
            }
            currentIndex++;
            current = current.next;

        }
        return lastIndex;
    }


    /**
     * Returns a string representation of the list If a list contains A, B, and
     * C, the following should be returned "{A, B, C}" (Without the quotations)
     *
     * @return a string representing the list
     */

    public String toString() {
        String result = "{";

        Node<E> current = getHead();
        while (current != null) {
            result += "" + current.data;
            current = current.next;
            if (current != null) {
                result += ", ";
            }
        }
        result += "}";
        return result;
    }


    /**
     * Returns an array representation of the list If a list contains A, B, and
     * C, the following should be returned {A, B, C}, If a list
     * contains A, B, C, and C the following should be returned {A, B, C, C}
     *
     * @return an array representing the list
     */
    public Object[] toArray() {

        Object[] array = new Object[this.size()];

        Node<E> current = getHead();
        int count = 0;
        while (current != null) {
            array[count] = current.getData();
            current = current.next;
            count++;
        }

        return array;
    }


    /**
     * Returns true if both lists have the exact same contents
     * in the exact same order
     *
     * @param obj
     *            i hate webcat
     *
     * @return a boolean of whether two lists have the same contents,
     *         item per item and in the same order
     */

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() == obj.getClass()) {
            @SuppressWarnings("unchecked")
            LinkedList<E> other = ((LinkedList<E>)obj);
            if (other.size() == this.size()) {
                Node<E> current = getHead();
                Node<E> otherCurrent = other.getHead();
                while (current != null) {
                    if (!current.getData().equals(otherCurrent.getData())) {
                        return false;
                    }
                    current = current.next();
                    otherCurrent = otherCurrent.next();
                }
                return true;
            }
        }

        return false;
    }


    /**
     * Iterator method creates Iterator object
     *
     * @return new Iterator object
     */
    public Iterator<E> iterator() {
        return new LinkedListIterator<E>();
    }


    /**
     * set the head
     * 
     * @param sorted
     *            head node to be sorted
     */
    public void setHead(Node<E> sorted) {
        this.head = sorted;
    }

    private class LinkedListIterator<A> implements Iterator<E> {

        private Node<E> current;

        /**
         * Creates a new DLListIterator
         */
        public LinkedListIterator() {
            current = getHead();
        }


        /**
         * Checks if there are more elements in the list
         *
         * @return true if there are more elements in the list
         */

        public boolean hasNext() {

            return current.next() != null;
        }


        /**
         * Gets the next value in the list
         *
         * @return the next value
         * @throws NoSuchElementException
         *             if there are no nodes left in the list
         */

        public E next() {
            if (this.hasNext()) {
                current = current.next();
                return current.getData();
            }
            throw new NoSuchElementException("No next element");
        }

    }

}
