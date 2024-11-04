package interfacetest;
public class Japanese implements Human {
    private String name;
    public Japanese(String name) {
        this.name = name;
    }
    public double sayHello() {
        System.out.println("こんにちは、私は" + name);
        return 0.0;
    }
}
