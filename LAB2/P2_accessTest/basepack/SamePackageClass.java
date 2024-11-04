package basepack;

public class SamePackageClass {
    public void testAccess() {
        FriendlyClass friendlyClass = new FriendlyClass();
        System.out.println(friendlyClass.publicMember); // 可以访问
        System.out.println(friendlyClass.protectedMember); // 可以访问
        System.out.println(friendlyClass.packagePrivateMember); // 可以访问
    }
}