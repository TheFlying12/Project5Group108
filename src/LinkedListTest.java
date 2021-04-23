
/**
 *
 */

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import student.TestCase;

public class LinkedListTest extends TestCase {

    private LinkedList<String> emptyListA;
    private LinkedList<String> emptyListB;
    private LinkedList<String> smallListA;
    private LinkedList<String> smallListB;
    private LinkedList<String> bigListA;
    private LinkedList<String> bigListB;
    private LinkedList<String> list;
    private String nullObject;

    /**
     * Initializes 2 empty lists, 2 lists with a small number of items, and 2
     * lists with a large number of items
     */
    public void setUp() {
        emptyListA = new LinkedList<String>();
        emptyListB = new LinkedList<String>();

        smallListA = new LinkedList<String>();
        smallListB = new LinkedList<String>();

        smallListA.add("soccer");
        smallListA.add("swimming");
        smallListA.add("gymnastics");

        smallListB.add("soccer");
        smallListB.add("swimming");
        smallListB.add("gymnastics");

        bigListA = new LinkedList<String>();

        for (int i = 0; i < 100; i++) {
            bigListA.add("sport" + i);
        }

        bigListB = new LinkedList<String>();
        for (int i = 0; i < 100; i++) {
            bigListB.add("sport" + i);
        }

        // to be explicit
        nullObject = null;
    }


    /**
     * Tests the equals method on an empty list
     */
    public void testEqualsEmptyList() {
        assertEquals(emptyListA, emptyListA);
        assertEquals(emptyListA, emptyListB);
        assertFalse(emptyListA.equals(nullObject));
        assertFalse(emptyListA.equals("soccer"));
        assertFalse(emptyListA.equals(smallListA));
        assertFalse(smallListA.equals(emptyListA));
        emptyListB.add("jump roping");
        assertFalse(emptyListA.equals(emptyListB));
        smallListA.clear();
        assertEquals(emptyListA, smallListA);
    }


    /**
     * Tests the equals method on a list with a small number of items in it
     */
    public void testEqualsSmallList() {
        assertEquals(smallListA, smallListA);
        assertEquals(smallListA, smallListB);
        assertFalse(smallListA.equals(nullObject));
        assertFalse(smallListA.equals("soccer"));
        assertFalse(smallListA.equals(bigListA));
        assertFalse(smallListA.equals(emptyListA));
        smallListB.add("jump roping");
        assertFalse(smallListA.equals(smallListB));

        // Make smallListA and smallListB differ in
        // content, but have the same size
        smallListA.add("rope jumping");
        assertFalse(smallListA.equals(smallListB));

        // Replace the last element in smallListA
        // to make smallListA and smallListB equal again
        smallListA.remove("rope jumping");
        smallListA.add("jump roping");
        assertEquals(smallListA, smallListB);
    }


    /**
     * Tests the equals method on a list with a large number of items in it
     */
    public void testEqualsBigList() {
        assertEquals(bigListA, bigListA);
        assertEquals(bigListA, bigListB);
        assertFalse(bigListA.equals(nullObject));
        assertFalse(bigListA.equals("soccer"));
        assertFalse(bigListA.equals(smallListA));
        assertFalse(bigListA.equals(emptyListA));
        bigListB.add("jump roping");
        assertFalse(bigListA.equals(bigListB));

        // Same content, same size, but reversed
        bigListB.clear();
        assertFalse(bigListA.equals(bigListB));
        for (int i = 100; i > 0; i--) {
            bigListB.add("sport" + i);
        }
        assertFalse(bigListA.equals(bigListB));

        // one a subset of the other but with dups
        bigListB.clear();
        assertFalse(bigListA.equals(bigListB));
        for (int i = 0; i < 50; i++) {
            bigListB.add("sport" + i);
        }
        for (int i = 0; i < 50; i++) {
            bigListB.add("sport" + i);
        }
        assertFalse(bigListA.equals(bigListB));

        // make them equal again
        bigListB.clear();
        assertFalse(bigListA.equals(bigListB));
        for (int i = 0; i < 100; i++) {
            bigListB.add("sport" + i);
        }
        assertEquals(bigListA, bigListB);

    }


    /**
     * Tests the toArray method on an empty list
     */
    public void testToArrayEmpty() {

        Object[] emptyArray = {};
        assertTrue(Arrays.equals(emptyListA.toArray(), emptyArray));
        assertTrue(Arrays.equals(emptyListA.toArray(), emptyListB.toArray()));
        assertFalse(Arrays.equals(emptyListA.toArray(), smallListB.toArray()));
        Object[] oneItemArray = { "one thing" };
        emptyListA.add("one thing");
        assertTrue(Arrays.equals(emptyListA.toArray(), oneItemArray));

    }


    /**
     * Tests the toArray method on a list with items in it
     */
    public void testToArrayContents() {

        Object[] origArray = { "soccer", "swimming", "gymnastics" };
        assertTrue(Arrays.equals(smallListA.toArray(), origArray));
        assertTrue(Arrays.equals(emptyListA.toArray(), emptyListB.toArray()));
        assertFalse(Arrays.equals(smallListA.toArray(), bigListB.toArray()));

    }


    /**
     * test add method
     */
    public void testAddWithIndex() {
        assertEquals(0, emptyListA.size());
        Exception exception = null;
        try {
            emptyListA.add(0, nullObject);
        }
        catch (Exception e) {
            exception = e;
        }
        assertNotNull(exception);
        assertTrue(exception instanceof IllegalArgumentException);

        exception = null;
        try {
            emptyListA.add(-1, "plsWebCat");
        }
        catch (Exception e) {
            exception = e;
        }
        assertNotNull(exception);
        assertTrue(exception instanceof IndexOutOfBoundsException);

        exception = null;
        try {
            emptyListA.add(emptyListA.size() + 1, "plsWebCat");
        }
        catch (Exception e) {
            exception = e;
        }
        assertNotNull(exception);
        assertTrue(exception instanceof IndexOutOfBoundsException);

        emptyListA.add(0, "plsWebCat");
        assertEquals(1, emptyListA.size());

        emptyListA.add(1, "plsWebCatAgain");
        assertEquals(2, emptyListA.size());

        exception = null;
        try {
            emptyListA.add(nullObject);
        }
        catch (Exception e) {
            exception = e;
        }
        assertNotNull(exception);
        assertTrue(exception instanceof IllegalArgumentException);

        smallListA.add(0, "basketball");
        assertEquals(smallListA.size(), 4);

    }


    /**
     * test remove with object
     */
    public void testRemoveWithObject() {
        assertEquals(3, smallListA.size());
        // size
        assertFalse(smallListA.remove("Hokeis"));
        assertTrue(smallListA.remove("swimming"));
        assertEquals(2, smallListA.size());
        assertTrue(smallListA.remove("gymnastics"));
        assertEquals(1, smallListA.size());
        assertFalse(smallListA.remove("webCat"));

        assertEquals(emptyListA.size(), 0);
        emptyListA.add("testingIsGood");
        assertEquals(emptyListA.size(), 1);
        assertTrue(emptyListA.remove("testingIsGood"));
        assertEquals(emptyListA.size(), 0);
        // remove when list is empty
        assertFalse(emptyListA.remove("BeatFlorida"));

    }


    /**
     * test remove with index
     */
    public void testRemoveWithIndex() {
        // empty list
        Exception exception = null;
        try {
            emptyListA.remove(2);
        }
        catch (Exception e) {
            exception = e;
        }
        assertNotNull(exception);
        assertTrue(exception instanceof IndexOutOfBoundsException);

        // index is negative
        exception = null;
        try {
            smallListA.remove(-1);
        }
        catch (Exception e) {
            exception = e;
        }
        assertNotNull(exception);
        assertTrue(exception instanceof IndexOutOfBoundsException);

        // index is too big
        exception = null;
        try {
            smallListA.remove(smallListA.size() + 1);
        }
        catch (Exception e) {
            exception = e;
        }
        assertNotNull(exception);
        assertTrue(exception instanceof IndexOutOfBoundsException);
        // index exists
        assertTrue(smallListA.remove(2));
        assertTrue(smallListA.remove(1));
        assertEquals(smallListA.size(), 1);
        assertTrue(smallListA.remove(1));

        assertTrue(smallListB.remove(0));

        exception = null;
        try {
            smallListB.remove(3);
        }
        catch (Exception e) {
            exception = e;
        }
        assertNotNull(exception);
        assertTrue(exception instanceof IndexOutOfBoundsException);

    }


    /**
     * test get method
     */
    public void testGet() {
        Exception exception = null;
        try {
            emptyListA.get(2);
        }
        catch (Exception e) {
            exception = e;
        }
        assertNotNull(exception);
        assertTrue(exception instanceof IndexOutOfBoundsException);

        exception = null;
        try

        {
            emptyListA.get(2);
        }
        catch (Exception e) {
            exception = e;
        }

        assertNotNull(exception);
        assertTrue(exception instanceof IndexOutOfBoundsException);

        assertEquals("swimming", smallListA.get(1));
    }


    /**
     * test contains
     */
    public void testContains() {
        assertEquals(emptyListA.contains("webcat"), false);
        assertTrue(smallListA.contains("swimming"));
    }


    /**
     * test empty method
     */
    public void testEmpty() {
        assertEquals(3, smallListA.size());
        smallListA.clear();
        assertEquals(0, smallListA.size());
        assertTrue(smallListA.isEmpty());
        emptyListA.clear();
        assertTrue(emptyListA.isEmpty());
    }


    /**
     * test lastIndexOf method
     */
    public void testLastIndexOf() {
        assertEquals(1, smallListA.lastIndexOf("swimming"));
        bigListB.add("item");
        assertEquals(25, bigListB.lastIndexOf("sport25"));
    }


    /**
     * test toString
     */
    public void testToString() {
        assertEquals("{}", emptyListA.toString());
        assertEquals("{soccer, swimming, gymnastics}", smallListA.toString());
    }


    /**
     * Tests all the methods in the private class DLListIterator
     */
    public void testIterator() {
        list = new LinkedList<String>();
        Iterator<String> itr = list.iterator();
        list.add("vanilla");
        list.add("chocolate");
        list.add("strawberry");
        assertTrue(itr.hasNext());
        assertEquals(list.size(), 3);
        assertEquals(itr.next(), "vanilla");
        itr.remove();
        assertEquals(list.size(), 2);
        assertEquals(itr.next(), "chocolate");
        itr.remove();
        assertEquals(list.size(), 1);
        assertEquals(itr.next(), "strawberry");
        itr.remove();
        assertEquals(list.size(), 0);
        assertFalse(itr.hasNext());

        Exception thrown = null;
        try {
            itr.next();
        }
        catch (NoSuchElementException e) {
            thrown = e;
        }
        assertNotNull(thrown);
    }

}
