import testpack.TestClass;
import basepack.SamePackageClass;

public class Main {
    public static void main(String[] args) {
        System.out.println("Output from TestClass:");
        TestClass testClass = new TestClass();
        testClass.testAccess();
        System.out.println("Output from SamePackageClass:");
        SamePackageClass samePkgClass = new SamePackageClass();
        samePkgClass.testAccess();
    }
}
