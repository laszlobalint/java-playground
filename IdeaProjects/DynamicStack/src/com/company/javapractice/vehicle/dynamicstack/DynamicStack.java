package com.company.javapractice.vehicle.dynamicstack;
public class DynamicStack {

    public DynamicStack() {
        this.tail = null;
    }

    private class Stack {
        int value;
        Stack previous = null;

        public Stack(int value, Stack previous) {
            this.value = value;
            this.previous = previous;
        }
    }

    private Stack tail = null;
    private Stack actual = null;
    private int size = 0;

    public void push(int value) {
        actual = new Stack(value, tail);
        tail = actual;
        size++;
        }

    public int pop() {
        int temp = actual.value;
        tail = tail.previous;
        size--;
        return temp;
        }

    public boolean isEmpty() {
        return tail == null;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        if (!isEmpty()) {
            StringBuilder temp = new StringBuilder();
            temp.append("[");
            actual = tail;
            while (actual.previous != null) {
                temp.append(actual.value).append(", ");
                actual = actual.previous;
            }
            temp.append(actual.value).append("]");
            return temp.toString();
        }
        return "";
        }
    }