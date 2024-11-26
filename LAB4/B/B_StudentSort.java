// package B;

import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.Arrays;
import java.util.logging.Logger;


class Student implements Comparable<Student> {
    String name;
    int age;
    int score;
    public int getAge() {return age;}
    public int getScore() {return score;}
    public String getName() {return name;}
    public Student(String name, int age, int score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }
    @Override
    public int compareTo(Student o) {
        if (this.score == o.score) {
            if (this.age == o.age) {
                return this.name.compareTo(o.name);
            } else {
                return this.age - o.age;
            }
        } else {
            return o.score - this.score;
        }
    }
}

public class B_StudentSort {
    public static void main(String[] args) {
        String inputString = "students.txt";
        String outputString = "sorted_students.txt";
        File input = new File(inputString);
        File output = new File(outputString);
        Student students[] = new Student[100];
        try{
            BufferedReader br = new BufferedReader(new FileReader(input));
            String line = br.readLine();
            int i = 0;
            while (true) {
                line = br.readLine();
                if (line == null) {
                    break;
                }
                String[] arr = line.split(",");
                students[i] = new Student(arr[0], Integer.parseInt(arr[1]), Integer.parseInt(arr[2]));
                i++;
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Arrays.sort(students, 0, 4);
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(output));
            bw.write("Name,Age,Score\n");
            for (int i = 0; i < 100; i++) {
                if (students[i] == null) {
                    break;
                }
                bw.write(students[i].getName() + "," + students[i].getAge() + "," + students[i].getScore() + "\n");
                System.out.println(students[i].getName() + "," + students[i].getAge() + "," + students[i].getScore());
            }
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }  
    }
}
