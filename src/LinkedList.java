import java.util.Iterator;

/**
 * @author tejus
 * @param <E>
 *
 */
public class LinkedList<E> implements Iterator<E> {
    private Node<E> head;
    private Node<E> end;
    private int length;

    @Override
    public boolean hasNext() {
        // TODO Auto-generated method stub
        return false;
    }


    @Override
    public E next() {
        // TODO Auto-generated method stub
        return null;
    }


    public E getFront() {
        if (isEmpty()) {
            return null;
        }
        return head.getData();
    }


    public boolean isEmpty() {
        return head == null;
    }


    public void clear() {
        head = null;
        end = null;
        length = 0;

    }


    public int getLength() {
        return length;
    }

    public class Node<E> {
        private E data; // Entry in Node
        private Node<E> next; // Link to next node

        public Node(E dataPortion) {
            this(dataPortion, null);
        } // end constructor


        public Node(E dataPortion, Node<E> nextNode) {
            data = dataPortion;
            next = nextNode;
        } // end constructor


        public E getData() {
            if (data != null) {
                return data;
            }
            return null;
        }


        public Node<E> getNext() {
            return next;
        }


        public void setNext(Node<E> newNext) {
            next = newNext;
        }

    }
}
