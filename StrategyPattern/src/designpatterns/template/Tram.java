package designpatterns.template;

public class Tram extends PublicTransportStrategy {
    @Override
    protected void travelSpecial() {
        System.out.println("I am travelling by tram!");
    }
}
