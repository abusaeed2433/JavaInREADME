package inheritance.part6;

public class Car {

    private String brand;
    private Engine engine;

    public Car(String brand, String engineType) {
        this.brand = brand;
        this.engine = new Engine(engineType);
    }

    public String getBrand() {
        return brand;
    }

    public Engine getEngine() {
        return engine;
    }

}
