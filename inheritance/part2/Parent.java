package inheritance.part2;

public class Parent {

    private String name;
    public static int id = 0;

    public final void send(){
        System.out.println("Parent sending...");
    }

    public static void run(){
        System.out.println("Parent running...");
    }

    public void print(){
        System.out.println("Parent printing...");
    }

}
