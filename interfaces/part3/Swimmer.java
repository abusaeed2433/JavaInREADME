package interfaces.part3;

public class Swimmer implements Swimmable{

    private String name;
    private final int id;
    private Swimmable swimmable; // global variable

    public Swimmer(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public Swimmable getSwimmable() {
        Swimmable swimmable = this; // local variable
        if(this.swimmable == null){
            this.swimmable = swimmable;
        }
        return swimmable;
    }

    public void setSwimmable(Swimmable swimmable) { // parameter
        this.swimmable = swimmable;
    }

    @Override
    public void swim() {
        System.out.println("Swimming...");
    }

}
