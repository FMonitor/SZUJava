package Vehicle;

public class Train extends Vehicle{
    public Train(int speed) {
        super(speed);
    }

    public Train() {
        super(0);
    }

    public void getSpeed() {
        System.out.println("The Train is going " + speed + " kmh.");
    }

    public void drive() {
        System.out.println("The Train is driving.");
    }
}
