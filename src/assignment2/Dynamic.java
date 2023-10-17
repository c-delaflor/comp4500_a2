package assignment2;

import java.util.*;

public class Dynamic {

    /**
     * @require The array of passengers is not null and does not contain null values.
     *
     *          The list of passengers is ordered in non-decreasing order of their arrival
     *          time at the ferry terminal. (More than one passenger can arrive at the
     *          same time.)
     * 
     * @ensure Returns the minimum total frustration of the passengers.
     * 
     *         (See handout for details.)
     * 
     *         This method should not modify its inputs in any way.
     * 
     *         This method must be implemented using an efficient bottom-up dynamic
     *         programming solution to the problem (not memoised).
     */
    public static int optimalDynamic(ArrayList<Passenger> passengers) {
        return Integer.MIN_VALUE; // REMOVE THIS LINE AND IMPLEMENT THIS METHOD
    }

    /**
     * @require The array of passengers is not null and does not contain null values.
     *
     *          The list of passengers is ordered in non-decreasing order of their arrival
     *          time at the ferry terminal. (More than one passenger can arrive at the
     *          same time.)
     * 
     * @ensure Returns a (valid) plan that minimises the total frustration of the
     *         passengers.
     * 
     *         The plan should be represented as a non-null array list of Integers of the
     *         same length as the list of passengers, so that for 0 <= i <
     *         passengers.size(), plan.get(i) should be null if passengers.get(i)'s ticket
     *         is going to be cancelled, and it should otherwise be a (non-null) Integer
     *         representing the time that passenger.get(i) is planned to commence
     *         check-in.
     * 
     *         (See handout for details.)
     * 
     *         This method should not modify its inputs in any way.
     * 
     *         This method must be implemented using an efficient bottom-up dynamic
     *         programming solution to the problem (not memoised).
     */
    public static ArrayList<Integer> optimalSolutionDynamic(ArrayList<Passenger> passengers) {
        return null; // REMOVE THIS LINE AND IMPLEMENT THIS METHOD
    }

}
