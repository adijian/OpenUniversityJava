package Maman013;

import Maman012.Flight;
import Maman012.Time1;

import java.util.ArrayList;
import java.util.Arrays;

public class Airport {
    Flight[] _flightsSchedule;
    int _noOfFlights;
    String _city;
    final int MAX_FLIGHTS = 200;

    Airport(String city) {
        this._city = city;
        this._flightsSchedule = new Flight[200];
        this._noOfFlights = 0;
    }

    boolean addFlight(Flight flight) {
        // Adds a flight to the flight board
        if (flight.get_origin().equals(this._city) || flight.get_destination().equals(this._city)) {
            this._flightsSchedule[_noOfFlights] = flight;
            this._noOfFlights++;
            return true;
        } else {
            return false;
        }
    }

    boolean removeFlight(Flight flight) {
        // Remove sa flight from the flight board
        for (int i = 0; i < this._flightsSchedule.length; i++) {
            if (this._flightsSchedule[i] == flight) {
                this._flightsSchedule[i] = null;
                this._noOfFlights--;
                return true;
            }
        }
        return false;
    }

    Time1 firstFlightFromOrigin(String place) {
        for (int i = 0; i < this._flightsSchedule.length; i++) {
            if (this._flightsSchedule[i].get_origin().equals(place)) {
                return this._flightsSchedule[i].get_departure();
            }
        }
        return null;
    }

    int howManyFullFlights() {
        int fullFlights = 0;
        for (int i = 0; i < this._flightsSchedule.length; i++) {
            if (this._flightsSchedule[i].isFull()) {
                fullFlights++;
            }
        }
        return fullFlights;
    }

    int howManyFlightsBetween(String place) {
        int flightsBetween = 0;
        for (int i = 0; i < this._flightsSchedule.length; i++) {
            if (this._flightsSchedule[i].get_origin().equals(place) || this._flightsSchedule[i].get_destination().equals(place)) {
                flightsBetween++;
            }
        }
        return flightsBetween;
    }

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
                        if (this._flightsSchedule[j].get_destination().equals(this._flightsSchedule[i].get_destination())) {
                            count++;
                        }
                        if (count >= maxCount) {
                            similarDestination = this._flightsSchedule[i].get_destination();
                            maxCount = count;
                        }
                    }
                }
            }
        }

        return similarDestination;
    }

    Flight mostExpensiveTicket() {
        int mostExpensiveFlight = 0;

        if (this._flightsSchedule[0] == null) {
            return null;
        }

        for (int i = 1; i < this._flightsSchedule.length; i++) {
            if (this._flightsSchedule[i] != null &&
                this._flightsSchedule[i].get_price() > this._flightsSchedule[i - 1].get_price() &&
                this._flightsSchedule[i].get_price() > this._flightsSchedule[mostExpensiveFlight].get_price()) {
                    mostExpensiveFlight = i;
            }
        }

        return this._flightsSchedule[mostExpensiveFlight];
    }

    Flight longestFlight() {
        int longestFlightDuration = 0;

        if (this._flightsSchedule[0] == null) {
            return null;
        }

        for (int i = 1; i < this._flightsSchedule.length; i++) {
            if (this._flightsSchedule[i] != null &&
                this._flightsSchedule[i].get_flightDuration() > this._flightsSchedule[i - 1].get_flightDuration() &&
                this._flightsSchedule[i].get_flightDuration() > this._flightsSchedule[longestFlightDuration].get_flightDuration()) {
                longestFlightDuration = i;
            }
        }

        return this._flightsSchedule[longestFlightDuration];
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("The flights for airport " + this._city + " today are:");
        for(int i = 0; i < this._flightsSchedule.length; i++) {
            if (this._flightsSchedule[i] != null) {
                stringBuilder.append("\n").append(this._flightsSchedule[i].toString());
            }
        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Airport airport = new Airport("Israel");
        Flight flight = new Flight("Israel", "UK", 0, 0, 10, 10, 550);
        Flight flight1 = new Flight("Israel", "UK", 1, 0, 10, 10, 20);
        Flight flight2 = new Flight("Israel", "US", 2, 0, 50, 10, 400);
        Flight flight3 = new Flight("Israel", "Honolulu", 3, 0, 500, 10, 200);
        Flight flight4 = new Flight("Israel", "US", 4, 0, 500, 10, 300);
        Flight flight5 = new Flight("Israel", "Japan", 5, 0, 1, 10, 400);
        System.out.println(airport.addFlight(flight));
        System.out.println(airport.addFlight(flight1));
        System.out.println(airport.addFlight(flight2));
        System.out.println(airport.addFlight(flight3));
        System.out.println(airport.addFlight(flight4));
        System.out.println(airport.addFlight(flight5));
        System.out.println(airport._noOfFlights);

//        System.out.println(airport.longestFlight());
        System.out.println(airport);
    }
}
