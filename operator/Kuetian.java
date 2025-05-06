package operator;

public class Kuetian {
    private final int roll;
    private final String dept;
    private String name;

    public Kuetian(int roll, String dept, String name) {
        this.roll = roll;
        this.dept = dept;
        this.name = name;
    }

    public int getRoll() {
        return roll;
    }

    public String getDept() {
        return dept;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
