// package LAB4;

import java.io.File;
import java.util.Scanner;
import java.lang.StringBuffer;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;

public class A_FileIO {
    public static void main(String[] args) {
        String fileName = "input.txt";
        String outputFileName = "output.txt";
        File file = new File(fileName);
        File outputFile = new File(outputFileName);
        try {
            Scanner scanner = new Scanner(file);
            FileWriter writer = new FileWriter(outputFile);
            BufferedWriter bw = new BufferedWriter(writer);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                StringBuffer sb = new StringBuffer(line);
                sb.reverse();
                bw.write(sb.toString());
                bw.newLine();
            }            
            bw.close();
            scanner.close();
        } catch (IOException e) {
            System.out.println("File not found: " + fileName);
        }
    }
}
