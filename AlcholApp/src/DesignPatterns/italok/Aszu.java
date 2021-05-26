package DesignPatterns.italok;

public class Aszu extends Bor {
    int puttonySzam;

    public Aszu(double alkoholTartalom, String termoTerulet, int puttonySzam) {
        super(alkoholTartalom, termoTerulet);
        this.puttonySzam = puttonySzam;
    }

    int hanyPuttonyos() {
        return puttonySzam;
    }

    @Override
    public String toString() {
        return "Aszu{" +
                "puttonySzam=" + puttonySzam +
                ", szoloFajta='" + szoloFajta + '\'' +
                ", termoTerulet='" + termoTerulet + '\'' +
                ", iz='" + iz + '\'' +
                ", alkoholTartalom=" + alkoholTartalom +
                "} " + super.toString();
    }
}
