package DesingPatterns;

public class Worker implements Subordinated {
    private boolean isOnHoliday;

    @Override
    public void work(int hoursPerWeek) {
        System.out.println("The worker works " + hoursPerWeek + " hours per week.");
    }

    @Override
    public void goHoliday(boolean isOnHoliday) {
        System.out.println("The worker is on holiday: " + isOnHoliday);
    }

    @Override
    public void getSalary(int DollarsPerMonth) {

    }

    public boolean isOnHoliday() {
        return isOnHoliday;
    }

    public void setOnHoliday(boolean onHoliday) {
        isOnHoliday = onHoliday;
    }
}


