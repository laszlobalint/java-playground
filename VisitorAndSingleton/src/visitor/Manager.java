package visitor;

import java.util.List;

public class Manager extends Employee{
    private List<Employee> subordinates;

    public Manager(String name, int salary, int money, List<Employee> subordinates) {
        super(name, salary, money);
        this.subordinates = subordinates;
    }

    public List<Employee> getSubordinates() {
        return subordinates;
    }

    public void setSubordinates(List<Employee> subordinates) {
        this.subordinates = subordinates;
    }

    public void employSomeone(Employee newGuy) {
        subordinates.add(newGuy);
    }

    public void fireSomeone(Employee assGuy) {
        subordinates.remove(assGuy);
    }

    @Override
    public void getPaid(Boss boss) {
        setMoney(getMoney() + getSalary());
    }

    @Override
    public void goOnVacation(CompanyMember superior) {
        if (superior instanceof Boss && !isOnVacation()) {
            setOnVacation(true);
        }
    }

    @Override
    public void accept(BaseVisitor baseVisitor) {
        for (Employee employee : subordinates) {
            employee.accept(baseVisitor);
        }
        baseVisitor.visit(this);
    }
}