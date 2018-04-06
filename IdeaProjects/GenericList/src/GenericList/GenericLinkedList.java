package GenericList;

    public class GenericLinkedList<T> {

        class LinkedListNode {
            private T value;
            private LinkedListNode previous = null;
            private LinkedListNode next = null;

            public LinkedListNode(T value, LinkedListNode previous, LinkedListNode next) {
                this.value = value;
                this.previous = previous;
                this.next = next;
            }

            public T getValue() {
                return value;
            }

            public void setNext(LinkedListNode next) {
                this.next = next;
            }

            public LinkedListNode getNext() {
                return next;
            }

            public void setPrevious(LinkedListNode previous) {
                this.previous = previous;
            }

            public LinkedListNode getPrevious() {
                return previous;
            }

            @Override
            public String toString() {
                return "Linked List Node - " +
                        "; Value: " + value +
                        "; Previous: " + previous +
                        "; Next: " + next +
                        '.';
            }
        }

        private LinkedListNode head = null;
        private LinkedListNode tail = null;
        private LinkedListNode actual = null;
        private int size;

        public boolean isEmpty() {
            return head == null && tail == null;
        }

        public boolean isFirst() {
            return actual == head;
        }

        public boolean isLast() {
            return actual == tail;
        }

        public T getActual() {
            if (actual != null) {
                return actual.getValue();
            } else {
                return null;
            }
        }

        public void setActual(LinkedListNode newValue) {
            if (actual != null) {
                this.actual = newValue;
            }
        }

        public void stepBackward() {
            if (actual != null && !isFirst()) {
            actual = actual.getPrevious();
            }
        }

        public void stepForward() {
            if (actual != null && !isLast()) {
                actual = actual.getNext();
            }
        }

        public void stepFirst() {
            actual = head;
        }

        public void stepLast() {
            actual = tail;
        }

        public void insertFirst(T value) {
            actual = new LinkedListNode(value, null, head);
            if (isEmpty()) {
                head = tail = actual;
            } else {
                head.setPrevious(actual);
                head = actual;
            }
        }

        public void insertLast(T value) {
            if (isEmpty()) {
                insertFirst(value);
            } else {
                actual = new LinkedListNode(value, tail, null);
                tail.setNext(actual);
                tail = actual;
            }
        }

        public void insertBefore(T value) {
            if (isEmpty() || isFirst()) {
            insertFirst(value);
            } else {
                LinkedListNode newNode = new LinkedListNode(value, actual.getPrevious(), actual);
                actual.getPrevious().setNext(newNode);
                actual.setPrevious(newNode);
            }
        }

        public void insertAfter(T value) {
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
                    actual = head.getNext();
                    head = head.getNext();
                }
                if (head != null) {
                    head = head.getNext();
                    head.setPrevious(null);
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
                    actual = tail.getPrevious();
                    tail = tail.getPrevious();
                    tail.setNext(null);
                } if (tail != null) {
                    tail = tail.getPrevious();
                    tail.setNext(null);
                }
                else {
                    head = null;
                }
            }
        }

        public void removeActual() {
            if (!isEmpty()) {
                removeFirst();
                return;
            }
            if (isLast()) {
                removeLast();
                return;
            }
            actual.getPrevious().setNext(actual.getNext());
            actual.getNext().setPrevious(actual.getPrevious());
            actual = actual.getNext();
        }

        public boolean contains(T searchNode) {
            if (!isEmpty()) {
                actual = head;
                do {
                    if (actual.getValue() == searchNode) {
                        return true;
                    }
                    actual = actual.getNext();
                } while (!isLast());
            }
            return false;
        }

        public String toString() {
            if (!isEmpty()) {
                StringBuilder temp = new StringBuilder();
                temp.append("[");
                actual = head;
                while (!isLast()) {
                    temp.append(actual.getValue()).append(", ");
                    actual = actual.getNext();
                }
                temp.append(actual.getValue()).append("]");
                return temp.toString();
            }
            return "";
        }

        public int getSize() {
            if (!isEmpty()) {
                actual = head;
                do {
                    size++;
                    actual = actual.getNext();
                } while (!isLast());
                size++;
                return size;
            }
            return 0;
        }


        public static void main(String[] args) {
            GenericLinkedList<String> list = new GenericLinkedList<>();
            list.insertFirst("Pálinka");
            list.insertLast("Gomba");
            System.out.println(list.isEmpty());
            list.insertLast("Paulina");
            list.insertFirst("Joseph");
            list.insertFirst("Monika");
            System.out.println(list.getSize());
            System.out.println(list);
            System.out.println(list.contains("Pálinka"));

            GenericLinkedList<Integer> listInt = new GenericLinkedList <>();
            listInt.insertFirst(30);
            listInt.insertFirst(6);
            listInt.insertAfter(10);
            listInt.insertLast(100);
            listInt.insertBefore(41);
            listInt.insertFirst(11);
            listInt.removeFirst();
            listInt.removeLast();
            System.out.println(listInt);
        }
    }