package inheritance.part1;

public class Common {

    public static void main(String[] args) {

        testForefatherObject();

    }

    private static void testForefatherObject(){
        System.out.println("------------- testForefatherObject ---------------");
        A a = new A();
        B b = new B();

        // hashCode() is defined in Object class
        System.out.println(a.hashCode()); // executed successfully
        System.out.println(b.hashCode()); // executed successfully
    }


}

class A{ }
class B extends Object{}
