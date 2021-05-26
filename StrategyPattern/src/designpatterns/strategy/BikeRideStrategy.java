package designpatterns.strategy;

public class BikeRideStrategy implements Strategy {

    @Override
    public void travel() {
        System.out.println("I want to ride my bicycle!");
    }
}
