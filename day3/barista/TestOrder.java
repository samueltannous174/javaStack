
public class TestOrder{
    public static void main(String[] args){
        Item tea = new Item("tea",  3.2);
        Item mocha = new Item("mocha",  5.2);
        Item coffe = new Item("coffe",  4.2);
        Item nescafe = new Item("nescafe",  2.2);

        Order order1 = new Order("Sam");
        Order order2 = new Order("new");


        order1.addItem(tea);
        order1.addItem(mocha);

        order2.addItem(coffe);
        order2.addItem(nescafe);


        order1.setReady(false);
        order2.setReady(true);

        System.out.println("Order 1: " + order1.getStatusMessage());
        System.out.println("Order 2: " + order2.getStatusMessage());
        System.out.println();

        System.out.println("Order 1 total:  " + String.format("%.2f", order1.getOrderTotal()));
        System.out.println("Order 2 total:  " + String.format("%.2f", order2.getOrderTotal()));
        System.out.println();

        order1.display();
        order2.display();
    }
}
