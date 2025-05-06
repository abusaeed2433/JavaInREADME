package java17.part1;

public class PartTimeStudent extends Student{

    private int hours;

    public PartTimeStudent(int roll, String name, double height, int hours) {
        super(roll, name, height);
        this.hours = hours;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }
}
