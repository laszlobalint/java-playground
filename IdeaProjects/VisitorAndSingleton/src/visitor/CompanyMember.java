package visitor;

public abstract class CompanyMember {
    private String name;
    private int salary;
    private int money;
    private boolean onVacation;

    public CompanyMember(String name, int salary, int money) {
        this.name = name;
        this.salary = salary;
        this.money = money;
        onVacation = false;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isOnVacation() {
        return onVacation;
    }

    public void setOnVacation(boolean onVacation) {
        this.onVacation = onVacation;
    }

    public abstract void accept(BaseVisitor baseVisitor);
}