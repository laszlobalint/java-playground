package com.company.javapractice;

import org.w3c.dom.css.Rect;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        int[] argsInt = new int[args.length];
        int i = 0;
        for (String arg : args) {
            argsInt[i] = Integer.parseInt(arg);
            i++;
        }

        ArrayList<Rectangle> rectangleList = new ArrayList<Rectangle>();
        for (i = 0; i < argsInt.length;) {
            if (argsInt[i] == 1) {
                rectangleList.add(new Rectangle(argsInt[i + 1]));
                i += 2;
            } else if (argsInt[i] == 2) {
                rectangleList.add(new Rectangle(argsInt[i + 1], argsInt[i + 2]));
                i += 3;
            }
        }

        int sumArea = 0;
        int sumDistrict = 0;
        for (Rectangle rect: rectangleList) {
            sumArea += rect.getArea();
            sumDistrict += rect.getDistrict();
        }
        System.out.println("Area average is " + sumArea / rectangleList.size());
        System.out.println("District average is " + sumDistrict / rectangleList.size());
    }
}
