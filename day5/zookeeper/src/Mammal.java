public class Mammal {
    private int energy;

    public Mammal(int energy) {
        this.energy = energy;
    }

    public int displayEnergy() {
        System.out.println("Current energy level: " + this.energy);
        return this.energy;
    }
    public void decreaseEnergy(int amount) {
        this.energy -= amount;
        System.out.println("Will decrease" +amount+ "so the current energy level: " + (this.energy));
    }
    public void increaseEnergy(int amount) {
        this.energy -= amount;
        System.out.println("Will increase" +amount+ "so the current energy level: " + (this.energy- amount));
    }




}
