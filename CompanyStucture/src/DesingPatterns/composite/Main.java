package DesingPatterns.composite;

public class Main {

    public static void main(String[] args) {
        Manager smallBoss = new Manager("Andrew Goldstein", 60000, 1987, 12, 15);
        Director bigBoss = new Director("James Crueger", 120000, 1978, 9, 10);
        smallBoss.setBonus(3000);
        bigBoss.setBonus(5000);
        Employee[] staff = new Employee[4];
        staff[0] = new Worker("Harry Freud", 45000, 1989, 10, 1);
        staff[1] = new Worker("Tony Lenchester", 35000, 1990, 3, 15);
        staff[2] = smallBoss;
        staff[3] = bigBoss;

        for (Employee e : staff) {
            System.out.println("Employee: " + e.getName() + " ; Payment with bonuses: " + e.getSalary() + " $");
        }
    }
}
