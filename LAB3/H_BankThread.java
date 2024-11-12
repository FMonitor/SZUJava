package LAB3;

class BankAccount {
    private int balance = 100;
    private String name;
    public BankAccount(String name) {
        this.name = name;
    }
    public int getBalance() {
        return balance;
    }
    public synchronized void withdraw(int amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println(name + " withdraws $" + amount + ", balance: " + getBalance());
        } else {
            System.out.println(name + " tries to withdraw $" + amount + ", but insufficient balance.");
        }
    }
}

class WithdrawThread extends Thread {
    private BankAccount account;
    public WithdrawThread(BankAccount account) {
        this.account = account;
    }
    public void run() {
        for (int i = 0; i < 5; i++) {
            account.withdraw(10);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class H_BankThread {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("Account");
        Thread t1 = new WithdrawThread(account);
        Thread t2 = new WithdrawThread(account);
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Final balance: " + account.getBalance());
    }
}