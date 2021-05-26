package singleton;

public class Singleton {
    private String name;
    private static Singleton instance;

    Singleton(String name) {
        this.name = name;
    }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton("Larry");
        }
        return instance;
    }

    @Override
    public String toString() {
        return "\nName: " + name;
    }
}