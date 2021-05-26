package visitor;

import java.util.List;

public class Boss extends CompanyMember {
    List<Employee> allEmployees;

    public Boss(String name, int salary, int money, List<Employee> allEmployees) {
        super(name, salary, money);
        this.allEmployees = allEmployees;
    }

    public List<Employee> getAllEmployees() {
        return allEmployees;
    }

    public void setAllEmployees(List<Employee> allEmployees) {
        this.allEmployees = allEmployees;
    }

    @Override
    public void accept(BaseVisitor baseVisitor) {
        for (Employee employee : allEmployees) {
            employee.accept(baseVisitor);
        }
        baseVisitor.visit(this);
    }
}
