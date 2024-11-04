package abstracttest;

public abstract class Human{
    String name;
    public Human(String name){
        this.name = name;
    }
    public abstract double sayHello();
}