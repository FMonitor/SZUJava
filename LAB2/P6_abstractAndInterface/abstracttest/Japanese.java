package abstracttest;
public class Japanese extends Human {
    public Japanese(String name) {
        super(name);
    }
    public double sayHello() {
        System.out.println("こんにちは、私は" + name);
        return 0.0;
    }
}
