public class Gorilla extends Mammal {

    public Gorilla(){
        super(100);
    }


    public Gorilla throwSomething() {
        decreaseEnergy(5);
        displayEnergy();
        return this;
    }

    public Gorilla eatBananas() {
        increaseEnergy(10);
        displayEnergy();
        return this;
    }

    public Gorilla climb() {
        decreaseEnergy(10);
        displayEnergy();
        return this;
    }
}
