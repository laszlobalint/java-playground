package factory1;

public class AM4 implements MoBo {
    String standard;

    public AM4(String standard) {
        this.standard = standard;
    }

    @Override
    public String getStandard() {
        return standard;
    }

    @Override
    public String toString() {
        return "AM4{" +
                "standard=" + standard +
                '}';
    }
}
