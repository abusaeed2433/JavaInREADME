package operator;

/**
 * Last modified at 21-Jul 2023
 * @author Abu Saeed
 * @version 1.0
 */
public class Test {

    public static void main(String[] args) {


        assignOperator();
        byteAssign();
        divisionTest();
        unaryPlusTest();
        incrementTest();
        equalTest();;
        logicalTest();
    }

    private static void logicalTest(){
        int i = 25;
        int j = 48;
        int k = 57;

        int count = 0;
        boolean outputFromLogical = (i<48) || (j == 48 ) || (++count < 1000);
        System.out.println(outputFromLogical + " -> " + count); // true -> 0


        boolean outputFromShortCircuit = (i<48) | (j == 48 ) | (++count < 1000);
        System.out.println(outputFromShortCircuit + " -> " + count); // true -> 1

        boolean outputAnd = (i == j) && (i++ ==k);
        System.out.println(outputAnd+" "+i); // false 25

        boolean outputShortAnd = (i == j) & (i++ ==k);
        System.out.println(outputShortAnd+" "+i); // false 25

    }


    private static void equalTest(){
        int i = 50;
        int j = 50;
        System.out.println(i==j); // true

        Kuetian st1 = new Kuetian(75,"CSE","Pantho");
        Kuetian st2 = new Kuetian(57,"CSE","Saeed");
        Kuetian st3 = new Kuetian(57,"CSE","Saeed");

        System.out.println(st1 == st2); // false
        System.out.println(st2 == st3); // false

        st1 = st3;
        System.out.println(st1==st3); // true

        Integer num1 = 100;
        Integer num2 = 100;
        System.out.println(num1==num2); // true

        Integer num3 = 10000;
        Integer num4 = 10000;
        System.out.println(num3==num4); // false


        // solution for equality between reference variable
        System.out.println(num3.equals(num4));//true

    }

    private static void incrementTest(){
        int i = 100;
        int j = ++i + 15;
        System.out.println(j+ " -> "+i); // 116 -> 101

        i = 100;
        j = i++ + 15;
        System.out.println(j+ " -> "+i); // 115 -> 101
    }

    private static void unaryPlusTest(){
        byte b1 = 10;
        byte b2 = +5;
        b1 = b2; // Ok. byte to byte assignment
        //b1 = +b2; // error
        b1 = (byte) +b2; // ok
    }

    private static void divisionTest(){
        double a = 2/0.0;
        System.out.println(a); // Infinity

        int div = 10/3;
        System.out.println(div); // 3

        // int e = 2/0; // error

    }

    private static void byteAssign(){
        byte b1;
        byte b2 = 2;
        byte b3 = 3;
        //b1 = b2 + b3; // error
        b1 = (byte) (b2 + b3); // ok
        b1 = 2+3;
    }

    private static void assignOperator(){
        long big = 524L;
        float f = 1.19F;
        int i = 15;
        //i = big; // compile time error
        //i = f; // compile time error. Can't convert implicitly
        i = (int)f; // ok
    }

}
