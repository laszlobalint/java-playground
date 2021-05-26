package com.company.javapractice;

public class OwnLinkedList {

    public static void main(String[] args) {

    }

    private class Node {
        int value;
        Node previousNode = null;
        Node nextNode = null;

        public Node(int value, Node previousNode, Node nextNode) {
            this.value = value;
            this.previousNode = previousNode;
            this.nextNode = nextNode;
        }
    }

    private Node head = null;
    private Node tail = null;
    private Node actualNode = null;
    private int size;

    public boolean isEmpty() {
        return head == tail;
    }

    public boolean isFirst() {
        return actualNode == head;
    }

    public boolean isLast() {
        return actualNode == tail;
    }

    public int getActualValue() {
        if (actualNode != null) {
            return actualNode.value;
        } else {
            return -1;
        }
    }

    public void setActualNodeValue(int newValue) {
        if (actualNode != null) {
            actualNode.value = newValue;
        }
    }

    public void stepBackward() {
        if (actualNode != null && !isFirst()) {
            actualNode = actualNode.previousNode;
        }
    }

    public void stepForward() {
        if (actualNode != null && !isLast()) {
            actualNode = actualNode.nextNode;
        }
    }

    public void stepFirst() {
        actualNode = head;
    }

    public void stepLast() {
        actualNode = tail;
    }

    public void insertFirst(int value) {
        if (isEmpty()) {
            head = tail = actualNode;
        } else {
            actualNode = new Node(value, null, head);
            head.previousNode = actualNode;
            head = actualNode;
        }
    }

    public void insertLast(int value) {
        if (isEmpty()) {
            insertFirst(value);
        } else {
            actualNode = new Node(value, tail, null);
            tail.nextNode = actualNode;
            tail = actualNode;
        }
    }

    public void insertBefore(int value) {
        if (isEmpty() || isFirst()) {
            insertFirst(value);
        } else {
            Node newNode = new Node(value, actualNode.previousNode, actualNode);
            actualNode.previousNode.nextNode = newNode;
            actualNode.previousNode = newNode;
        }
    }

    public void insertAfter(int value) {
        if (isEmpty() || isLast()) {
            insertLast(value);
        } else {
            stepForward();
            insertBefore(value);
        }
    }

    public void removeFirst() {
        if (!isEmpty()) {
            if (isFirst()) {
                actualNode = head.nextNode;
                head = head.nextNode;
            }
            if (head != null) {
                head = head.nextNode;
                head.previousNode = null;
            } else {
                tail = null;
            }
        }
    }

    public void removeLast() {
        if (!isEmpty()) {
            if (tail == head) {
                removeFirst();
            }
            if (isLast()) {
                actualNode = tail.previousNode;
                tail = tail.previousNode;
                tail.nextNode = null;
            }
        }
    }

    public void removeActual() {
        if (!isEmpty()) {
            if (isFirst()) {
                removeFirst();
                return;
            }
            if (isLast()) {
                removeLast();
                return;
            }
            actualNode.previousNode.nextNode = actualNode.nextNode;
            actualNode.nextNode.previousNode = actualNode.previousNode;
            actualNode = actualNode.nextNode;
        }
    }

    public boolean contains(int searchValue) {
        if (!isEmpty()) {
            actualNode = head;
            do {
                if (actualNode.value == searchValue) {
                    return true;
                }
                actualNode = actualNode.nextNode;
            } while (!isLast());
        }
        return false;
    }

    public String toString() {
        if (!isEmpty()) {
            StringBuilder temp = new StringBuilder();
            temp.append("[");
            actualNode = head;
            while (!isLast()) {
                temp.append(actualNode.value).append(", ");
                actualNode = actualNode.nextNode;
            }
            temp.append(actualNode.value).append("]");
            return temp.toString();
        }
        return "";
    }

    public int getSize() {
        if (!isEmpty()) {
            actualNode = head;
            do {
                size++;
                actualNode = actualNode.nextNode;
            } while (!isLast());
            return size;
        }
        return 0;
    }
}
