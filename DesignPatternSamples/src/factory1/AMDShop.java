package factory1;

public class AMDShop extends PCShop {
    public AMDShop(String address) {
        super(address);
    }

    @Override
    public CPU getCPU() {
        return new Ryzen(3500, 4);
    }

    @Override
    public MoBo getMoBo() {
        return new AM4("mATX");
    }
}
