import java.util.Scanner;
public class B_priceCount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double price[]={0.5,0.6,0.8};
        int consume = 0;
        double total = 0;
        consume = sc.nextInt();
        if(consume <= 100){
            total+=consume*price[0];
        }else if(consume <= 200){
            total+=100*price[0];
            total+=(consume-100)*price[1];
        } else {
            total += 100 * price[0];
            total += 100 * price[1];
            total += (consume - 200) * price[2];
        }
        sc.close();
        System.out.println("The total price is: " + total);
    }
}


