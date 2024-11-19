package LAB_FINAL;
public class A_Teacher {
    private String name;
    private String id;
    private String gender;
    public A_Teacher() {
        name = "Unknown";
        id = "NULL";
        gender = "Unknown";
    }
    public A_Teacher(String name, String gender, String id) {
        this.name = name;
        this.gender = gender;
        this.id = id;
    }
    public void showInfo() {
        System.out.println("Teacher's Information: ");
        System.out.println("Name: " + name);
        System.out.println("Gender: " + gender);
        System.out.println("ID: " + id);
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getGender() {
        return gender;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getId() {
        return id;
    }
    public static void main(String[] args) {
        A_Teacher teacher = new A_Teacher("Mr.G",
                "Unknown", "1234");
        teacher.showInfo();
        teacher.setName("Mr.Glitch");
        teacher.setGender("Male");
        teacher.setId("5678");
        System.out.println("\nAfter changing: ");
        System.out.println("Name: " + teacher.getName());
        System.out.println("Gender: " + teacher.getGender());
        System.out.println("ID: " + teacher.getId());
        return;
    }
}
