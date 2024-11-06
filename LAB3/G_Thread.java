package LAB3;

import java.util.Random;

class CheckThread extends Thread {
    private int id;
    private int count = 0;
    public CheckThread(int id) {
        this.id = id;
    }
    public boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
    @Override
    public void run() {
        System.out.println("Thread " + id + " is running");
        while (true) {
            if (isPrime(G_Thread.randx)) {
            System.out.println("Thread " + id + " found a prime number: " + G_Thread.randx);
            System.exit(0);
        }
        count++;
        if (count == 10) {
            System.out.println("Thread " + id + " has checked 10 numbers, no prime number found");
            System.exit(0);
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }}
    }
}

class GenerateThread extends Thread {
    private int id;

    public GenerateThread(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println("Thread " + id + " is running");
        while (true) {
            Random rand = new Random();
            rand.setSeed(System.currentTimeMillis());
            G_Thread.randx = rand.nextInt(10000);
            System.out.println("Thread " + id + " generated a number: " + G_Thread.randx);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class G_Thread {
    public volatile static int randx;

    public static void main(String[] args) {
        GenerateThread thread0 = new GenerateThread(0);
        CheckThread thread1 = new CheckThread(1);

        thread0.start();
        thread1.start();
    }
}
