package humans;

public class Person {
    private String fullName;
    private int age;

    public void move() {

    }

    public void talk() {
        System.out.println("Игорь, расскажи мне про наследование в java");
    }

    public Person(String fullName, int age) {
        this.fullName = fullName;
        this.age = age;

    }
    public Person() {
    }

    public static void main(String[] args) {
        Person igor = new Person("Igor", 38);
        Person rinat = new Person();

        igor.move();
        rinat.talk();
    }


}
