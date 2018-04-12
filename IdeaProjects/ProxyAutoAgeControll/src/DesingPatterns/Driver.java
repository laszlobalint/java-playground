package DesingPatterns;

public class Driver {
    String name;
    int age;
    boolean hasLincence;

    public Driver(String name, int age, boolean hasLincence) {
        this.name = name;
        this.age = age;
        this.hasLincence = hasLincence;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isHasLincence() {
        return hasLincence;
    }

    public void setHasLincence(boolean hasLincence) {
        this.hasLincence = hasLincence;
    }
}
