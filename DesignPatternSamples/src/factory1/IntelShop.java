package factory1;

public class IntelShop extends PCShop {
    public IntelShop(String address) {
        super(address);
    }

    @Override
    public CPU getCPU() {
        return new Intel5(3200, 4);
    }

    @Override
    public MoBo getMoBo() {
        return new LGA1152("ATX");
    }
}
