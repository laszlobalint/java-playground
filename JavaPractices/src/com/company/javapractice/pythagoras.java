package com.company.javapractice;

public class pythagoras {

        public static void main(String[] args) {
            double a = Double.parseDouble(args[0]);
            double b = Double.parseDouble(args[1]);
            double r = 0.0;

            if (Math.abs(a) > Math.abs(b)) {
                r = b / a;
                r = Math.abs(a) * Math.sqrt(1 + r*r);
            }
            else if (b != 0) {
                r = a / b;
                r = Math.abs(b) * Math.sqrt(1 + r*r);
            }
            System.out.println(r);
        }
    }
