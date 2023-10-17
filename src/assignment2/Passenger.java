package assignment2;

import java.util.*;

/**
 * A class representing a passenger.
 * 
 * Each passenger has a time that they arrive at the ferry terminal, a time that their
 * ferry is scheduled to depart, as well as an amount of time that the passenger will
 * require with the attendant, in order to be able to check in.
 * 
 * Each passenger also has a measure of how frustrated they will become if their ticket is
 * cancelled, and for each delta such that (0 <= delta <= departure-arrival-checkInTime),
 * how frustrated the passenger will be if they commence check-in delta time units after
 * their arrival time.
 * 
 * DO NOT MODIFY THIS FILE IN ANY WAY.
 */
public final class Passenger {

    /* The time that the passenger arrives to check in. */
    private final int arrival;
    /* The time that the passenger's ferry departs. */
    private final int departure;
    /* The time that it takes for the attendant to check-in the passenger. */
    private final int checkInTime;
    /* How frustrated the passenger will be if their ticket is cancelled. */
    private final int cancelFrustration;
    /*
     * For each delta such that (0 <= delta <= departure-arrival-checkInTime), how
     * frustrated the passenger will be (waitFrustration[delta]) if they commence check-in
     * delta time units after their arrival time.
     */
    private final int[] waitFrustration;

    /*
     * Class invariant:
     * 
     * 0 <= arrival &&
     * 
     * 0 < checkInTime &&
     * 
     * arrival + checkInTime <= departure &&
     * 
     * waitFrustration != null &&
     * 
     * waitFrustration.length == (departure - arrival - checkInTime) + 1 &&
     * 
     * 0 <= waitFrustration[0] &&
     * 
     * for all i such that (1 <= i < waitFrustration.length), waitFrustration[i-1] <=
     * waitFrustration[i] &&
     * 
     * waitFrustration[waitFrustration.length - 1] < cancelFrustration
     */

    /**
     * Creates a new passenger with the given arrival, departure and check-in times, and
     * the measures of how frustrated the passenger will be if their ticket is cancelled
     * (cancelFrustration), and for each delta such that (0 <= delta <=
     * departure-arrival-checkInTime), how frustrated they will be if they commence
     * check-in delta time units after their arrival time (waitFrustration[delta]).
     * 
     * @require 0 <= arrival && 0 < checkInTime && arrival + checkInTime <= departure &&
     *           waitFrustration!=null && 
     *           waitFrustration.length == (departure - arrival - checkInTime) + 1 &&
     *           0 <= waitFrustration[0] &&
     *           (for all i such that 1 <= i < waitFrustration.length, 
     *               waitFrustration[i-1] <= waitFrustration[i]) &&
     *           waitFrustration[waitFrustration.length - 1] < cancelFrustration
     */
    public Passenger(int arrival, int departure, int checkInTime, int cancelFrustration,
            int[] waitFrustration) {

        if (arrival < 0) {
            throw new IllegalArgumentException("The arrival time must be non-negative.");
        }
        if (checkInTime <= 0) {
            throw new IllegalArgumentException(
                    "The check-in time must be greater than or equal to one.");
        }
        if (departure < arrival + checkInTime) {
            throw new IllegalArgumentException(
                    "The passenger must arrive no later than departure-checkInTime");
        }
        if (waitFrustration == null) {
            throw new IllegalArgumentException("Arguments cannot be null.");
        }
        if (waitFrustration.length != (departure - arrival - checkInTime) + 1) {
            throw new IllegalArgumentException(
                    "The frustration of the passenger must be specified for every "
                            + "delay from 0 to (departure-arrival-checkInTime), inclusive.");
        }
        if (waitFrustration[0] < 0) {
            throw new IllegalArgumentException(
                    "How frustrated someone can be has to be greater than or equal to zero.");
        }
        for (int i = 1; i < waitFrustration.length; i++) {
            if (waitFrustration[i - 1] > waitFrustration[i]) {
                throw new IllegalArgumentException(
                        "Shorter wait times can be no more frustrating than longer ones.");
            }
        }
        if (cancelFrustration <= waitFrustration[waitFrustration.length - 1]) {
            throw new IllegalArgumentException(
                    "The passenger must be more frustrated if they are cancelled, "
                            + "than if they are checked in on time for their ferry.");
        }

        this.arrival = arrival;
        this.departure = departure;
        this.checkInTime = checkInTime;
        this.cancelFrustration = cancelFrustration;
        this.waitFrustration = Arrays.copyOf(waitFrustration, waitFrustration.length);
    }

    /** Returns the time that the passenger arrives to check in. */
    public int arrival() {
        return arrival;
    }

    /** Returns the time that the passenger's ferry departs. */
    public int departure() {
        return departure;
    }

    /** Returns the time that it takes for the attendant to check-in the passenger. */
    public int checkInTime() {
        return checkInTime;
    }

    /**
     * Returns the maximum amount of time the passenger can wait (after they arrive) and
     * still have enough time to check in before the departure of their ferry.
     */
    public int maxWait() {
        return (departure - arrival - checkInTime);
    }

    /** Returns how frustrated the passenger will be if their ticket is cancelled. */
    public int cancelFrustration() {
        return cancelFrustration;
    }

    /**
     * Returns how frustrated the passenger will be if they commence check-in delta time
     * units after their arrival time, where 0 <= delta && delta <= maxWait().
     * 
     * (A passenger cannot commence check in later than this, or they will not be in time
     * to catch their ferry).
     * 
     * @require This method requires 0 <= delta && delta <= maxWait().
     */
    public int waitFrustration(int delta) {
        if (0 <= delta && delta < waitFrustration.length) {
            return waitFrustration[delta];
        } else {
            throw new IllegalArgumentException(
                    "We require 0 <= delta && delta <= departure - arrival - checkInTime.");
        }
    }

    @Override
    public String toString() {
        return "(arrival: " + arrival + ", departure=" + departure + ", checkInTime=" + checkInTime
                + ", cancelFrustration=" + cancelFrustration + ", waitFrustration="
                + Arrays.toString(waitFrustration) + ")";
    }

}
