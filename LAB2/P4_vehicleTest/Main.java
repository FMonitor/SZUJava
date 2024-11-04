import Vehicle.Bus;
import Vehicle.Motor;
import Vehicle.Train;

public class Main {
    public static void main(String[] args) {
        Bus bus = new Bus(80);
        Motor motor = new Motor(60);
        Train train = new Train(100);
        
        motor.getSpeed();
        motor.drive();
        bus.getSpeed();
        bus.drive();
        train.getSpeed();
        train.drive();
    }
}