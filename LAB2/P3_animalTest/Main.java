import Class.Animal;
import Class.Cat;
import Class.Dog;
import Class.Elephant;

public class Main {
    public static void main(String[] args) {
        Cat cat = new Cat();
        Dog dog = new Dog();
        Elephant elephant = new Elephant();
        Animal animalcat = cat;
        Animal animaldog = dog;
        Animal animalelephant = elephant;
        System.out.println("The outputs are from Animal run");
        animalelephant.run();
        animalcat.run();
        animaldog.run();
        
        System.out.println("The outputs are from Animal eat");
        animalelephant.eat();
        animalcat.eat();
        animaldog.eat();
        
        System.out.println("The outputs are from Animal speak");
        animalelephant.speak();
        animalcat.speak();
        animaldog.speak();
        
    }
}
