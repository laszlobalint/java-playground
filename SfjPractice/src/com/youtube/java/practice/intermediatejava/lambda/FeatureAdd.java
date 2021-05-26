package com.youtube.java.practice.intermediatejava.lambda;

public class FeatureAdd {


    public String doSomething(String in1, String in2, String in3, String in4, Boolean in5) {
        System.out.println(in5 ? "New function" : "Old function");
        return in1 + in2 + in3 + in4;
    }
    public String doSomething(String in1, String in2, String in3, String in4) {
        return doSomething(in1, in2, in3, in4, false);
    }
}
