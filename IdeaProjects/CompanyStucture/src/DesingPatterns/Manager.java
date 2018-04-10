package DesingPatterns;

public class Manager extends Subordinating implements Subordinated {


    @Override
    public void work(int hoursPerWeek) {
        System.out.println("The manager works " + hoursPerWeek + " hours per week.");
    }

    @Override
    public void goHoliday(boolean isOnHoliday) {
        System.out.println("The manager is on holiday: " + isOnHoliday);
    }

    @Override
    public void getSalary(int DollarsPerMonth) {
        System.out.println("The manager get " + DollarsPerMonth + " dollars per month.");
    }
}
