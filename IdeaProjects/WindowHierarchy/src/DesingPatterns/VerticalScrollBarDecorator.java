package DesingPatterns;

public class VerticalScrollBarDecorator extends WindowDecorator {

    public VerticalScrollBarDecorator(Window window) {
        super(window);
    }

    @Override
    public void info() {
        super.info();
        System.out.println("With vertical scrollbar.");
    }

    @Override
    public void draw() {
        super.draw();
        System.out.println("With vertical scrollbar.");
    }
}
