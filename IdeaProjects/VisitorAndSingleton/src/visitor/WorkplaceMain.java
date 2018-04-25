package visitor;

import java.util.ArrayList;
import java.util.List;

public class WorkplaceMain {
    public static void main(String[] args) {
        Worker worker1 = new Worker("Attila", 20,100);
        Worker worker2 = new Worker("Béla", 20,100);
        Worker worker3 = new Worker("Cecília", 20,100);
        Worker worker4 = new Worker("Szebasztián", 20,100);

        List<Employee> employeeList1 = new ArrayList<>();
        employeeList1.add(worker1);
        employeeList1.add(worker2);

        Manager manager1 = new Manager("McGregor", 50, 200, employeeList1);

        List<Employee> employeeList2 = new ArrayList<>();
        employeeList2.add(worker3);
        employeeList2.add(manager1);

        Manager manager2 = new Manager("Roberto", 50, 200, employeeList2);

        List<Employee> employeeList3 = new ArrayList<>();
        employeeList3.add(manager2);
        employeeList3.add(worker4);

        Boss boss = new Boss("Nagasaki", 100, 1000000, employeeList3);

        boss.accept(new PrintVisitor());

        boss.accept(new AwardVisitor());
        System.out.println();
        boss.accept(new PrintVisitor());

    }

}
