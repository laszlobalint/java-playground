package visitor;

public class Worker extends Employee {

    public Worker(String name, int salary, int money) {
        super(name, salary, money);
    }

    @Override
    public void getPaid(Boss boss) {
        setMoney(getMoney() + getSalary());
    }

    @Override
    public void goOnVacation(CompanyMember superior) {
        if (superior instanceof Manager) {
            System.out.println("You ain't go anywhere.");
        } else if (superior instanceof Boss) {
            setOnVacation(true);
        }
    }

    @Override
    public void accept(BaseVisitor baseVisitor) {
        baseVisitor.visit(this);
    }
}
