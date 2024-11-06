package LAB3;

import java.util.HashMap;
import java.util.Random;

class Position implements Comparable<Position> {
    int x;
    int y;
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Position) {
            Position pos = (Position) obj;
            return this.x == pos.x && this.y == pos.y;
        }
        return false;
    }
    @Override
    public int hashCode() {
        return this.x * 1000 + this.y;
    }
    @Override
    public int compareTo(Position o) {
        if (this.x == o.x) {
            return this.y - o.y;
        }
        return this.x - o.x;
    }
}

public class F_Matrix {
    public static void main(String[] args) {
        HashMap<Position, Double> matrix1 = new HashMap<>();
        HashMap<Position, Double> matrix2 = new HashMap<>();
        HashMap<Position, Double> result = new HashMap<>();
        Random rand = new Random();
        rand.setSeed(System.currentTimeMillis());
        for (int i = 0; i < 10; i++) {
            int randx = rand.nextInt(20);
            int randy = rand.nextInt(20);
            matrix1.put(new Position(randx, randy), rand.nextDouble());
            randx = rand.nextInt(20);
            randy = rand.nextInt(20);
            matrix2.put(new Position(randx, randy), rand.nextDouble());
        }
        System.out.println("Matrix 1:");
        for (Position pos : matrix1.keySet()) {
            System.out.println("[" + pos.x + " " + pos.y + "] " + matrix1.get(pos));
        }
        System.out.println("Matrix 2:");
        for (Position pos : matrix2.keySet()) {
            System.out.println("[" + pos.x + " " + pos.y + "] " + matrix2.get(pos));
        }
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                double sum = 0;
                for (int k = 0; k < 20; k++) {
                    Position pos1 = new Position(i, k);
                    Position pos2 = new Position(k, j);
                    if (matrix1.containsKey(pos1) && matrix2.containsKey(pos2)) {
                        sum += matrix1.get(pos1) * matrix2.get(pos2);
                    }
                }
                if (sum != 0) {
                    result.put(new Position(i, j), sum);
                }
            }
        }
        System.out.println("Result:");
        for (Position pos : result.keySet()) {
            System.out.println("[" + pos.x + " " + pos.y + "] " + result.get(pos));
        }
    }
}
