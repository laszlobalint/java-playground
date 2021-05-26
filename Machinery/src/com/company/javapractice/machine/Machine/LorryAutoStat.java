package com.company.javapractice.machine.Machine;

import java.util.TreeMap;

public class LorryAutoStat extends Lorry {

    private TreeMap <Integer, String> power = new TreeMap <>();

    public LorryAutoStat() {
    }

    public TreeMap <Integer, String> getPower() {
        return power;
    }

    public void setPower(TreeMap <Integer, String> power) {
        this.power = power;
    }

    public String carryingCapacity(Lorry lorry) {
        if (power.containsKey(lorry.getType())) {
            return power.get(lorry.getCarryingCapacity());
        }
        return null;
    }

    public void carryingDatabase(Lorry lorry) {
        power.put(lorry.getCarryingCapacity(), lorry.getType());
    }


}
