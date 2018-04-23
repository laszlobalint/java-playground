package designpatterns.template;

public class Bus extends PublicTransportStrategy {
    @Override
    protected void travelSpecial() {
        System.out.println("I am travelling by bus!");
    }
}
