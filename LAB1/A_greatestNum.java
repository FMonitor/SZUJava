
import java.text.DecimalFormat;

public class A_greatestNum {
    public static void main(String[] args) {
        double array[];
        array = new double[1000];
        for (int i = 0; i < 1000; i++) {
            array[i] = Math.random() * 100;
            array[i] = Double.parseDouble(new DecimalFormat("##.##").format(array[i]));
        } 
        for (int i = 0; i < 1000; i++) {
            for (int j = i + 1; j < 1000 - i; j++) {
                if (array[i] < array[j]) {
                    double temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        System.out.println("The greatest number is: " + array[0]);
        System.out.println("The second greatest number is: " + array[1]);
        System.out.println("The third greatest number is: " + array[2]);
        System.out.println("The fourth greatest number is: " + array[3]);
        System.out.println("The fifth greatest number is: " + array[4]);
        System.out.println("The sum of the five greatest numbers is: " +
         (array[0] + array[1] + array[2] + array[3] + array[4]));
    }
}
