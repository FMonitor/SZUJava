package LAB3;

import java.util.HashSet;

public class C_Set {
    public static void main(String[] args) {
        HashSet<StringBuffer> A = new HashSet<StringBuffer>();
        HashSet<StringBuffer> B = new HashSet<StringBuffer>();
        A.add(new StringBuffer("张三"));
        A.add(new StringBuffer("李四"));
        B.add(new StringBuffer("李四"));
        B.add(new StringBuffer("王五"));
        System.out.println("选修A课程的学生有：");
        for (StringBuffer element : A) {
            System.out.println(element);
        }
        System.out.println("选修B课程的学生有：");
        for (StringBuffer element : B) {
            System.out.println(element);
        }
        A.retainAll(B);
        for (StringBuffer element : A) {
            System.out.println("既选修A课程又选修B课程的学生有：" + element);
        }
        return;
    }
}
