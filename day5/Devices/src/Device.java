public class Device {
    protected int battery;

    public Device() {
        this.battery = 100;
    }

    public void batteryStatus() {
        System.out.println("Battery remaining: " + battery);
    }
    public void increaseEnergy(int amount){
        this.battery+=amount;
    }
    public void decreaseEnergy(int amount){
        this.battery-=amount;

    }
}
