package introduction;

public class Person {

    private final String name;
    private int age = 21;

    public Person(String name,int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void printMyStatus(){
        System.out.println("I am a Person");
    }

    public void setAge(int age) {
        if(age < 0){
            return;
        }
        this.age = age;
    }

    public String getName() {
        return name;
    }
}
