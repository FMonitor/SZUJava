package LAB3;

import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;

public class E_CountDate {
    public static void main(String[] args) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyƒÍMM‘¬dd»’");
        Scanner sc = new Scanner(System.in);
        String date1 = sc.next();
        String date2 = sc.next();
        sc.close();
        try {
            Date d1 = dateFormat.parse(date1);
            Date d2 = dateFormat.parse(date2);
            System.out.println("Parsed Date: " + d1);
            System.out.println("Parsed Date: " + d2);
            d1.getTime();
            d2.getTime();
            long diff = d2.getTime() - d1.getTime();
            long diffDays = diff / (24 * 60 * 60 * 1000);
            System.out.println("Days: " + diffDays);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}