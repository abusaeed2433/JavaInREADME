package inheritance.part4;

public class Mother {
    private static final String PREFIX = "MRS";

    protected String name;

    public Mother(String name) {
        this.name = name;
    }

    public void printFormattedName(){
        System.out.println(PREFIX+" "+name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
