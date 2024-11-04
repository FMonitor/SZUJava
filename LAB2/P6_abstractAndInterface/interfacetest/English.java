package interfacetest;

public class English implements Human {
    private String name;
    public English(String name) {
        this.name = name;
    }
    public double sayHello() {
        System.out.println("Hello, I am " + name);
        return 0.0;
    }
}
