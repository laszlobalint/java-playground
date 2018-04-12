package DesingPatterns;

public class RealCar implements InCar {

    @Override
    public void drive(Driver driver) {
        if (driver.hasLincence) {
            System.out.println("You are allowed to drive.");
        }
    }
}
