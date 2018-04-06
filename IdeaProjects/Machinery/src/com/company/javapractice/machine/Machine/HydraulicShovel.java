package com.company.javapractice.machine.Machine;

public class HydraulicShovel extends Machinery {
    private int bucketSize;

    public HydraulicShovel(int weight, String type, int bucketSize) {
        super(weight, type);
        this.bucketSize = bucketSize;
    }

    public double transloading(int sandToTransload, int distanceToCarry, Lorry lorry) throws Exception {
        int timeOfTransload = 0;
        int loadedSand = 0;
        while (sandToTransload >= bucketSize) {
            while (lorry.getCarryingCapacity() >= lorry.getLevelOfLoad() + bucketSize) {
                lorry.setLevelOfLoad(lorry.getLevelOfLoad() + bucketSize);
                sandToTransload -= bucketSize;
                if (lorry instanceof Lorry) {
                    timeOfTransload += 5;
                } else {
                    timeOfTransload += 6;
                }
            }
            try {
            double timeOfTransport = 0;
            timeOfTransport += lorry.transport(distanceToCarry);
            timeOfTransload += timeOfTransport;
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        return timeOfTransload;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public String toString() {
        return "Hydraulic shovel info - " +
                "Bucket size: " + bucketSize +
                "; Weight of machine: " + weight +
                ", Type of machine: " + type +
                ". " + super.toString();
    }
}
