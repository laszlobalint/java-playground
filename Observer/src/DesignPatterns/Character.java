package DesignPatterns;

import java.util.Observable;
import java.util.Observer;

public class Character implements Observer {

    private String name;
    private String destination;

    public Character(String name, String destination) {
        this.name = name;
        this.destination = destination;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    @Override
    public void update(Observable observable, Object o) {
        if (observable instanceof Carriage) {
            if (o.equals(destination)) {
                System.out.println("We have arrived. " + name + " gets off at " + destination);
                observable.deleteObserver(this);
            } else {
                System.out.println(name + " travels on.");
            }
        }
    }
}
