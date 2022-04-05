package Maman012;

/**
 * Represents time - hours:minutes. Values must represent a proper time.
 * @author Adi Jian
 * @version 5/4/2022
 */

public class Time2 {
    // Instance variable:
    private int _minuteFromMid;

    /**
     * Constructs a Time2 object. Construct a new time instance with the specified hour and minute . hour should be between 0-23, otherwise it should be set to 0. minute should be between 0-59, otherwise they should be set to 0.
     * @param h hour
     * @param m minute
     */
    Time2 (int h, int m) {
        // Resets the values to 0 if one of them is incorrect
        if(h > 23 || h < 0) {
            h = 0;
        }

        if(m > 59 || m < 0) {
            m = 0;
        }

        this._minuteFromMid = h * 60 + m;
    }

    /**
     * Copy constructor for Time2. Constructs a time with the same variables as another time.
     * @param other The time object from which to construct the new time
     */

    Time2 (Time2 other) {
        this._minuteFromMid = other.getHour() * 60 + other.getMinute();
    }

    /**
     * Returns the hour of the time.
     * @return The hour of the time
     */
    // Getter functions
    int getHour() {
        return this._minuteFromMid / 60;
    }

    /**
     * Returns the minute of the time.
     * @return The minute of the time
     */
    int getMinute() {
        return this._minuteFromMid % 60;
    }

    /**
     * Changes the hour of the time. If an illegal number is received hour will remain unchanged.
     * @param num The new hour
     */
    // Setter functions
    void setHour(int num) {
        // If num is out of the 0-23 bounds, the original value is unchanged
        if (num < 24 && num >= 0) {
            this._minuteFromMid = this.getMinute() + (num * 60);
        }
    }

    /**
     * Changes the minute of the time. If an illegal number is received minute will remain unchanged.
     * @param num The new minute
     */
    void setMinute(int num) {
        // If num is out of the 0-59 bounds, the original value is unchanged
        if (num < 60 && num >= 0) {
            this._minuteFromMid = (this.getHour() * 60) + num;
        }
    }

    /**
     * Return the amount of minutes since midnight.
     * @return amount of minutes since midnight.
     */
    int minFromMidnight() {
        // Retrieves the number of minutes since midnight by converting the number of hours to minutes and adding the minutes
        return this._minuteFromMid;
    }

    /**
     * Checks if the received time is equal to this time.
     * @param other The time to be compared with this time
     * @return True if the received time is equal to this time
     */
    boolean equals (Time2 other) {
        // If the hours and minutes are equal to the input object's hours and minutes, return true
        return this._minuteFromMid == other._minuteFromMid;
    }

    /**
     * Checks if this time is before a received time.
     * @param other The time to check if this time is before
     * @return True if this time is before other time
     */
    boolean before (Time2 other) {
        // If the time entered was before the current object's time
        return this._minuteFromMid < other._minuteFromMid;
    }

    /**
     * Checks if this time is after a received time.
     * @param other The time to check if this time is after
     * @return True if this time is after other time
     */
    boolean after (Time2 other) {
        // If the time entered was after the current object's time
        return !this.before(other);
    }

    /**
     * Calculates the difference (in minutess) between two times.
     * @param other The time to check the difference with. Assumption: this time is after other time
     * @return int difference in minutes
     */
    int difference (Time2 other) {
        // Return the difference in minutes between two of the objects (the times are in the same day and the object's time is later than the other object's time)
        return this._minuteFromMid - other._minuteFromMid;
    }

    /**
     * Returns a string representation of this time(hh:mm).
     * @return String representation of this time(hh:mm).
     */

    @Override
    public String toString() {
        int tempHours = this._minuteFromMid / 60;
        int tempMinutes = this._minuteFromMid % 60;
        String hours = String.valueOf(tempHours);
        String minutes = String.valueOf(tempMinutes);

        // If the numbers are too short, add 0 to the number
        if (tempHours < 10) {
            hours = "0" + hours;
        }

        if(tempMinutes < 10) {
            minutes = "0" + minutes;
        }

        return hours + ":" + minutes;
    }

    /**
     * Copy current object and add requested minutes to new object.
     * @param num The minutes need to add.
     * @return new update Time2 object.
     */
    Time2 addMinutes(int num) {
        int tempNum = this._minuteFromMid + num;
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


        return new Time2(tempHours, tempMinutes);
    }
}
