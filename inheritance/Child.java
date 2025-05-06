package inheritance;

public class Child extends Parent {

    private String type;
    private final boolean arrested = true;

    public Child(String name, String type) {
        super(name);
        this.type = type;
    }

    @Override
    public boolean isArrested() {
        return arrested;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public static void print(){
        System.out.println("Static name and type");
    }

}

