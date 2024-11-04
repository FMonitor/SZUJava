package interfacetest;
public class Vector implements Computable {
    int vec[];
    public Vector(int[] a) {
        vec = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            vec[i] = a[i];
        }
    }
    public Vector add(Vector va, Vector vb) {
        int[] a = va.vec;
        int[] b = vb.vec;
        int[] c = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            c[i] = a[i] + b[i];
        }
        return new Vector(c);
    }
    public Vector minus(Vector va, Vector vb) {
        int[] a = va.vec;
        int[] b = vb.vec;
        int[] c = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            c[i] = a[i] - b[i];
        }
        return new Vector(c);
    }
    public void print() {
        for (int i = 0; i < vec.length; i++) {
            System.out.print(vec[i] + " ");
        }
        System.out.println();
    }
}
