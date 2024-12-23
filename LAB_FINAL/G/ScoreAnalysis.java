
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;


import javax.annotation.processing.Filer;
import javax.swing.SortOrder;

class Student implements Comparable<Student> {
    private String name;
    private double score;
    public Student() {
    }
    public Student(String name, double score) {
        this.name = name;
        this.score = score;
    }
    @Override
    public int compareTo(Student stu) {
        if (stu.score > this.score) {
            return 1;
        } else if (stu.score == this.score) {
            return stu.name.compareTo(this.name);
        } else {
            return -1;
        }
    }
    public String getName() {
        return name;
    }
    public double getScore() {
        return score;
    }
}

public class ScoreAnalysis {
    public static void main(String[] args) {
        String inputFilePath = "score.txt";
        String outputFilePath = "analysis_result.txt";
        Student[] students = new Student[1000];
        int len = 0;
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            FileInputStream fis = new FileInputStream(inputFilePath);
            InputStreamReader isr = new InputStreamReader(fis, "GBK");
            br = new BufferedReader(isr);
            while (true) {
                String line = br.readLine();
                if (line == null) {
                    break;
                }
                String[] tmp = line.split(",");
                students[len++] = new Student(tmp[0], Double.parseDouble(tmp[1]));
            }
            br.close();

            Arrays.sort(students, 0, len);

            FileOutputStream fos = new FileOutputStream(outputFilePath);
            OutputStreamWriter osw = new OutputStreamWriter(fos, "GBK");
            bw = new BufferedWriter(osw);
            printInfo(students, bw, len);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void printInfo(Student[] students, BufferedWriter bw, int len) {
        double total = 0;
        double maxn = 0;
        double minx = 100;
        int cnt = 0;
        try {
            for (int i = 0; i < len; i++) {
                double tmp = students[i].getScore();
                total += tmp;
                maxn = max(maxn, tmp);
                minx = min(minx, tmp);
                if (tmp >= 60)
                    cnt++;
            }
            bw.write("Total Score:" + Double.toString(total) + "\nAverage Score:" + Double.toString(total / len)
                    + "\nHighest Score:" + Double.toString(maxn) + "\nLowest Score:" + Double.toString(minx));
            bw.write("\nPassed Student count:");
            bw.write(Integer.toString(cnt));
            bw.write("\nStudents passed:\n");
            for (int i = 0; i < len; i++) {
                double tmp = students[i].getScore();
                if (tmp >= 60) {
                    bw.write(students[i].getName() + " " + Double.toString(tmp));
                    bw.newLine();
                }
            }
            bw.write("The five highest students:\n");
            for (int i = 0; i < min(5, len); i++) {
                bw.write(students[i].getName() + " " + Double.toString(students[i].getScore()));
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    static double max(double a, double b) {
        if (a > b)
            return a;
        return b;
    }
    static double min(double a, double b) {
        if (a < b)
            return a;
        return b;
    }
}