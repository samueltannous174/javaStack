package javaStack.day1;

 public class CafeJava {
    public static void main(String[] args) {

        String generalGreeting = "Welcome to Cafe Java, ";
        String pendingMessage = ", your order will be ready shortly";
        String readyMessage = ", your order is ready";
        String displayTotalMessage = "Your total is $";

        double mochaPrice = 3.5;
        double CoffeePrice = 2.25;
        double lattePrice = 4.75;

        String customer1 = "samuel";
        String customer2 = "ibrahim";

        boolean isReadySamuel = true;
        boolean isReadyIbrahim = false;   



        System.out.println(generalGreeting + customer1);

        System.out.println(generalGreeting + customer2);
        if (isReadySamuel) {
            System.out.println(customer1 + readyMessage);
        } else {
            System.out.println(customer1 + pendingMessage);
        }

     

        double samuelLatteTotal = 2 * lattePrice;
        System.out.println(customer1 + ", " + displayTotalMessage + samuelLatteTotal);
        if (isReadySamuel) {
            System.out.println(customer1 + readyMessage);
        } else {
            System.out.println(customer1 + pendingMessage);
        }

    
}
 {
    
 }
}
