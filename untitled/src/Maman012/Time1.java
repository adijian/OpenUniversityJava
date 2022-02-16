package Maman012;

public class Time1 {

    // Instance variables:
    private int _hour; // Represents the hour between 23 and 0
    private int _minute; // Represents the minute between 59 and 0

    // Two constructors
    public Time1 (int h, int m) {
        // Resets the values to 0 if one of them is incorrect

        if(h < 23 && h > 0) {
            this._hour = h;
        }

        if(m < 59 && m > 0) {
            this._minute = m;
        }
    }

    public Time1 (Time1 other) {
        // Retrieves another time and copies its values
        this._hour = other._hour;
        this._minute = other._minute;
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
        if (num < 23 && num > 0) {
            this._hour = num;
        }
    }

    public void setMinute(int num) {
        // If num is out of the 0-23 bounds, the original value is unchanged
        if (num < 59 && num > 0) {
            this._hour = num;
        }
    }

    public String toString() {
        // Return the time in a digital clock convention (hh:mm) such as 07:30
        String _hour_temp = String.valueOf(this._hour);
        String _minute_temp = String.valueOf(this._minute);

        // In case the hour/minute numbers are smaller than 10, a 0 has to be placed before the numbers
        if(this._hour < 10) {
            _hour_temp = "0" + _hour_temp;
            if (this._minute < 10) {
                _minute_temp = "0" + _minute_temp;
                return _hour_temp + ":" + _minute_temp;
            }
        }
        return _hour_temp + ":" + _minute_temp;
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
        int new_object_hour = (num + this._hour) / 60;
        int new_object_minute = (num + this._minute) % 60;

        // If the number is negative, the format has to stay within time bounds
        if (new_object_hour < 0) {
            new_object_hour = 24 + new_object_hour;
        }

        if (new_object_minute < 0) {
            new_object_minute = 60 + new_object_minute;
            new_object_hour--;
        }

        // New object
        return new Time1(new_object_hour, new_object_minute);
    }

    public static void main(String[] args) {
        Time1 time = new Time1(9,45);
        Time1 time2 = new Time1(1,0);
        System.out.println(time2.addMinutes(-(122)));

    }
}
