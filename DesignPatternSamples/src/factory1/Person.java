package factory1;

public class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public void shopping(PCShop pcShop) {
        System.out.println("I went shopping:\n" + "shop address: " + pcShop.getAddress() + "\n CPU: "
                + pcShop.getCPU() + "\nMoBo: " + pcShop.getMoBo());
    }
}
