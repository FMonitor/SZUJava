package Vehicle;

public class Bus extends Vehicle{
    public Bus(int speed) {
        super(speed);
    }

    public Bus() {
        super(0);
    }
    
    public void getSpeed() {
        System.out.println("The Bus is going " + speed + " kmh.");
    }

    public void drive() {
        System.out.println("The Bus is driving.");
    }
}
