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
        rand.setSeed(0);
        for (int i = 0; i < 10; i++) {
            int randx = rand.nextInt(100);
            int randy = rand.nextInt(100);
            matrix1.put(new Position(randx, randy), rand.nextDouble());
            randx = rand.nextInt(100);
            randy = rand.nextInt(100);
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
        for (Position pos : matrix1.keySet()) {
            for (Position pos2 : matrix2.keySet()) {
                if (pos.y == pos2.x) {
                    double value = matrix1.get(pos) * matrix2.get(pos2);
                    Position resultPos = new Position(pos.x, pos2.y);
                    if (result.containsKey(resultPos)) {
                        result.put(resultPos, result.get(resultPos) + value);
                    } else {
                        result.put(resultPos, value);
                    }
                }
            }
        }
        System.out.println("Result:");
        for (Position pos : result.keySet()) {
            System.out.println("[" + pos.x + " " + pos.y + "] " + result.get(pos));
        }
    }
}
