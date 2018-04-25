package DesingPatterns;

public class Worker implements Subordinated {

    private String name;
    private double salary;
    private int year;
    private int month;
    private int day;

    public Worker(String name, double salary, int year, int month, int day) {
        this.name = name;
        this.salary = salary;
        this.year = year;
        this.month = month;
        this.day = day;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void work() {}

    @Override
    public void goHoliday() {}

    @Override
    public double getSalary() {
        return this.salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }
}


