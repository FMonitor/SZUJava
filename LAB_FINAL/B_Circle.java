package LAB_FINAL;

public class B_Circle {
    public final double PI = 3.1416;
    private double radius;

    public B_Circle() {
        radius = 0.0;
    }    
    public B_Circle(double radius) {
        this.radius = radius;
    }
    public double getRadius() {
        return radius;
    }
    public void setRadius(double radius) {
        this.radius = radius;
    }
    public double getArea() {
        return PI * radius * radius;
    }
    public double getPerimeter() {
        return 2 * PI * radius;
    }
    
    public static void main(String[] args) {
        B_Circle circle1 = new B_Circle(5.0);
        System.out.println("Circle 1: ");
        System.out.println("Radius: " + circle1.getRadius());
        System.out.println("Area: " + circle1.getArea());
        System.out.println("Perimeter: " + circle1.getPerimeter());

        B_Circle circle2 = new B_Circle();
        circle2.setRadius(10.0);
        System.out.println("\nCircle 2: ");
        System.out.println("Radius: " + circle2.getRadius());
        System.out.println("Area: " + circle2.getArea());
        System.out.println("Perimeter: " + circle2.getPerimeter());
        
        return;
    }
}
