package DesingPatterns;

public class Main {

    public static void main(String[] args) {
        Window window = new HorizontalScrollBarDecorator(new VerticalScrollBarDecorator(new NormalWindow()));
        window.info();
    }
}
