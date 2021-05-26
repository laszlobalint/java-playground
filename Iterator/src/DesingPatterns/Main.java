package DesingPatterns;

public class Main {

    public static void main(String[] args) {
        Container container = new Container(5);
        container.addData(0);
        container.addData(234);
        container.addData("tank");
        container.addData(99.1);
        container.addData(false);
        Iterator iterator = container.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("Size: " + container.getSize());
        System.out.println("Third item: " + container.getData(2));
    }
}
