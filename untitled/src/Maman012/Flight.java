package Maman012;

import java.util.Objects;

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

    Flight(String origin, String destination, int departureHours, int departureMinutes, int flightDuration, int noOfPassengers, int price) {
        //if number of passengers is higher than max capacity, the var of number of passengers is the max capacity
        if (noOfPassengers < MAX_CAPACITY) {
            this._noOfPassengers = MAX_CAPACITY;
        }

        if (noOfPassengers < 0) {
            this._noOfPassengers = 0;
        }

        this._isFull = (noOfPassengers == MAX_CAPACITY);

        // If the duration of the flight is smaller than 0 then the flight duration is 0
        if (flightDuration < 0) {
            this._flightDuration = 0;
        }

        // If the price of the flight is smaller than 0 then the flight duration is 0
        if (price < 0) {
            this._price = 0;
        }

        _departure = new Time1(departureHours, departureMinutes);
    }

    Flight (Flight other) {
        this._origin = other._origin;
        this._destination = other._destination;
        this._departure = other._departure;
        this._flightDuration = other._flightDuration;
        this._noOfPassengers = other._noOfPassengers;
        this._isFull = other._isFull;
        this._price = other._price;
    }

    public String get_origin() {
        return _origin;
    }

    public String get_destination() {
        return _destination;
    }

    public Time1 get_departure() {
        return _departure;
    }

    public int get_flightDuration() {
        return _flightDuration;
    }

    public int get_noOfPassengers() {
        return _noOfPassengers;
    }

    public boolean is_isFull() {
        return _isFull;
    }

    public int get_price() {
        return _price;
    }

    public int getMAX_CAPACITY() {
        return MAX_CAPACITY;
    }

    public void set_origin(String _origin) {
        this._origin = _origin;
    }

    public void set_destination(String _destination) {
        this._destination = _destination;
    }

    public void set_departure(Time1 _departure) {
        this._departure = _departure;
    }

    public void set_flightDuration(int _flightDuration) {
        this._flightDuration = _flightDuration;
    }

    public void set_noOfPassengers(int _noOfPassengers) {
        this._noOfPassengers = _noOfPassengers;
    }

    public void set_isFull(boolean _isFull) {
        this._isFull = _isFull;
    }

    public void set_price(int _price) {
        this._price = _price;
    }

    boolean equals(Flight other) {
        return this._origin.equals(other._origin) && this._destination.equals(other._destination) && this._departure.equals(other._departure);
    }

    Time1 getArrivalTime() {
        return this._departure.addMinutes(this._flightDuration);
    }

    boolean addPassengers(int num) {
        if ((this._noOfPassengers += num) < MAX_CAPACITY) {
            this._noOfPassengers += num;
            if ((this._noOfPassengers += num) == MAX_CAPACITY) {
                this._isFull = true;
            }
            return true;
        } else {
            return false;
        }
    }

    boolean isCheaper(Flight other) {
        return this._price < other._price;
    }

    int totalPrice() {
        return this._noOfPassengers * this._price;
    }

    boolean landsEarlier(Flight other) {
        return this.getArrivalTime().before(other.getArrivalTime());
    }

    public String toString() {
        if (this._isFull) {
            return "Flight from" +  this._origin + " to" + this._destination + " departs at " + this._departure + ". Flight is full.";
        } else {
            return "Flight from" +  this._origin + " to" + this._destination + " departs at " + this._departure + ". Flight is not full.";
        }
    }
}
