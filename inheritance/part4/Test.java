package inheritance.part4;

public class Test {

    public static void main(String[] args) {
        testOverload();
        testConstructorSequence();
        testConstructorParameter();
        testHidingBasic();
        testFieldHiding();
    }

    private static void testFieldHiding(){
        System.out.println("----------------- testFieldHiding ----------------------");

        Mother mother = new Mother("Rumi");
        Daughter daughter = new Daughter("Tisha");

        mother.printFormattedName(); // MRS Rumi
        daughter.printFormattedName(); // MISS Tisha
        daughter.printParentField(); // Don't know

    }

    private static void testHidingBasic(){
        System.out.println("----------------- testHidingBasic ----------------------");

        SuperClass spr = new SuperClass();
        SubClass sub = new SubClass();

        SuperClass.print(); // Super.print()
        spr.print(); // Super.print()

        System.out.println("---------------------------");

        SubClass.print(); // Sub.print()
        sub.print(); // Sub.print()

        System.out.println("---------------------------");

        ((SuperClass) sub).print(); // Super.print() <----(a)

        System.out.println("---------------------------");

        spr = sub;
        spr.print(); // Super.print() <---------------(b)
        ((SubClass) spr).print(); // Sub.print()


    }

    private static void testConstructorParameter(){
        System.out.println("------------------ testConstructorParameter -----------------------");

        Car myCar = new Car("Toyota", 4);

        System.out.println(myCar.brand); // Toyota
        System.out.println(myCar.noOfDoors); // 4

    }


    private static void testConstructorSequence(){
        System.out.println("------------------ testConstructorSequence -----------------------");
        Child child = new Child();
        /*
         Output
         parent constructor
         Child constructor
        */
    }

    private static void testOverload(){
        System.out.println( add(5,10) ); // 15
        System.out.println( add(5.0,10) ); // 15.8


        MyMath myMath = new MyMath();
        myMath.sub(5.0,2); // fine
        myMath.sub(5,2.0); // fine
        //myMath.sub(5,5); // ambiguous - compile-time error
    }


    private static int add(int x, int y){
        int res = (x+y);
        System.out.println("int add");
        return res;
    }

    private static double add(double x, double y){
        double res = x+y;
        System.out.println("double add");
        return res;
    }

}
