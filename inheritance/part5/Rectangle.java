package inheritance.part5;

public class Rectangle extends Shape{

    private double width;
    private double height;

    public Rectangle(String name, double width, double height) {
        super(name);
        this.width = width;
        this.height = height;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    protected void draw() {
        System.out.println("Rectangle");
    }

    @Override
    protected double getArea() {
        return width*height;
    }

}
