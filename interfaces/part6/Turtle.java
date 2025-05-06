package interfaces.part6;

public class Turtle implements Walkable,Swimmable{
    private String name;

    public Turtle(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void bite(){
        System.out.println(name+" is biting...");
    }

    @Override
    public void swim() {
        System.out.println(name+" is swimming...");
    }

    @Override
    public void walk() {
        System.out.println(name+" is walking...");
    }

}
