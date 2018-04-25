package visitor;

public abstract class Employee extends CompanyMember {
    public Employee(String name, int salary, int money) {
        super(name, salary, money);
    }

    public abstract void getPaid(Boss boss);
    public abstract void goOnVacation(CompanyMember superior);
}
