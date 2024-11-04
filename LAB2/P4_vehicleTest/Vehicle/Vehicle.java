package Vehicle;

public abstract class Vehicle {
    public int speed;

    public Vehicle(int speed) {
        this.speed = speed;
    }

    public Vehicle() {
        this.speed = 0;
    }
    
    public abstract void getSpeed();
    public abstract void drive();
}