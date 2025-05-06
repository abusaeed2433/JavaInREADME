package theobjectclass.part2;

public class Student implements Cloneable{
    private final int roll;
    private final String name;
    private int age;
    private double height;

    public Student(int roll, String name, int age, double height) {
        this.roll = roll;
        this.name = name;
        this.age = age;
        this.height = height;
    }

    public int getRoll() {
        return roll;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public int hashCode() {
//        return super.hashCode(); // default implementation
        int hash = 37;

        int code = roll;
        hash += 17 * hash + code;

        code = (name == null ? 0 : name.length());
        hash += 17 * hash + code;

        code = age;
        hash += 17 * hash + code;

        code = (int)height;
        hash += 17 * hash + code;

        return hash;
    }

    @Override
    public boolean equals(Object obj) {
//        return super.equals(obj); // default implementation

        if(this == obj){ // same reference
            return true;
        }

        if(!(obj instanceof Student)) { // object of different classes
            return false;
        }

        if(hashCode() != obj.hashCode()){ // different hashCode, so can't be same
            return false;
        }

        Student item = (Student)obj;

        return roll == item.roll && name.equals(item.name) && age == item.age && height == item.height;
    }


    @Override
    public String toString() {
        //return super.toString();
        return "roll: " + roll + ", " + "name: " + name + ", " + "age: " + age + ", " + "height: " + height;
    }

    @Override
    protected Object clone() {
        try {
            return super.clone();
        }catch (CloneNotSupportedException e){
            return null;
        }
    }

}
