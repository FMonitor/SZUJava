package abstracttest;

public class English extends Human {
    public English(String name) {
        super(name);
    }
    public double sayHello() {
        System.out.println("Hello, I am " + name);
        return 0.0;
    }
}
