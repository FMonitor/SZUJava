package testpack;

import basepack.FriendlyClass;

public class TestClass {
    public void testAccess() {
        FriendlyClass friendlyClass = new FriendlyClass();
        System.out.println(friendlyClass.publicMember); // 可以访问
        // System.out.println(friendlyClass.protectedMember); // 不可以访问
        // System.out.println(friendlyClass.packagePrivateMember); // 不可以访问
    }
}
