package DesingPatterns;

public class Container implements Iterable {
    private Object[] data;
    private int capacity;
    private int size;

    public Container(int capacity) {
        this.capacity = capacity;
        this.data = new Object[capacity];
        this.size = 0;
    }

    public void addData(Object newData) {
        if (capacity > size) {
            data[size++] = newData;
        } else {
            System.out.println("Not enough space!");
        }
    }

    public int getSize() {
        return size;
    }

    public Object getData(int index) {
        if (index >= size && index < 0) {
            return "No such object under this index.";
        }
        return data[index];
    }

    public class Iterator implements DesingPatterns.Iterator {
        private int pointer = -1;
        @Override
        public boolean hasNext() {
            if (pointer < size - 1) {
                return true;
            }
            return false;
        }

        @Override
        public Object next() {
            return data[++pointer];
        }
    }

    @Override
    public Iterator iterator() {
        return new Iterator();
    }
}
