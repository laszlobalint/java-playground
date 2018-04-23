package designpatterns.strategy;

public class WalkingStrategy implements Strategy {
    @Override
    public void travel() {
        System.out.println("Let's go for a nice walk!");
    }
}
