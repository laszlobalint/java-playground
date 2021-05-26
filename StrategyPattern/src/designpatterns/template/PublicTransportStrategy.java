package designpatterns.template;

import designpatterns.strategy.Strategy;

public abstract class PublicTransportStrategy implements Strategy {
    @Override
    public void travel() {
        System.out.println("Get on. ");
        System.out.println("Buy ticket. ");
        travelSpecial();
        System.out.println("Get off. ");
    }

    protected abstract void travelSpecial();
}
