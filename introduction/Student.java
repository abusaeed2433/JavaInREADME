package introduction;

public class Student extends Person{
    private final int roll;
    public Student(String name, int age,int roll) {
        super(name, age);
        this.roll = roll;
    }

    public void printMyStatus(){
        System.out.println("I am a student");
    }

    public int getRoll() {
        return roll;
    }
}
