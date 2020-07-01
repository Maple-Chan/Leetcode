package Java_test;

public class FinalTest {
    
    public static void main(String[] args) {
        final Person p = new Person();

        p.setName("Maple Chan");

        System.out.println(p.getName());

    }
}

class Person{
    private String name;

    public Person(){
        name = "Maple";
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

}