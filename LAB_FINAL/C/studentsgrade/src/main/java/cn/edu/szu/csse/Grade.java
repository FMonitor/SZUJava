package cn.edu.szu.csse;
// import cn.edu.szu.csse.Student;

public class Grade {
    private Student student1;
    private Student student2;
    private Student student3;

    public Grade() {
        student1 = new Student("张三", 90);
        student2 = new Student("李四", 80);
        student3 = new Student("王五", 70);
    }

    public String getStudentNames() {
        return student1.getName() + " " + student2.getName() + " " + student3.getName();
    }

    public void printStudentScores() {
        System.out.println(student1.getScore());
        System.out.println(student2.getScore());
        System.out.println(student3.getScore());
    }
}
