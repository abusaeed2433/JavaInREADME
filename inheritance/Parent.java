package inheritance;

public class Parent {

    private String name;
    private final boolean arrested = false;

    public Parent(String name) {
        this.name = name;
    }

    public boolean isArrested() {
        return arrested;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void print(){
        System.out.println("Static name");
    }

}
