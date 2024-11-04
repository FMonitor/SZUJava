public class C_countCompleteNumber {
    public static void main(String[] args) {
        int count = 0;
        for (int i = 2; i <= 1000; i++) {
            if (i == getFactorsSum(i)) {
                System.out.println(i);
                count++;
            }
        }
        System.out.println("The number of complete numbers between 2 and 1000 is: " + count);
    }
    static int getFactorsSum(int n) {
        int sum = 0;
        for (int i = 1; i < n; i++) {
            if (n % i == 0) {
                sum += i;
            }
        }
        return sum;
    }
}