public class TestOrder{
    public static void main(String[] args){
        Item tea = new Item("tea",  3.2);
        Item mocha = new Item("mocha",  5.2);
        Item coffe = new Item("coffe",  4.2);
        Item nescafe = new Item("nescafe",  2.2);

        Order order1 = new Order("order1");
        order1.addItems(tea);
        order1.addItems(coffe);
        System.out.println(order1.getTotal());
    }
    
}   