package DesignPatterns.italok;

public class ErjedtGyumolcs extends Gyumolcs{
    double alkoholTartalom;

    public ErjedtGyumolcs(String fajta, String iz, double alkoholTartalom) {
        super(fajta, iz);
        this.alkoholTartalom = alkoholTartalom;
    }

    @Override
    public String toString() {
        return "ErjedtGyumolcs{" +
                "alkoholTartalom=" + alkoholTartalom +
                ", fajta='" + fajta + '\'' +
                ", iz='" + iz + '\'' +
                "} " + super.toString();
    }
}
