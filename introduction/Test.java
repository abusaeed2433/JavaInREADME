package introduction;

public class Test {
    public static void main(String[] args) {
        Person person = new Person("Saeed",21);
        System.out.println(person.getName());

        Person p1 = new Student("Saeed",21,57);
        p1.printMyStatus(); //I am a student

        p1 = new Person("Saeed",36);
        p1.printMyStatus(); //I am a Person

    }
}
