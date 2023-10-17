package assignment2.test;

import assignment2.*;
import java.util.*;
import org.junit.Assert;
import org.junit.Test;

/**
 * Basic tests for the {@link Dynamic} implementation class.
 * 
 * We will use a much more comprehensive test suite to test your code, so you should add
 * your own tests to this test suite to help you to debug your implementation.
 */
public class DynamicTest {

    /** Boundary case: there are no passengers. */
    @Test
    public void basicTestDynamic0() throws Exception {
        /* Initialise parameters to the test */
        ArrayList<Passenger> passengers = new ArrayList<>();

        /* Expected output */
        int expected = 0;

        /* Execute the test and compare expected and actual results */
        int actual = Dynamic.optimalDynamic(passengers);
        Assert.assertEquals(expected, actual);
    }

    /** Boundary case: there is only one passenger. */
    @Test
    public void basicTestDynamic1() throws Exception {
        /* Initialise parameters to the test */
        ArrayList<Passenger> passengers = new ArrayList<>();
        passengers.add(new Passenger(2, 6, 1, 5, new int[] { 1, 2, 2, 4 }));
        /* Expected output */
        int expected = 1;

        /* Execute the test and compare expected and actual results */
        int actual = Dynamic.optimalDynamic(passengers);
        Assert.assertEquals(expected, actual);
    }

    /**
     * Boundary case: many passengers, possible to check-in all of them, and optimal to
     * check in all of them.
     */
    @Test
    public void basicTestDynamic2() throws Exception {
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
        int actual = Dynamic.optimalDynamic(passengers);
        Assert.assertEquals(expected, actual);
    }

    /**
     * Typical case (from hand-out): many passengers, possible to check-in all of them,
     * but not optimal to check in all of them.
     */
    @Test
    public void basicTestDynamic3() throws Exception {
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
        int actual = Dynamic.optimalDynamic(passengers);
        Assert.assertEquals(expected, actual);
    }

    /** Boundary case: there are no passengers. */
    @Test
    public void basicTestSolutionDynamic0() throws Exception {
        /* Initialise parameters to the test */
        ArrayList<Passenger> passengers = new ArrayList<>();

        /* Expected output */
        int expected = 0;

        /* Execute the test and compare expected and actual results */
        ArrayList<Integer> actualPlan = Dynamic
                .optimalSolutionDynamic((new ArrayList<>(passengers)));
        checkPlan(passengers, actualPlan);
        int actual = totalFrustration(passengers, actualPlan);
        Assert.assertEquals(expected, actual);
    }

    /** Boundary case: there is only one passenger. */
    @Test
    public void basicTestSolutionDynamic1() throws Exception {
        /* Initialise parameters to the test */
        ArrayList<Passenger> passengers = new ArrayList<>();
        passengers.add(new Passenger(2, 6, 1, 5, new int[] { 1, 2, 2, 4 }));

        /* Expected output */
        int expected = 1;

        /* Execute the test and compare expected and actual results */
        ArrayList<Integer> actualPlan = Dynamic
                .optimalSolutionDynamic((new ArrayList<>(passengers)));
        checkPlan(passengers, actualPlan);
        int actual = totalFrustration(passengers, actualPlan);
        Assert.assertEquals(expected, actual);
    }

    /**
     * Boundary case: many passengers, possible to check-in all of them, and optimal to
     * check in all of them.
     */
    @Test
    public void basicTestSolutionDynamic2() throws Exception {
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
        ArrayList<Integer> actualPlan = Dynamic
                .optimalSolutionDynamic((new ArrayList<>(passengers)));
        checkPlan(passengers, actualPlan);
        int actual = totalFrustration(passengers, actualPlan);
        Assert.assertEquals(expected, actual);
    }

    /**
     * Typical case (from hand-out): many passengers, possible to check-in all of them,
     * but not optimal to check in all of them.
     */
    @Test
    public void basicTestSolutionDynamic3() throws Exception {
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
        ArrayList<Integer> actualPlan = Dynamic
                .optimalSolutionDynamic((new ArrayList<>(passengers)));
        checkPlan(passengers, actualPlan);
        int actual = totalFrustration(passengers, actualPlan);
        Assert.assertEquals(expected, actual);
    }

    /*--------Helper methods------------*/

    /**
     * Checks if the plan is valid for the given list of passengers.
     */
    private void checkPlan(ArrayList<Passenger> passengers, ArrayList<Integer> plan) {
        // There must be a plan for each passenger.
        Assert.assertTrue(passengers.size() == plan.size());
        /*
         * The index of the last checked-in passenger (before the ith passenger), if there
         * is one, or -1 otherwise.
         */
        int lastCheckedInPassenger = -1;
        for (int i = 0; i < passengers.size(); i++) {
            Passenger next = passengers.get(i);
            if (plan.get(i) != null) {
                // The next passenger is not cancelled.
                // Check that they will not commence check-in before they have arrived.
                Assert.assertTrue(plan.get(i) >= next.arrival());
                // Check that they will be checked-in on time to catch their boat.
                Assert.assertTrue(plan.get(i) + next.checkInTime() <= next.departure());
                /*
                 * Check that all non-cancelled customers that come before them in the
                 * list have completed check-in before the next passenger is planned to
                 * commence check-in.
                 */
                if (lastCheckedInPassenger != -1) {
                    Passenger last = passengers.get(lastCheckedInPassenger);
                    Assert.assertTrue(
                            plan.get(i) >= plan.get(lastCheckedInPassenger) + last.checkInTime());
                }
                lastCheckedInPassenger = i;
            }
        }
    }

    /**
     * Calculates the total frustration of the passengers given the plan.
     * 
     * @require Assumes that the plan is valid for the given list of passengers.
     */
    private int totalFrustration(ArrayList<Passenger> passengers, ArrayList<Integer> plan) {
        int totalFrustration = 0;
        for (int i = 0; i < passengers.size(); i++) {
            Passenger next = passengers.get(i);
            if (plan.get(i) == null) {
                // The passenger has had their ticket cancelled.
                totalFrustration += next.cancelFrustration();
            } else {
                // The passenger has had to wait to commence check-in.
                int waitTime = plan.get(i) - next.arrival();
                totalFrustration += next.waitFrustration(waitTime);
            }
        }
        return totalFrustration;
    }

}
