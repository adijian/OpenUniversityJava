package Maman012;

public class Time1 {

    // Instance variables:
    final int MINUTE = 60;
    final int HOUR = 24;

    private int _hour; // Represents the hour between 23 and 0
    private int _minute; // Represents the minute between 59 and 0

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

    public Time1 (Time1 other) {
        // Retrieves another time and copies its values
        this._hour = other.getHour();
        this._minute = other.getMinute();
    }

    // Getter functions
    public int getHour() {
        return this._hour;
    }

    public int getMinute() {
        return this._minute;
    }

    // Setter functions
    public void setHour(int num) {
        // If num is out of the 0-23 bounds, the original value is unchanged
        if (num < HOUR && num >= 0) {
            this._hour = num;
        }
    }

    public void setMinute(int num) {
        // If num is out of the 0-23 bounds, the original value is unchanged
        if (num < MINUTE && num >= 0) {
            this._minute = num;
        }
    }

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

    public int minFromMidnight() {
        // Retrieves the number of minutes since midnight by converting the number of hours to minutes and adding the minutes
        return ((this._hour * 60) + this._minute);
    }

    public boolean equals (Time1 other) {
        // If the hours and minutes are equal to the input object's hours and minutes, return true
        return other._minute == this._minute && other._hour == this._hour;
    }

    public boolean before (Time1 other) {
        // If the time entered was before the current object's time
        if (this._hour < other._hour) {
            return true;
        }
        else return other._hour == this._hour && this._minute < other._minute;
    }

    public boolean after (Time1 other) {
        // If the time entered was after the current object's time
        return !this.before(other);
    }

    public int difference (Time1 other) {
        // Return the difference in minutes between two of the objects (the times are in the same day and the object's time is later than the other object's time)
        return (this._hour - other._hour) * 60 + (this._minute - other._minute);
    }

    public Time1 addMinutes (int num) {
        // Adds the number of minutes (num) to the current time (which is unchanged), represented by a new time object
        // If num is negative, subtract the minutes
        // if the time goes back a day it needs to be a valid input as stated before
        int tempHour = ((num / 60) + this.getHour()) % 24;
        int tempMinute = ((num % 60) + this.getMinute()) % 60;

        // If the number is negative, the format has to stay within time bounds
        if (tempHour < 0) {
            tempHour += 24;
        }

        if (tempMinute < 0) {
            tempMinute += 60;
            tempHour--;

            if (tempHour == 0) {
                tempHour = 23;
            }
        }

        // New object
        return new Time1(tempHour, tempMinute);
    }
}
