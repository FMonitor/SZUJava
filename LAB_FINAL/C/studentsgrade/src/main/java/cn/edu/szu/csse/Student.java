package cn.edu.szu.csse;

public class Student {
    String name;
    int score;

    Student() {
        name = "";
        score = 0;
    }

    Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    String getName() {
        return name;
    }

    int getScore() {
        return score;
    }
}
