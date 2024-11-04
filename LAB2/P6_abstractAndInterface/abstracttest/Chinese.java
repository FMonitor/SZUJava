package abstracttest;

public class Chinese extends Human{
    public Chinese(String name) {
        super(name);
    }
    public double sayHello(){
        System.out.println("你好，我是" + name);
        return 0.0;
    }
}
