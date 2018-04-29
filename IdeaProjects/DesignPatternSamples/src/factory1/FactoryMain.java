package factory1;

public class FactoryMain {
    public static void main(String[] args) {
        Person amber = new Person("Amber");

        amber.shopping(new IntelShop("InteLane 1"));
        amber.shopping(new AMDShop("AMDrive 2"));
    }
}
