package interfaces.with_not;

public class Girl implements Flyable{

    private final String name;

    public Girl(String name) {
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
