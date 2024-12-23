
public class E_NumberLetterPrinter {
    private static final Object lock = new Object();
    private static boolean numberTurn = true;

    public static void main(String[] args) {
        Thread numberThread = new Thread(new NumberPrinter());
        Thread letterThread = new Thread(new LetterPrinter());

        numberThread.start();
        letterThread.start();
    }

    static class NumberPrinter implements Runnable {
        @Override
        public void run() {
            for (int i = 1; i <= 52; i++) {
                synchronized (lock) {
                    while (!numberTurn) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    System.out.print(i);
                    if (i % 2 == 0) {
                        numberTurn = false;
                        lock.notify();
                    }
                }
            }
        }
    }

    static class LetterPrinter implements Runnable {
        @Override
        public void run() {
            for (char c = 'A'; c <= 'Z'; c++) {
                synchronized (lock) {
                    while (numberTurn) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    System.out.print(c);
                    numberTurn = true;
                    lock.notify();
                }
            }
        }
    }
}