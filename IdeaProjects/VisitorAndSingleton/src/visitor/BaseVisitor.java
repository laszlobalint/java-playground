package visitor;

public class BaseVisitor {
    public void visit(Manager manager) {
        visit((Employee) manager);
    }

    public void visit(Boss boss) {
        visit((CompanyMember) boss);
    }

    public void visit(Worker worker) {
        visit((Employee) worker);
    }

    public void visit(Employee employee) {
        visit((CompanyMember) employee);
    }

    public void visit(CompanyMember companyMember) {

    }
}
