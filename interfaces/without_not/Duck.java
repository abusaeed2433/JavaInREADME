package interfaces.without_not;

public class Duck extends Animal{
    private final int id;

    public Duck(int id) {
        this.id = id;
    }

    public void walk(){
        System.out.println("Duck "+id+" is walking...");
    }

    public int getId() {
        return id;
    }

}
