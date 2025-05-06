package interfaces.with_not;

public class Bird implements Flyable{

    private final String name;

    public Bird(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void fly() {
        System.out.println(name +" is flying...");
    }

}
