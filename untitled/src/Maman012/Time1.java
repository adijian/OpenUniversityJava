package Maman012;

public class Time1 {

    // Instance variables:
    private int int_hour; // Represents the hour between 23 and 0
    private int int_minute; // Represents the minute between 59 and 0

    // Two constructors
    public Time1 (int h, int m) {
        // Resets the values to 0 if one of them is incorrect

        if(h > 23 || h < 0) {
            int_hour = 0;
        } else {
            this.int_hour = h;
        }

            if(m > 59 || m < 0) {
            this.int_minute = 0;
        } else {
            this.int_minute = m;
        }
    }

    public Time1 (Time1 other) {
        // Retrieves another time and copies its values
        this.int_hour = other.int_hour;
        this.int_minute = other.int_minute;
    }

    // Getter functions
    public int getHour() {
        return int_hour;
    }

    public int getMinute() {
        return int_minute;
    }

    // Setter functions
    public void setHour(int num) {
        // If num is out of the 0-23 bounds, the original value is unchanged
        if (num > 23 || num < 0) {
            // Do nothing
        } else {
            int_hour = num;
        }
    }

    public void setMinute(int num) {
        // If num is out of the 0-23 bounds, the original value is unchanged
        if (num > 59 || num < 0) {
            // Do nothing
        } else {
            int_hour = num;
        }
    }

    public String toString() {
        // Return the time in a digital clock convention (hh:mm) such as 07:30
        String int_hour_temp = String.valueOf(int_hour);
        String int_minute_temp = String.valueOf(int_minute);

        // In case the hour/minute numbers are smaller than 10, a 0 has to be placed before the numbers
        if(int_hour < 10) {
            int_hour_temp = "0" + int_hour_temp;
            if (int_minute < 10) {
                int_minute_temp = "0" + int_minute_temp;
                return int_hour_temp + ":" + int_minute_temp;
            }
        }
        return int_hour_temp + ":" + int_minute_temp;
    }

    public int minFromMidnight() {
        // Retrieves the number of minutes since midnight by converting the number of hours to minutes and adding the minutes
        return ((int_hour * 60) + int_minute);
    }

    public boolean equals (Time1 other) {
        // If the hours and minutes are equal to the input object's hours and minutes, return true
        return other.int_minute == int_minute && other.int_hour == int_hour;
    }

    public boolean before (Time1 other) {
        // If the time entered was before the current object's time
        if (this.int_hour < other.int_hour) {
            return true;
        }
        else return other.int_hour == this.int_hour && this.int_minute < other.int_minute;
    }

    public boolean after (Time1 other) {
        // If the time entered was after the current object's time
        return !this.before(other);
    }

    public int difference (Time1 other) {
        // Return the difference in minutes between two of the objects (the times are in the same day and the object's time is later than the other object's time
        return (this.int_hour - other.int_hour) * 60 + (this.int_minute - other.int_minute);
    }

    public Time1 addMinutes (int num) {
        // Adds the number of minutes (num) to the current time (which is unchanged), represented by a new time object
        // If num is negative, subtract the minutes
        // if the time goes back a day it needs to be a valid input as stated before
        int new_object_hour;
        int new_object_minute;
        int numNoDays = num % (24 * 60);
        int minutesNoDays = numNoDays % 60;
        int hoursNoDays = numNoDays / 60;

        new_object_hour = this.int_hour + hoursNoDays;
        new_object_minute = this.int_hour + minutesNoDays;

        if ((this.int_hour + hoursNoDays) < 0) {
            new_object_hour = 23 + (this.int_hour + hoursNoDays);
        }
        if ((this.int_minute + minutesNoDays) < 0) {
            new_object_minute = 59 + (this.int_minute + minutesNoDays);
            new_object_hour--;
        }

        return new Time1(new_object_hour,new_object_minute);
    }

    public static void main(String[] args) {
        Time1 time = new Time1(9,44);
        Time1 time2 = new Time1(1,0);
        System.out.println(time2.addMinutes(-100));
    }
}
