package DesingPatterns;

public class ClosableWindow extends WindowDecorator {

    public ClosableWindow(Window window) {
        super(window);
    }

    public void close() {
        System.out.println("Window is closed.");
    }

    @Override
    public void draw() {
        super.draw();
    }

    @Override
    public void info() {
        super.info();
    }
}
