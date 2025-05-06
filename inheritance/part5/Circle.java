package inheritance.part5;

public class Circle extends Shape{
    private double r;

    public Circle(String name, double r) {
        super(name);
        this.r = r;
    }

    @Override
    protected void draw() {
        System.out.println("Circle");
    }

    @Override
    protected double getArea() {
        return PI*r*r;
    }

}
