package LAB3;
import java.util.HashSet;

public class C_Set {
    public static void main(String[] args) {
        HashSet<String> A = new HashSet<String>();
        HashSet<String> B = new HashSet<String>();
        A.add("张三");
        A.add("李四");
        B.add("李四");
        B.add("王五");
        System.out.println("选修A课程的学生有：");
        for (String element : A) {
            System.out.println(element);
        }
        System.out.println("选修B课程的学生有：");
        for (String element : B) {
            System.out.println(element);
        }
        for (String elementA : A) {
            for (String elementB : B) {
                if (elementA.equals(elementB)) {
                    System.out.println("既选修A课程又选修B课程的学生有：" + elementA);
                }
            }
        }
        return;
    }
}
