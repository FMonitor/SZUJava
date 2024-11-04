public class D_arraySum {

    public static void main(String[] args) {
        double sum=0.0;
        for (double i = 1; i <= 15; i++) {
            sum += (i + 1) / (2 * i);
            System.out.println((i + 1) / (2 * i));
        }
        System.out.println("The sum of the series is: " + sum);
    }
}