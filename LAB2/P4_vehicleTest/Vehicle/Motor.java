package Vehicle;

public class Motor extends Vehicle{
    public Motor(int speed) {
        super(speed);
    }

    public Motor() {
        super(0);
    }

    public void getSpeed() {
        System.out.println("The Motor is going " + speed + " kmh.");
    }

    public void drive() {
        System.out.println("The Motor is driving.");
    }
}
