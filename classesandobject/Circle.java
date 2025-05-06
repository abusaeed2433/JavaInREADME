package classesandobject;

public final class Circle {

    public static final double PI = 3.14159; // final

    private final double r; // blank - final

    public Circle() {
        this.r = 0;
    }

    public Circle(double r) {
        this.r = r;
    }

    public Circle(Circle c){
        this(c.r); // this will assign value
        //this.r = c.r; // error, since already assigned in previous line
    }

    public double getArea(){
        return PI * r * r;
    }

}
