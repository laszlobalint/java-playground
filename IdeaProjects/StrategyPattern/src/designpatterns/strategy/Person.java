package designpatterns.strategy;

public class Person  {
    Strategy strategy;

    public Person(Strategy strategy) {
        this.strategy = strategy;
    }

    public void travel() {
        strategy.travel();
    }

    public Strategy getStrategy() {
        return strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }
}
