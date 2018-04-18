package DesignPatterns.italok;

public class Bor extends AlkoholosItal {

    String szoloFajta;
    String termoTerulet;

    public Bor(double alkoholTartalom, String szoloFajta, String termoTerulet) {
        super(alkoholTartalom);
        this.szoloFajta = szoloFajta;
        this.termoTerulet = termoTerulet;
    }

    public Bor(double alkoholTartalom, String termoTerulet) {
    }

    String milyenSzolobolKeszult() {
        return szoloFajta;
    }

    String mibolkeszult() {
        return "Szőlő";
    }

    String holTermett() {
        return termoTerulet;
    }

    @Override
    public String toString() {
        return "Bor{" +
                "szoloFajta='" + szoloFajta + '\'' +
                ", termoTerulet='" + termoTerulet + '\'' +
                ", iz='" + iz + '\'' +
                ", alkoholTartalom=" + alkoholTartalom +
                "} " + super.toString();
    }
}
