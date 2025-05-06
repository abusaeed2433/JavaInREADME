package interfaces.part6;

public class Test {

    public static void main(String[] args) {
        testPolymorphic();

        Turtle turti = new Turtle("Turti");
        startWalking(turti); // Turti is walking...
    }

    private static void dynamicBindingTest(){
        Walkable oogway = new Turtle("Oogway");
        oogway.walk();
    }

    private static void testPolymorphic(){
        Turtle turti = new Turtle("Turti");

        Swimmable swimmable = turti;
        Walkable walkable = turti;
        Object obj = turti;

    }

    private static void startWalking(Walkable walkable){
        walkable.walk(); // Can't access other method
        // ((Turtle)walkable).bite(); // ok after converting
    }

}
