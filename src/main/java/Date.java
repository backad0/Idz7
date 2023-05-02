public class Date {
    private int day, year, monthCount;
    private String month;

    // empty constructor
    public Date() {
        this.day = 1;
        this.year = 1;
        this.month = "January";
        this.monthCount = 1;
    }

    // constructor with string month
    public Date(String month, int day, int year) {
        if ((day > 31) | (day < 1)) throw new IllegalArgumentException("numbers in a month are indicated from 1 to 31");
        if (month == null) throw new IllegalArgumentException("month can`t be null");
        if (year < 0) throw new IllegalArgumentException("we don't work with BC years");
        if ((!month.equals("January")) &
                (!month.equals("February")) &
                (!month.equals("March")) &
                (!month.equals("April")) &
                (!month.equals("May")) &
                (!month.equals("June")) &
                (!month.equals("July")) &
                (!month.equals("August")) &
                (!month.equals("September")) &
                (!month.equals("October")) &
                (!month.equals("November")) &
                (!month.equals("December"))
        ) {
            throw new IllegalArgumentException("no such month or you didn't capitalize it");
        }
        if (month.equals("January")) this.monthCount = 1;
        if (month.equals("February")) this.monthCount = 2;
        if (month.equals("March")) this.monthCount = 3;
        if (month.equals("April")) this.monthCount = 4;
        if (month.equals("May")) this.monthCount = 5;
        if (month.equals("June")) this.monthCount = 6;
        if (month.equals("July")) this.monthCount = 7;
        if (month.equals("August")) this.monthCount = 8;
        if (month.equals("September")) this.monthCount = 9;
        if (month.equals("October")) this.monthCount = 10;
        if (month.equals("November")) this.monthCount = 11;
        if (month.equals("December")) this.monthCount = 12;
        this.month = month;
        if (this.month.equals("February")) {
            if (((year % 4) == 0) & (year > 1899)) {
                if (day > 29)
                    throw new IllegalArgumentException("February cannot have more than 29 days in a leap year");
            } else {
                if (day > 28) throw new IllegalArgumentException("February cannot have more than 28 days");
            }
        }
        if ((this.month.equals("April")) | (this.month.equals("June")) | (this.month.equals("September")) | (this.month.equals("November"))) {
            if (day > 30)
                throw new IllegalArgumentException("April, June, September, November cannot have more than 28 days");
        }
        this.day = day;
        this.year = year;

    }

    // constructor int string month
    public Date(int month, int day, int year) {
        if ((day > 31) | (day < 1)) throw new IllegalArgumentException("numbers in a month are indicated from 1 to 31");
        if (year < 0) throw new IllegalArgumentException("we don't work with BC years");
        if ((month > 12) | (month < 1))
            throw new IllegalArgumentException("numbers in a year are indicated from 1 to 12");
        this.monthCount = month;
        if (month == 1) {
            this.month = "January";
        }
        if (month == 2) {
            this.month = "February";
        }
        if (month == 3) {
            this.month = "March";
        }
        if (month == 4) {
            this.month = "April";
        }
        if (month == 5) {
            this.month = "May";
        }
        if (month == 6) {
            this.month = "June";
        }
        if (month == 7) {
            this.month = "July";
        }
        if (month == 8) {
            this.month = "August";
        }
        if (month == 9) {
            this.month = "September";
        }
        if (month == 10) {
            this.month = "October";
        }
        if (month == 11) {
            this.month = "November";
        }
        if (month == 12) {
            this.month = "December";
        }
        if (this.month.equals("February")) {
            if (((year % 4) == 0) & (year > 1899)) {
                if (day > 29)
                    throw new IllegalArgumentException("February cannot have more than 29 days in a leap year");
            } else {
                if (day > 28) throw new IllegalArgumentException("February cannot have more than 28 days");
            }
        }
        if ((this.month.equals("April")) | (this.month.equals("June")) | (this.month.equals("September")) | (this.month.equals("November"))) {
            if (day > 30)
                throw new IllegalArgumentException("April, June, September, November cannot have more than 30 days");
        }
        this.day = day;
        this.year = year;
    }

    // getters
    public String getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public int getYear() {
        return year;
    }

    public int getMonthCount() {
        return monthCount;
    }

    //setters
    public void setMonthByString(String month) {
        if (month == null) throw new IllegalArgumentException("month can`t be null");
        if ((!month.equals("January")) & (!month.equals("january")) &
                (!month.equals("February")) & (!month.equals("february")) &
                (!month.equals("March")) & (!month.equals("march")) &
                (!month.equals("April")) & (!month.equals("april")) &
                (!month.equals("May")) & (!month.equals("may")) &
                (!month.equals("June")) & (!month.equals("june")) &
                (!month.equals("July")) & (!month.equals("july")) &
                (!month.equals("August")) & (!month.equals("august")) &
                (!month.equals("September")) & (!month.equals("september")) &
                (!month.equals("October")) & (!month.equals("october")) &
                (!month.equals("November")) & (!month.equals("november")) &
                (!month.equals("December")) & (!month.equals("december"))
        ) {
            throw new IllegalArgumentException("no such month");
        }
        if (month.equals("February")) {
            if (((this.year % 4) == 0) & (this.year > 1899)) {
                if (this.day > 29)
                    throw new IllegalArgumentException("February cannot have more than 29 days in a leap year");
            } else {
                if (this.day > 28) throw new IllegalArgumentException("February cannot have more than 28 days");
            }
        }
        if ((month.equals("April")) | (month.equals("June")) | (month.equals("September")) | (month.equals("November"))) {
            if (this.day > 30)
                throw new IllegalArgumentException("April, June, September, November cannot have more than 30 days");
        }
        this.month = month;
        if (month.equals("January")) this.monthCount = 1;
        if (month.equals("February")) this.monthCount = 2;
        if (month.equals("March")) this.monthCount = 3;
        if (month.equals("April")) this.monthCount = 4;
        if (month.equals("May")) this.monthCount = 5;
        if (month.equals("June")) this.monthCount = 6;
        if (month.equals("July")) this.monthCount = 7;
        if (month.equals("August")) this.monthCount = 8;
        if (month.equals("September")) this.monthCount = 9;
        if (month.equals("October")) this.monthCount = 10;
        if (month.equals("November")) this.monthCount = 11;
        if (month.equals("December")) this.monthCount = 12;
    }

    public void setMonthByInt(int month) {
        if ((month > 12) | (month < 1))
            throw new IllegalArgumentException("numbers in a year are indicated from 1 to 12");

        if (month==2) {
            if (((this.year % 4) == 0) & (this.year > 1899)) {
                if (this.day > 29)
                    throw new IllegalArgumentException("February cannot have more than 29 days in a leap year");
            } else {
                if (this.day > 28) throw new IllegalArgumentException("February cannot have more than 28 days");
            }
        }
        if ((month==3) | (month==6) | (month==9) | (month==11)) {
            if (this.day > 30)
                throw new IllegalArgumentException("April, June, September, November cannot have more than 30 days");
        }

        if (month == 1) {
            this.month = "January";
        }
        if (month == 2) {
            this.month = "February";
        }
        if (month == 3) {
            this.month = "March";
        }
        if (month == 4) {
            this.month = "April";
        }
        if (month == 5) {
            this.month = "May";
        }
        if (month == 6) {
            this.month = "June";
        }
        if (month == 7) {
            this.month = "July";
        }
        if (month == 8) {
            this.month = "August";
        }
        if (month == 9) {
            this.month = "September";
        }
        if (month == 10) {
            this.month = "October";
        }
        if (month == 11) {
            this.month = "November";
        }
        if (month == 12) {
            this.month = "December";
        }
        this.monthCount = month;
    }

    public void setDay(int day) {
        if ((day > 31) | (day < 1)) throw new IllegalArgumentException("numbers in a month are indicated from 1 to 31");
        if (this.month.equals("February")) {
            if (((year % 4) == 0) & (year > 1899)) {
                if (day > 29)
                    throw new IllegalArgumentException("February cannot have more than 29 days in a leap year");
            } else {
                if (day > 28) throw new IllegalArgumentException("February cannot have more than 28 days");
            }
        }
        if ((this.month.equals("April")) | (this.month.equals("June")) | (this.month.equals("September")) | (this.month.equals("November"))) {
            if (day > 30)
                throw new IllegalArgumentException("April, June, September, November cannot have more than 28 days");
        }
        this.day = day;
    }

    public void setYear(int year) {
        if (year < 0) throw new IllegalArgumentException("we don't work with BC years");
        this.year = year;
    }

    public boolean isPreviousDay(Date eData) {
        if (eData == null) throw new IllegalArgumentException("date can't be null");
        if (this.year == eData.getYear()) {
            if (this.day == 1) {
                if ((this.month.equals("February") & eData.getMonth().equals("January")) |
                        (this.month.equals("March") & eData.getMonth().equals("February")) |
                        (this.month.equals("April") & eData.getMonth().equals("March")) |
                        (this.month.equals("May") & eData.getMonth().equals("April")) |
                        (this.month.equals("June") & eData.getMonth().equals("May")) |
                        (this.month.equals("July") & eData.getMonth().equals("June")) |
                        (this.month.equals("August") & eData.getMonth().equals("July")) |
                        (this.month.equals("September") & eData.getMonth().equals("August")) |
                        (this.month.equals("October") & eData.getMonth().equals("September")) |
                        (this.month.equals("November") & eData.getMonth().equals("October")) |
                        (this.month.equals("December") & eData.getMonth().equals("November"))) {
                    if (((this.month.equals("February")) |
                            (this.month.equals("April")) |
                            (this.month.equals("June")) |
                            (this.month.equals("August")) |
                            (this.month.equals("September")) |
                            (this.month.equals("November")))
                            & (eData.getDay() == 31)) {
                        return true;
                    } else {
                        if (((this.month.equals("May")) | (this.month.equals("July")) | (this.month.equals("October")) | (this.month.equals("December"))) & (eData.getDay() == 30)) {
                            return true;
                        } else {
                            if ((this.month.equals("March")) & (((year % 4) == 0) & (year > 1899)) & (eData.getDay() == 29)) {
                                return true;
                            } else {
                                if ((this.month.equals("March")) & !(((year % 4) == 0) & (year > 1899)) & (eData.getDay() == 28))
                                    return true;
                            }
                        }
                    }
                }
            } else {
                if ((this.month.equals(eData.getMonth())) & (this.day == eData.getDay() + 1)) {
                    return true;
                }
            }
        } else {
            if ((this.year == eData.getYear() + 1) & (this.month.equals("January")) & (eData.getMonth().equals("December")) & (this.day == 1) & (eData.getDay() == 31)) {
                return true;
            }
        }
        return false;
    }

    public boolean isPrevious(Date eData) {
        if (eData == null) throw new IllegalArgumentException("date can't be null");
        if (this.year < eData.getYear()) {
            return false;
        } else {
            if (this.year == eData.getYear()) {
                if (((this.monthCount == eData.getMonthCount()) & (this.day <= eData.getDay())) | (this.monthCount < eData.getMonthCount())) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean equals(Date date) {
        if ((this.monthCount == date.getMonthCount()) & (this.day == date.getDay()) & (this.year == date.getYear()))
            return true;
        return false;
    }

    public String toString(){
        return String.format("%d.%d.%d",this.monthCount,this.day, this.year);
    }
}
