// import abstracttest.*;
import interfacetest.*;

public class HumanTest {
    public static void main(String[] args) {
        Human set[] = new Human[3];
        set[0] = new Chinese("张三");
        set[1] = new Japanese("太郎");
        set[2] = new English("Tom");
        for (int i = 0; i < set.length; i++) {
            set[i].sayHello();
        }
    }
}
