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
        this._minuteFromMid = other.getHour() * 60 + other.getMinute();
    }

    // Getter functions
    int getHour() {
        return this._minuteFromMid / 60;
    }

    int getMinute() {
        return this._minuteFromMid % 60;
    }

    // Setter functions
    void setHour(int num) {
        // If num is out of the 0-23 bounds, the original value is unchanged
        if (num < 23 && num > 0) {
            this._minuteFromMid = (this.getHour() + num) % 23;
        }
    }

    void setMinute(int num) {
        // If num is out of the 0-59 bounds, the original value is unchanged
        if (num < 59 && num > 0) {
            this._minuteFromMid = (this.getMinute() + num) % 59;
        }
    }

    int minFromMidnight() {
        // Retrieves the number of minutes since midnight by converting the number of hours to minutes and adding the minutes
        return this._minuteFromMid;
    }

    boolean equals (Time2 other) {
        // If the hours and minutes are equal to the input object's hours and minutes, return true
        return this._minuteFromMid == other._minuteFromMid;
    }

    boolean before (Time2 other) {
        // If the time entered was before the current object's time
        return this._minuteFromMid < other._minuteFromMid;
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

    Time2 addMinutes(int num) {
        int tempNum = this._minuteFromMid + num;
        int tempHours = tempNum / 60;
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

    public static void main(String[] args) {
        Time2 time = new Time2(0,20);
        System.out.println(time.addMinutes(-140));
    }
}
