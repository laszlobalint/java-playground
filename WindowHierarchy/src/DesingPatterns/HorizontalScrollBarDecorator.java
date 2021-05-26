package DesingPatterns;

public class HorizontalScrollBarDecorator extends WindowDecorator {

    public HorizontalScrollBarDecorator(Window window) {
        super(window);
    }

        @Override
        public void draw() {
            super.draw();
            System.out.println("With horizontal scrollbar.");
        }

        @Override
        public void info() {
            super.info();
            System.out.println("With horizontal scrollbar.");
        }
}
