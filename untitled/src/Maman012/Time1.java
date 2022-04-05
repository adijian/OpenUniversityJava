package Maman012;

/**
 * Represents time - hours:minutes. Coordinates cannot be negative.
 * @author Adi Jian
 * @version 5/4/2022
 */
public class Time1 {

    // Instance variables:
    final int MINUTE = 60;
    final int HOUR = 24;

    private int _hour; // Represents the hour between 23 and 0
    private int _minute; // Represents the minute between 59 and 0

    /**
     * Constructs a Time1 object.
     * @param h the hour of the time
     * @param m the minute of the time
     */
    // Two constructors
    public Time1 (int h, int m) {
        // Resets the values to 0 if one of them is incorrect

        if(h < MINUTE && h > 0) {
            this._hour = h;
        } else {
            this._hour = 0;
        }

        if(m < MINUTE && m > 0) {
            this._minute = m;
        } else {
            this._minute = 0;
        }
    }

    /**
     * Copy constructor for Time1. Construct a time with the same instance variables as another time.
     * @param other The time object from which to construct the new time
     */
    public Time1 (Time1 other) {
        // Retrieves another time and copies its values
        this._hour = other.getHour();
        this._minute = other.getMinute();
    }

    /**
     * Returns the hour of the time.
     * @return The hour of the time
     */
    // Getter functions
    public int getHour() {
        return this._hour;
    }

    /**
     * Returns the minute of the time.
     * @return The minute of the time
     */
    public int getMinute() {
        return this._minute;
    }

    /**
     * Changes the hour of the time. If an illegal number is received hour will be unchanged.
     * @param num The new hour
     */
    // Setter functions
    public void setHour(int num) {
        // If num is out of the 0-23 bounds, the original value is unchanged
        if (num < HOUR && num >= 0) {
            this._hour = num;
        }
    }

    /**
     * Changes the minute of the time. If an illegal number is received minute will be unchanged.
     * @param num The new minute
     */
    public void setMinute(int num) {
        // If num is out of the 0-23 bounds, the original value is unchanged
        if (num < MINUTE && num >= 0) {
            this._minute = num;
        }
    }

    /**
     * Return a string representation of this time (hh:mm).
     * @return String representation of this time (hh:mm).
     */
    @Override
    public String toString() {
        // Return the time in a digital clock convention (hh:mm) such as 07:30
        String tempHour = String.valueOf(this._hour);
        String tempMinute = String.valueOf(this._minute);

        // In case the hour/minute numbers are smaller than 10, a 0 has to be placed before the numbers
        if(this._hour < 10) {
            tempHour = "0" + tempHour;
        }

        if (this._minute < 10) {
            tempMinute = "0" + tempMinute;
        }

        return tempHour + ":" + tempMinute;
    }

    /**
     * Return the amount of minutes since midnight.
     * @return amount of minutes since midnight.
     */
    public int minFromMidnight() {
        // Retrieves the number of minutes since midnight by converting the number of hours to minutes and adding the minutes
        return ((this._hour * 60) + this._minute);
    }

    public boolean equals (Time1 other) {
        // If the hours and minutes are equal to the input object's hours and minutes, return true
        return other._minute == this._minute && other._hour == this._hour;
    }

    /**
     * Check if the received time is equal to this time.
     * @param other The time to be compared with this time
     * @return True if the received time is equal to this time
     */
    public boolean before (Time1 other) {
        // If the time entered was before the current object's time
        if (this._hour < other._hour) {
            return true;
        }
        else return other._hour == this._hour && this._minute < other._minute;
    }

    /**
     * Check if this time is after a received time.
     * @param other The time to check if this point is after
     * @return True if this time is after other time
     */
    public boolean after (Time1 other) {
        // If the time entered was after the current object's time
        return !this.before(other);
    }

    /**
     * Calculates the difference (in minutes) between two times. Assumption: this time is after other time.
     * @param other The time to check the difference to
     * @return int difference in minutes
     */
    public int difference (Time1 other) {
        // Return the difference in minutes between two of the objects (the times are in the same day and the object's time is later than the other object's time)
        return (this._hour - other._hour) * 60 + (this._minute - other._minute);
    }

    /**
     * Copy current object and add requested minutes to new object.
     * @param num The minutes need to add.
     * @return new update Time1 object.
     */
    public Time1 addMinutes (int num) {
        // Adds the number of minutes (num) to the current time (which is unchanged), represented by a new time object
        // If num is negative, subtract the minutes
        // if the time goes back a day it needs to be a valid input as stated before
        int tempNum = this.minFromMidnight() + num;
        int tempHours = (tempNum / 60) % 24;
        int tempMinutes = tempNum % 60;

        if (tempHours < 0) {
            tempHours += 24;
        }

        if (tempMinutes < 0) {
            tempMinutes += 60;
            tempHours--;

            if (tempHours == 0) {
                tempHours = 23;
            }
        }

        // New object
        return new Time1(tempHours, tempMinutes);
    }
}
