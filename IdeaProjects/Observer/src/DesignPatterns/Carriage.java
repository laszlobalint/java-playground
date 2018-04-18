package DesignPatterns;

import java.util.Observable;

public class Carriage extends Observable {

    public void arrive(String station) {
        setChanged();
        notifyObservers(station);
    }
}
