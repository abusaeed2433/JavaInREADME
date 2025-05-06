package wrapper_class;

public class Test {

    public static void main(String[] args) {

        Integer num1 = new Integer(120);
        Integer num2 = Integer.valueOf(120);
        Integer num3 = 120;


        cacheTest();

        Integer n = 200; // Boxing
        int a = n; // Unboxing

//        Integer num4 = null;
//        int num5 = num4; // error

        printNumber(1002); // int -> 1002
        Integer val = 1002;

        printNumber(val); // Integer -> 1002
        boxingTest();


    }

    private static void boxingTest(){
        Integer num1 =  1000;
        Integer num2 =  1000;
        System.out.println(num1 == num2); // false, reference are different

        Integer num3 = 1002;
        System.out.println(num3>num1); // true, unboxed to primitive then compared

    }

    private static void printNumber(Integer num){
        System.out.println("Integer -> "+num);
    }

    private static void printNumber(int num){
        System.out.println("int -> "+num);
    }

    private static void cacheTest(){
        Integer n1 = Integer.valueOf(20);
        Integer n2 = Integer.valueOf(20);

        System.out.println(n1 == n2); // true

        Integer n3 = new Integer(20);
        Integer n4 = new Integer(20);

        System.out.println(n3 == n4); // false, new always create new object. No caching

        Integer n5 = Integer.valueOf(1240);
        Integer n6 = Integer.valueOf(1240);
        System.out.println(n5 == n6); // false
    }

}
