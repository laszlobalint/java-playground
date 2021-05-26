package com.company.javapractice;

public class Main {

    public static void main(String[] args) {

        Stack st = new Stack(5);
        try {
            st.pushToStack("Hello");
            st.pushToStack("baby");
            st.pushToStack("tear");
            st.pushToStack("run");
            st.popFromStack();
            st.pushToStack("Oh");
            st.pushToStack("No");
            st.pushToStack(("This is too much"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(st);

        System.out.println(st.search("Oh"));
        System.out.println(st.search("whereitis"));

        try {
            System.out.println(divide2(8, 0));
        } catch (ExceptionDivZero exceptionDivZero) {
            exceptionDivZero.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
            finally {
            // Do something after error was thrown.
        }
    }

    public static float divide1(int a, int b) {
        return a / b;
    }

    public static float divide2(int a, int b) throws ExceptionDivZero {
        if (b == 0) {
            throw new ExceptionDivZero("It is not allowed to divide by zero.");
        }
        return divide1(a, b);
    }

    }
