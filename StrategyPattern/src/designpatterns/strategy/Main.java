package designpatterns.strategy;

import designpatterns.template.Bus;
import designpatterns.template.Tram;

public class Main {

    public static void main(String[] args) {
        Strategy walk = new WalkingStrategy();
        Strategy ride = new BikeRideStrategy();
	    Person person = new Person(walk);
	    person.travel();
	    person.setStrategy(ride);
	    person.travel();
        System.out.println();
        person.setStrategy(new Tram());
        person.travel();
        System.out.println();
        person.setStrategy(new Bus());
        person.travel();
    }
}
