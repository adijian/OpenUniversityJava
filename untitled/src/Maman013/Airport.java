package Maman013;

/**
 * Creates an airport object which has a schedule of flights. Allows adding/removing flights and provides data about the available flights.
 * @author Adi Jian
 * @version
 */

public class Airport {
    Flight[] _flightsSchedule;
    int _noOfFlights;
    String _city;
    final int MAX_FLIGHTS = 200;

    /**
     * Creates an airport which is placed in a city
     * @param city The city which the airport is located at
     */
    Airport(String city) {
        this._city = city;
        this._flightsSchedule = new Flight[MAX_FLIGHTS];
        this._noOfFlights = 0;
    }

    /**
     * Adds a flight to the schedule
     * @param f Flight to be added to the schedule
     * @return If flight was added or not
     */
    boolean addFlight(Flight f) {
        if (f.getOrigin().equals(this._city) || f.getDestination().equals(this._city)) {
            this._flightsSchedule[_noOfFlights] = f;
            this._noOfFlights++;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Removes a flight from the schedule
     * @param f Flight to be removed from the schedule
     * @return If flight was removed or not
     */
    boolean removeFlight(Flight f) {
        // Remove sa flight from the flight board
        for (int i = 0; i < this._flightsSchedule.length; i++) {
            if (this._flightsSchedule[i] == f) {
                this._noOfFlights--;
                this._flightsSchedule[i] = null;
                // Change the index of the other flights
                for(int j = i + 1; j < this._flightsSchedule.length; j++) {
                    if(this._flightsSchedule[j] != null) {
                        this._flightsSchedule[j - 1] = this._flightsSchedule[j];
                        this._flightsSchedule[j] = null;
                    }
                }
                return true;
            }
        }
        return false;
    }

    /**
     * Returns the first flight from given origin
     * @param place The origin of the flight
     * @return The earliest flight from given place or null if not found
     */
    Time1 firstFlightFromOrigin(String place) {
        Flight firstFlight = null;
        for (int i = 0; i < this._noOfFlights; i++) {
            if (this._flightsSchedule[i].getOrigin().equals(place)) {
                if (firstFlight == null) {
                    firstFlight = this._flightsSchedule[i];
                }
                else if (this._flightsSchedule[i].getDeparture().before(firstFlight.getDeparture())) {
                    firstFlight = this._flightsSchedule[i];
                }
            }
        }
        if (firstFlight != null) {
            return firstFlight.getDeparture();
        } else return null;
    }

    /**
     * Returns the number of full flights in schedule
     * @return Number of full flights
     */
    int howManyFullFlights() {
        int fullFlights = 0;
        for (int i = 0; i < this._flightsSchedule.length; i++) {
            if (this._flightsSchedule[i] != null && this._flightsSchedule[i].getIsFull()) {
                fullFlights++;
            }
        }
        return fullFlights;
    }

    /**
     * Counts the number of flights between a destination and the airport
     * @param city The destination of flights
     * @return The number of flights between the city and the airport
     */
    int howManyFlightsBetween(String city) {
        int flightsBetween = 0;
        for (int i = 0; i < this._flightsSchedule.length; i++) {
            if (this._flightsSchedule[i] != null && (this._flightsSchedule[i].getOrigin().equals(city) || this._flightsSchedule[i].getDestination().equals(city))) {
                flightsBetween++;
            }
        }
        return flightsBetween;
    }

    /**
     * Returns the most popular destination in the schedule
     * @return The most popular destination or null if no flights are in the schedule
     */
    String mostPopularDestination() {
        if (this._flightsSchedule[0] == null) {
            return null;
        }

        String similarDestination = "";
        int maxCount = 0;

        for (int i = 0; i < this._flightsSchedule.length; i++) {
            if (this._flightsSchedule[i] != null) {
                int count = 1;
                for (int j = i + 1; j < this._flightsSchedule.length; j++) {
                    if (this._flightsSchedule[j] != null) {
                        if (this._flightsSchedule[j].getDestination().equals(this._flightsSchedule[i].getDestination())) {
                            count++;
                        }
                        if (count > maxCount) {
                            similarDestination = this._flightsSchedule[i].getDestination();
                            maxCount = count;
                        }
                    }
                }
            }
        }

        return similarDestination;
    }

    /**
     * Returns the most expensive flight ticket in the schedule
     * @return The most expensive flight ticket or null if no flights are in the schedule
     */
    Flight mostExpensiveTicket() {
        if (this._flightsSchedule[0] == null) {
            return null;
        }

        int mostExpensiveFlight = 0;

        for (int i = 1; i < this._flightsSchedule.length; i++) {
            if (this._flightsSchedule[i] != null &&
                this._flightsSchedule[i].getPrice() > this._flightsSchedule[i - 1].getPrice() &&
                this._flightsSchedule[i].getPrice() > this._flightsSchedule[mostExpensiveFlight].getPrice()) {
                    mostExpensiveFlight = i;
            }
        }

        return this._flightsSchedule[mostExpensiveFlight];
    }

    /**
     * Returns the longest flight in the schedule
     * @return The longest flight or null if no flights are in the schedule
     */
    Flight longestFlight() {
        if (this._flightsSchedule[0] == null) {
            return null;
        }

        int longestFlightDuration = 0;

        for (int i = 1; i < this._flightsSchedule.length; i++) {
            if (this._flightsSchedule[i] != null &&
                this._flightsSchedule[i].getFlightDuration() > this._flightsSchedule[i - 1].getFlightDuration() &&
                this._flightsSchedule[i].getFlightDuration() > this._flightsSchedule[longestFlightDuration].getFlightDuration()) {
                longestFlightDuration = i;
            }
        }

        return this._flightsSchedule[longestFlightDuration];
    }

    /**
     * Returns a text which includes all the flights in the schedule
     * @return The definition of all flights in the schedule or null if the schedule is empty
     */
    @Override
    public String toString() {
        if (this._flightsSchedule[0] == null) {
            return null;
        }

        String string = "The flights for airport " + this._city + " today are:  \n";

        for(int i = 0; i < this._flightsSchedule.length; i++) {
            if (this._flightsSchedule[i] != null) {
                string = string + this._flightsSchedule[i].toString() + "  \n";
            }
        }

        return string;
    }
}
