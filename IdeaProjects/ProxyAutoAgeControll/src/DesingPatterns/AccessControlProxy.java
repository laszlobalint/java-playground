package DesingPatterns;

public class AccessControlProxy implements InCar {

    int ageLimit;
    InCar car;

    public AccessControlProxy(int ageLimit, InCar car) {
        this.ageLimit = ageLimit;
        this.car = car;
    }

    @Override
    public void drive(Driver driver) {
        if (driver.getAge() >= ageLimit) {
            car.drive(driver);
            System.out.print("Go, and have fun.");
        } else {
            System.out.println("You are too young to drive.");
        }
    }
}
