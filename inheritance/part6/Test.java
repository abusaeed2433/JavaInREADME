package inheritance.part6;

public class Test {

    public static void main(String[] args) {
        testComposition1();
        testComposition2();
    }

    private static void testComposition1(){
        System.out.println("-------------------- testComposition1 ------------------");
        Mobile mobile = new Mobile("Nokia");
        mobile.showData(); // @@@@@@@@@@@@@@@@
    }

    private static void testComposition2(){
        System.out.println("-------------------- testComposition2 ------------------");

        Car myCar = new Car("Toyota", "Gasoline");
        System.out.println(myCar.getBrand()); // Toyota
        System.out.println(myCar.getEngine().getType()); // Gasoline
    }

}
