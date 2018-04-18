package DesignPatterns.italok;

public class AlkoholosItal implements Ital, Alkoholos {

    String iz;
    double alkoholTartalom;

    public AlkoholosItal(String iz, double alkoholTartalom) {
        this.iz = iz;
        this.alkoholTartalom = alkoholTartalom;
    }

    public AlkoholosItal(double alkoholTartalom) {
    }

    public AlkoholosItal() {
    }

    public double mennyiAlkoholtTartalmaz() {
        return alkoholTartalom;
    }

    @Override
    public String mibolKeszult() {
        return null;
    }

    @Override
    public String milyenIzu() {
        return null;
    }
}
