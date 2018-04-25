package singleton;

public class SingletonMain {

    public static void main(String[] args) {
        Singleton singleton = new Singleton("Rob");
        System.out.println(singleton.getInstance());
        System.out.println(singleton);
    }
}
