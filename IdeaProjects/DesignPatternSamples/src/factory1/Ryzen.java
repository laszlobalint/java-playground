package factory1;

public class Ryzen implements CPU {
    int freq;
    int cores;

    public Ryzen(int freq, int cores) {
        this.freq = freq;
        this.cores = cores;
    }

    @Override
    public int getFreq() {
        return freq;
    }

    @Override
    public int getCores() {
        return cores;
    }

    @Override
    public String toString() {
        return "Ryzen{" +
                "freq=" + freq +
                ", cores=" + cores +
                '}';
    }
}
