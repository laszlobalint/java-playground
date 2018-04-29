package factory1;

public abstract class PCShop {
    private String address;

    public PCShop(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public abstract CPU getCPU();
    public abstract MoBo getMoBo();
}
