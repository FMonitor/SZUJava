import java.util.Scanner;

public class Reverse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int num = sc.nextInt();
        int rev = 0;
        while (num > 0) {
            rev *= 10;
            rev += num % 10;
            num /= 10;
        }
        sc.close();
        System.out.println("Reversed number is: \n" + rev);
    }
}
