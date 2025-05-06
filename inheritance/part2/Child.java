package inheritance.part2;

public class Child extends Parent{

    private String type;
    public static int id = 1;

    public static void run(){
        System.out.println("Child running...");
    }

    public void print(){
        System.out.println("Child printing...");
    }
}
