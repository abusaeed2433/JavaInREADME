package interfaces.part1;

public class Duck2 implements Walkable{
    private String name;
    public Duck2(String name) {
        this.name = name;
    }

    @Override
    public void walk() {
        System.out.println(name + " (a duck) is walking.");
    }

}

