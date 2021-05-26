package DesingPatterns;

public class Main {

    public static void main(String[] args) {
        InCar car = new RealCar();
        Driver driver = new Driver("Zoltán", 17, true);
        InCar proxy1 = new AccessControlProxy(18, car);
        InCar proxy2 = new AccessControlProxy(16, car);
        car.drive(driver);
        proxy1.drive(driver);
        proxy2.drive(driver);
    }
}
