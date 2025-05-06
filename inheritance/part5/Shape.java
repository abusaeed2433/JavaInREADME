package inheritance.part5;

public abstract class Shape {
    protected final double PI = 3.14159;
    private String name;

    public Shape(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    protected abstract void draw();
    protected abstract double getArea();
}
