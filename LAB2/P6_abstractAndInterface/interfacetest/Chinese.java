package interfacetest;

public class Chinese implements Human{
    private String name;
    public Chinese(String name) {
        this.name = name;
    }
    public double sayHello(){
        System.out.println("你好，我是" + name);
        return 0.0;
    }
}
