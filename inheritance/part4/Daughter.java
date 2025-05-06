package inheritance.part4;

public class Daughter extends Mother{
    private static final String PREFIX = "MISS";

    private String name;

    public Daughter(String name) {
        super("Don't know");
        this.name = name;
    }

    public void printParentField(){
        System.out.println(super.name);
    }

    public void printFormattedName(){
        System.out.println(PREFIX+" "+name); // will use daughter name. hide name of Daughter
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
