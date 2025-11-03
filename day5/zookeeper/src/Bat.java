public class Bat extends Mammal{
    public Bat(){
        super(300);
    }

    public Bat fly () {
        decreaseEnergy(100);
        displayEnergy();
        return this;
    }

    public Bat eatHumans() {
        increaseEnergy(10);
        displayEnergy();
        return this;
    }

    public Bat attackTown() {
        decreaseEnergy(10);
        displayEnergy();
        return this;
    }
}



