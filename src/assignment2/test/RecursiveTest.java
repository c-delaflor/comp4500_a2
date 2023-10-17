package assignment2.test;

import assignment2.*;
import java.util.*;

import org.junit.Assert;
import org.junit.Test;

/**
 * Basic tests for the {@link Recursive} implementation class.
 * 
 * We will use a much more comprehensive test suite to test your code, so you should add
 * your own tests to this test suite to help you to debug your implementation.
 */
public class RecursiveTest {

    /** Boundary case: there are no passengers. */
    @Test
    public void basicTestRecursive0() throws Exception {
        /* Initialise parameters to the test */
        ArrayList<Passenger> passengers = new ArrayList<>();

        /* Expected output */
        int expected = 0;

        /* Execute the test and compare expected and actual results */
        int actual = Recursive.optimalRecursive(passengers);
        Assert.assertEquals(expected, actual);
    }

    /** Boundary case: there is only one passenger. */
    @Test
    public void basicTestRecursive1() throws Exception {
        /* Initialise parameters to the test */
        ArrayList<Passenger> passengers = new ArrayList<>();
        passengers.add(new Passenger(2, 6, 1, 5, new int[] { 1, 2, 2, 4 }));

        /* Expected output */
        int expected = 1;

        /* Execute the test and compare expected and actual results */
        int actual = Recursive.optimalRecursive(new ArrayList<>(passengers));
        Assert.assertEquals(expected, actual);
    }

    /**
     * Boundary case: many passengers, possible to check-in all of them, and optimal to
     * check in all of them.
     */
    @Test
    public void basicTestRecursive2() throws Exception {
        /* Initialise parameters to the test */
        ArrayList<Passenger> passengers = new ArrayList<>();
        passengers.add(new Passenger(0, 10, 2, 11, new int[] { 0, 0, 0, 0, 1, 1, 1, 1, 1 }));
        passengers.add(new Passenger(0, 3, 1, 15, new int[] { 0, 1, 4 }));
        passengers.add(new Passenger(0, 8, 4, 12, new int[] { 1, 2, 2, 5, 6 }));
        passengers.add(new Passenger(4, 9, 2, 10, new int[] { 0, 1, 2, 3 }));
        passengers.add(new Passenger(12, 14, 1, 10, new int[] { 0, 1 }));
        passengers.add(new Passenger(13, 14, 1, 5, new int[] { 2 }));

        /* Expected output */
        int expected = 0 + 4 + 5 + 3 + 0 + 2;

        /* Execute the test and compare expected and actual results */
        int actual = Recursive.optimalRecursive(passengers);
        Assert.assertEquals(expected, actual);
    }

    /**
     * Typical case (from hand-out): many passengers, possible to check-in all of them,
     * but not optimal to check in all of them.
     */
    @Test
    public void basicTestRecursive3() throws Exception {
        /* Initialise parameters to the test */
        ArrayList<Passenger> passengers = new ArrayList<>();
        passengers.add(new Passenger(0, 10, 2, 3, new int[] { 0, 0, 0, 0, 1, 1, 1, 1, 1 }));
        passengers.add(new Passenger(0, 3, 1, 15, new int[] { 0, 1, 4 }));
        passengers.add(new Passenger(0, 8, 4, 7, new int[] { 1, 2, 2, 5, 6 }));
        passengers.add(new Passenger(4, 9, 2, 10, new int[] { 0, 6, 6, 6 }));
        passengers.add(new Passenger(12, 14, 1, 10, new int[] { 0, 1 }));
        passengers.add(new Passenger(13, 14, 1, 5, new int[] { 2 }));

        /* Expected output */
        int expected = 3 + 0 + 7 + 0 + 0 + 2;

        /* Execute the test and compare expected and actual results */
        int actual = Recursive.optimalRecursive(passengers);
        Assert.assertEquals(expected, actual);
    }



}
