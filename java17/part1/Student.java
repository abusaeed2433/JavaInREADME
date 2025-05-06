package java17.part1;

public class Student {
    private int roll;
    private String name;
    private double height;

    public Student(int roll, String name, double height) {
        this.roll = roll;
        this.name = name;
        this.height = height;
    }

    public int getRoll() {
        return roll;
    }

    public void setRoll(int roll) {
        this.roll = roll;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }


}
