package DesingPatterns;

public class NormalWindow implements Window {

    @Override
    public void draw() {
        System.out.println("Draw window for simple window.");
    }

    @Override
    public void info() {
        System.out.println("This is a simple window.");
    }
}
