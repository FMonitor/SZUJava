import interfacetest.Vector;

public class Main {
    public static void main(String[] args) {
        Vector vec1, vec2;
        vec1 = new Vector(new int[] { 1, 2, 3, 4, 5, 6 });
        vec2 = new Vector(new int[] { 1, 3, 5, 7, 9, 11 });
        Vector vec3 = vec1.add(vec1, vec2);
        Vector vec4 = vec1.minus(vec1, vec2);
        System.out.println("vec1 add vec2:");
        vec3.print();
        System.out.println("vec1 minus vec2:");
        vec4.print();
    }
}
