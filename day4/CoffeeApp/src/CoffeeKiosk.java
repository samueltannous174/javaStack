import java.util.ArrayList;
import java.util.Scanner;

public class CoffeeKiosk {
    ArrayList<Item> menu;
    ArrayList<Order> orders;


    public CoffeeKiosk(){
        menu = new ArrayList<Item>();
        orders = new ArrayList<Order>();
    }

    public void addMenu( String name, double price){
        Item item= new Item(name, price);
        menu.add(item);
    }
    public void displayMenu(){
        for (int i =0; i < menu.size(); i++) {
            Item item = menu.get(i);
            System.out.println(i + " " + item.getName() + " " + String.format("%.2f", item.getPrice()));
        }
    }
    public void  newOrder(){
        System.out.println("Welcome to the Coffee Shop!");
        System.out.println("What's your name:");

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine(); //get the name
        Order order=new Order(input); //pass the name to the order constructor
        while (!input.equals("q")){
            System.out.println("chose number or press q!");
            displayMenu();  //show all choices
            input = scanner.nextLine();

            try { // if the input was anything than number
               int index= Integer.parseInt(input); // convert str to int
                System.out.println("'" + input + "' is a valid integer.");
                Item item = menu.get(index);
                order.addItems(item);


            } catch (NumberFormatException e) {
                System.out.println("'" + input + "' is not a valid integer.");  // will now end safe
                System.out.print(order);
            }
        }

    }
}
