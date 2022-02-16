package Maman012;

public class Time2 {
    // Instance variable:
    private int _minuteFromMid;

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

    Time2 (Time2 other) {
        this._minuteFromMid = other._minuteFromMid;
    }

    // Getter functions
    int getHour() {
        return this._minuteFromMid;
    }

    int getMinute() {
        return this._minuteFromMid;
    }

    // Setter functions
    void setHour(int num) {
        // If num is out of the 0-59 bounds, the original value is unchanged
        if (num < 23 && num > 0) {
            this._minuteFromMid = num;
        }
    }

    void setMinute(int num) {
        // If num is out of the 0-59 bounds, the original value is unchanged
        if (num < 59 && num > 0) {
            this._minuteFromMid = num;
        }
    }

    int minFromMidnight() {
        // Retrieves the number of minutes since midnight by converting the number of hours to minutes and adding the minutes
        return this._minuteFromMid;
    }

    boolean equals (Time2 other) {
        // If the hours and minutes are equal to the input object's hours and minutes, return true
        return other._minuteFromMid == _minuteFromMid;
    }

    boolean before (Time2 other) {
        // If the time entered was before the current object's time
        if (this._minuteFromMid < other._minuteFromMid) {
            return true;
        }
        else return this._minuteFromMid == other._minuteFromMid;
    }

    boolean after (Time2 other) {
        // If the time entered was after the current object's time
        return !this.before(other);
    }

    int difference (Time2 other) {
        // Return the difference in minutes between two of the objects (the times are in the same day and the object's time is later than the other object's time)
        return this._minuteFromMid - other._minuteFromMid;
    }

    public String toString() {
        String hours = String.valueOf(this._minuteFromMid / 60);
        String minutes = String.valueOf(this._minuteFromMid % 60);

        // If the numbers are too short, add 0 to the number
        if ((this._minuteFromMid / 60) < 10) {
            hours = "0" + hours;
            if((this._minuteFromMid % 60) < 10) {
                minutes = "0" + minutes;
            }
        }

        return hours + ":" + minutes;
    }

    Time2 addMinutes(int num) {
        int hours = ((this._minuteFromMid + num) / 60) % 23;
        int minutes = (this._minuteFromMid + num) % 60;

        // If the numbers are negative, display number in time bounds
        if(hours < 0) {
            hours = 24 + hours;
        }

        if(minutes < 0) {
            minutes = 60 + minutes;
        }

        return new Time2(hours, minutes);
    }

    public static void main(String[] args) {
        Time2 time = new Time2(1,20);
        Time2 time2 = new Time2(1,0);
        System.out.println(time.difference(time2));
    }
}
