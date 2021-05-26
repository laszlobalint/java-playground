package DesignPatterns.italok;

public class Gyumolcsle extends Gyumolcs implements Ital {

    public Gyumolcsle(String fajta, String iz) {
        super(fajta, iz);
    }

    String mibolFacsartak() {
        return null;
    }

    @Override
    String milyenFajtaju() {
        return super.milyenFajtaju();
    }

    @Override
    public String mibolKeszult() { return fajta; }

    @Override
    public String milyenIzu() {
        return super.milyenIzu();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
