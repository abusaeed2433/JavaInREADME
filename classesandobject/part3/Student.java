package classesandobject.part3;

public class Student {
    private int roll;
    private String name;
    private int age;

    public Student(int roll, String name, int age) {
        this.roll = roll;
        this.name = name;
        this.age = age;
    }

    public void setRoll(int roll){
        this.roll = roll;
    }

    public int getRoll() {
        return roll;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
