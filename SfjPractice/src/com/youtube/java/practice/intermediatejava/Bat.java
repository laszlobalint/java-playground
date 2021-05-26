package com.youtube.java.practice.intermediatejava;

import java.io.Serializable;

public class Bat implements Fly, Serializable {

    public void ascend() {
        System.out.println("I am taking off...");
    }

    public void descend() {
        System.out.println("I am about to land...");
    }
}
