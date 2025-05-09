package inheritance.part1;

class A{ }
class B extends Object{}

public class Common {

    public static void main(String[] args) {
        testForefatherObject();
    }

    private static void testForefatherObject(){
        System.out.println("------------- testForefatherObject ---------------");
        A a = new A();
        B b = new B();

        // hashCode() is defined in Object class
        System.out.println(a.hashCode()); // 733672688
        System.out.println(b.hashCode()); // 297927961
    }


}
