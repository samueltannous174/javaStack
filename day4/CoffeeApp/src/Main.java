
import java.util.Scanner;

import static java.lang.System.exit;


public class Main{
    public static void main(String[] args){
        CoffeeKiosk k = new CoffeeKiosk(); //make instance
        k.addMenu("Lateh",2.2); //make items
        k.addMenu("tea",3.2);
        k.newOrder();


        exit(0);

    }

}