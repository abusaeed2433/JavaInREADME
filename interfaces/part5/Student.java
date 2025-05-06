package interfaces.part5;

public class Student implements Comparable<Student>{
    private int roll;
    private String name;
    private String email;
    private double height;

    public Student(int roll, String name, String email, double height) {
        this.roll = roll;
        this.name = name;
        this.email = email;
        this.height = height;
    }

    public int getRoll() {
        return roll;
    }

    public void setRoll(int roll) {
        this.roll = roll;
    }

    public String getFirstName(){
        return name.substring(0,name.indexOf(" "));
    }

    public String getLastName(){
        return name.substring(name.lastIndexOf(" ")+1);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }


    @Override
    public int compareTo(Student o) {
        // our own logic
        return roll - o.roll; // sorting based on roll
    }

}
