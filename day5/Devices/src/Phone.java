public class Phone extends Device {

    public void makeCall() {
        decreaseEnergy(5);
        System.out.println("You make a call.");
        checkBattery();
    }

    public void playGame() {
        decreaseEnergy(20);

        System.out.println("You play a game.");
        checkBattery();
    }

    public void charge() {
        increaseEnergy(50);

        System.out.println("You charge your phone.");
        checkBattery();
    }

    private void checkBattery() {
        System.out.println("Battery remaining: " + battery);
        if (battery < 10) {
            System.out.println("Battery critical!");
        }
    }
}
