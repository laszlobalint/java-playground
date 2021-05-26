package GenericStack;

public class StackElement<T> {

    private T value;
    private StackElement<T> next;

    public StackElement(T value, StackElement<T> next) {
        this.value = value;
        this.next = next;
    }

    public StackElement <T> getNext() {
        return next;
    }

    public T getValue() {
        return value;
    }
}
