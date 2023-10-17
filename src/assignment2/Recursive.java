package assignment2;

import java.util.*;

public class Recursive {

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
     *         This method must be implemented using a recursive programming solution to
     *         the problem. It is expected that your recursive algorithm will not be
     *         polynomial-time in the worst case. (You must NOT provide a dynamic
     *         programming solution to this question.)
     */
    public static int optimalRecursive(ArrayList<Passenger> passengers) {
        return recursiveFrustration(passengers, 0, 0);
    }

    private static int recursiveFrustration(ArrayList<Passenger> passengers, int currentIndex, int checkInEndTime) {
        if (currentIndex >= passengers.size()) {
            return 0;
        }
        // Get Current Passenger
        Passenger currentPassenger = passengers.get(currentIndex);

        // Decision: Cancel the ticket of current passenger.
        int cancelFrustration = currentPassenger.cancelFrustration() +
                recursiveFrustration(passengers, currentIndex + 1, checkInEndTime);

        int startTime = Math.max(currentPassenger.arrival(), checkInEndTime);

        // If it's possible to check-in the passenger before their departure
        if (startTime + currentPassenger.checkInTime() <= currentPassenger.departure()) {
            // Decision: Check-in the current passenger
            int checkInFrustration = currentPassenger.waitFrustration(startTime - currentPassenger.arrival()) +
                    recursiveFrustration(passengers, currentIndex + 1, startTime + currentPassenger.checkInTime());
            return Math.min(cancelFrustration, checkInFrustration);
        } else { // Can't check-in, only option is to cancel.
            return cancelFrustration;
        }
    }
}
