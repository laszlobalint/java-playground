package com.company.javapractice.machine.Machine;

public class TransloadWrapper implements Comparable<TransloadWrapper> {
    private HydraulicShovel hydraulic;
    private Lorry lorry;
    private double transload;

    public TransloadWrapper(HydraulicShovel hydraulic, Lorry lorry, double transload) {
        this.hydraulic = hydraulic;
        this.lorry = lorry;
        this.transload = transload;
    }

    public HydraulicShovel getHydraulic() {
        return hydraulic;
    }

    public void setHydraulic(HydraulicShovel hydraulic) {
        this.hydraulic = hydraulic;
    }

    public Lorry getLorry() {
        return lorry;
    }

    public void setLorry(Lorry lorry) {
        this.lorry = lorry;
    }

    public double getTransload() {
        return transload;
    }

    public void setTransload(double transload) {
        this.transload = transload;
    }

    @Override
    public int compareTo(TransloadWrapper wrapper) {
        if (this.transload == wrapper.getTransload()) {
            return 0;
        } else if (this.transload > wrapper.getTransload()) {
            return 1;
        } else {
            return -1;
            }
        }

    @Override
    public String toString() {
        return "Transloading: " +
                "Excavator: " + hydraulic +
                "; Lorry: " + lorry +
                "; Time of transload: " + transload +
                '.';
    }
}
