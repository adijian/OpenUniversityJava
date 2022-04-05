package Maman012;

/**
 * Represents a flight. A Flight object is represented by the flight's origin,destination,departure time, flight duration, no of passengers,if it is full and the price.
 * @author Adi Jian
 * @version 4/5/2022
 */

public class Flight {
//    Instance Variables:
    private String _origin; // City the flight comes from (beginning)
    private String _destination; // City the flight goes to (end)
    private Time1 _departure; // Time of take off
    private int _flightDuration; // The duration of the flight in minutes
    private int _noOfPassengers;
    private boolean _isFull;
    private int _price; // Flight cost per person
    private final int MAX_CAPACITY = 250;

    /**
     * Constructor for a Flight object. If the number of passengers exceeds the maximum capacity the number of passengers will be set to the maxmum capacity If the number of passengers is negative the number of passengers will be set to zero. If the flight duration is negative the flight duration will be set to zero. If the price is negative the price will be set to zero.
     * @param origin The city the flight leaves from.
     * @param destination The city the flight lands at.
     * @param depHour the departure hour (should be between 0-23).
     * @param depMinute The departure minute (should be between 0-59).
     * @param durTimeMinutes The duration time in minutes(should not be negative).
     * @param noOfPass The number of passengers (should be between 0-maximum capacity).
     * @param price The price (should not be negative).
     */
    public Flight(String origin, String destination, int depHour, int depMinute, int durTimeMinutes, int noOfPass, int price) {
        //if number of passengers is higher than max capacity, the var of number of passengers is the max capacity
        if (noOfPass > MAX_CAPACITY) {
            this._noOfPassengers = MAX_CAPACITY;
        }

        if (noOfPass < 0) {
            this._noOfPassengers = 0;
        }
        else this._noOfPassengers = Math.min(noOfPass, MAX_CAPACITY);

        this._isFull = (noOfPass == MAX_CAPACITY);

        // If the duration of the flight is smaller than 0 then the flight duration is 0
        this._flightDuration = Math.max(durTimeMinutes, 0);

        // If the price of the flight is smaller than 0 then the flight duration is 0
        this._price = Math.max(price, 0);

        this._departure = new Time1(depHour, depMinute);
        this._origin = origin;
        this._destination = destination;
    }

    /**
     * Copy constructor for a Flight object. Construct a Flight object with the same attributes as another Flight object.
     * @param other The Flight object from which to construct the new Flight.
     */
    Flight (Flight other) {
        this(other.getOrigin(),
            other.getDestination(),
            other._departure.getHour(),
            other._departure.getMinute(),
            other.getFlightDuration(),
            other.getNoOfPassengers(),
            other.getPrice());
    }

    /**
     * Changes the flight's origin.
     * @param origin The flight's new origin.
     */
    public void setOrigin(String origin) {
        this._origin = origin;
    }

    /**
     * Changes the flight's destination.
     * @param dest The flight's new destination.
     */
    public void setDestination(String dest) {
        this._destination = dest;
    }

    /**
     * Changes the flight's departure time.
     * @param departureTime The flight's new departure time.
     */
    public void setDeparture(Time1 departureTime) {
        this._departure = new Time1(departureTime);
    }

    /**
     * Changes the flight's duration time. If the parameter is negative the duration time will remain unchanged.
     * @param durTimeMinutes The flight's new duration time.
     */
    public void setFlightDuration(int durTimeMinutes) {

        this._flightDuration = Math.max(durTimeMinutes, 0);
    }

    /**
     * Changes the number of passengers. If the parameter is negative or larger than the maximum capacity the number of passengers will remain unchanged.
     * @param noOfPass The new number of passengers.
     */
    public void setNoOfPassengers(int noOfPass) {
        if (noOfPass >= 0 && noOfPass <= MAX_CAPACITY) {
            this._noOfPassengers = noOfPass;
        }
    }

    /**
     * Changes the flight price. If the parameter is negative the price will remain unchanged.
     * @param price The new price.
     */
    public void setPrice(int price) {
        this._price = Math.max(price, 0);
    }

    /**
     * Returns the flight origin.
     * @return The flight origin.
     */
    public String getOrigin() {
        return this._origin;
    }

    /**
     * Returns the flight destination.
     * @return The flight destination.
     */
    public String getDestination() {
        return this._destination;
    }

    /**
     * Returns the flight departure time.
     * @return A copy of the flight departure time.
     */
    public Time1 getDeparture() {
        return this._departure;
    }

    /**
     * Returns the flight duration time in minutes.
     * @return The flight duration.
     */
    public int getFlightDuration() {
        return this._flightDuration;
    }

    /**
     * Returns the number of passengers on the flight.
     * @return The number of passengers.
     */
    public int getNoOfPassengers() {
        return this._noOfPassengers;
    }

    /**
     * Returns whether the flight is full or not.
     * @return True if the flight is full.
     */
    public boolean getIsFull() {
        this._isFull = (this._noOfPassengers == MAX_CAPACITY);
        return this._isFull;
    }

    /**
     * Returns the price of the flight .
     * @return The price.
     */
    public int getPrice() {
        return this._price;
    }

    /**
     * Check if the received flight is equal to this flight. Flights are considered equal if the origin, destination and departure times are the same.
     * @param other The flight to be compared with this flight.
     * @return True if the received flight is equal to this flight.
     */
    boolean equals(Flight other) {
        return this._origin.equals(other._origin) && this._destination.equals(other._destination) && this._departure.equals(other._departure);
    }

    /**
     * Returns the arrival time of the flight .
     * @return The arrival time of this flight.
     */
    Time1 getArrivalTime() {
        return this._departure.addMinutes(this._flightDuration);
    }

    /**
     * Add passengers to this flight. If the number of passengers exceeds he maximum capacity, no passengers are added and alse is returned. If the flight becomes full, the boolean attribute describing whether the flight if full becomes true.
     * @param num The number of passengers to be added to this flight.
     * @return True if the passengers were added to the flight.
     */
    boolean addPassengers(int num) {
        if ((this.getNoOfPassengers() + num) < MAX_CAPACITY) {
            this._noOfPassengers += num;
            return true;
        } else if ((this.getNoOfPassengers() + num) > MAX_CAPACITY) {
            return false;
        } else if ((this.getNoOfPassengers() + num) == MAX_CAPACITY) {
            this._isFull = true;
            this._noOfPassengers += num;
            return true;
        }
        return true;
    }

    /**
     * Check if this flight is cheaper than another flight.
     * @param other The flight whose price is to be compared with this flight's price.
     * @return True if this flight is cheaper than the received flight .
     */
    boolean isCheaper(Flight other) {
        return this._price < other.getPrice();
    }

    /**
     * Calculate the total price of the flight.
     * @return The total price of the flight.
     */
    int totalPrice() {
        return this._noOfPassengers * this._price;
    }

    /**
     * Check if this flight lands before another flight. Note - the flights may land on different days, the method checks which flight lands first.
     * @param other The flight whose arrival time to be compared with this flight's arrival time.
     * @return True if this flight arrives before the received flight.
     */
    boolean landsEarlier(Flight other) {
        return this.getArrivalTime().before(other.getArrivalTime());
    }

    /**
     * Return a string representation of this flight (for example: "Flight from London to Paris departs at 09:24.Flight is full.").
     * @return String representation of this flight (for example: "Flight from London to Paris departs at 09:24.Flight is full.").
     */
    @Override
    public String toString() {
        if (this._isFull) {
            return "Flight from " +  this._origin + " to " + this._destination + " departs at " + this._departure + ". Flight is full.";
        } else {
            return "Flight from " +  this._origin + " to " + this._destination + " departs at " + this._departure + ". Flight is not full.";
        }
    }
}
