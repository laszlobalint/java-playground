package factory1;

public class LGA1152 implements MoBo {
    private String standard;

    public LGA1152(String standard) {
        this.standard = standard;
    }

    @Override
    public String getStandard() {
        return standard;
    }

    @Override
    public String toString() {
        return "LGA1152{" +
                "standard=" + standard +
                '}';
    }
}