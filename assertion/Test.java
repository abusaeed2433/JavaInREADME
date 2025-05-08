package assertion;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Test {


    public static void main(String[] args) {
        //assertType1();
        //assertType2();

        LocalDate dob = LocalDate.of(2001,3,21);
        int age = calculateAge(dob);

        assert age >= 22;
        System.out.println("I was right"); // executed
    }

    private static int calculateAge(LocalDate localDate){
        LocalDate now = LocalDate.now();

        long age = ChronoUnit.YEARS.between(localDate,now);

        System.out.println("Age is: "+age); // 22 at 2023
        return (int)age;
    }

    private static void assertType1(){
        int a = getNumber(2);

        assert a==4;
        /*
            when we write 4, we know how getNumber(int) works. It helps to debug code.
            Because if a != 4, then there must have error in getNumber(int) function
        */

        // assert a == 6; // will throw runtime exception
        System.out.println(a);
    }

    private static void assertType2(){
        int a = getNumber(2);

        assert a==6 : "Something is wrong in getNumber(int)";

        System.out.println(a); // java.lang.AssertionError: Something is wrong in getNumber(int)

    }

    private void startTest(){
        int divider = getNumber(0);

        assert divider != 0 : "idiot";;


        //above code won't show any error or exception. For catching exception just compile with cmd using -ea[enable assertion]
        //java -ea -cp D:\own\Java\Projects\CompleteJava\src assertion.Test

        //after enabling
        /*Exception in thread "main" java.lang.AssertionError: idiot
                at assertion.Test.startTest(Test.java:16)
                at assertion.Test.main(Test.java:10)*/

//        int ans = 100/divider;
//
//        System.out.println(ans);


        boolean enabled = false;
        boolean idiot = false;


        //assert enabled = true;  -- -- -- 1
        assert idiot = enabled = true;

        // above code(1) is like
        // assert true
        // if assert is not enabled then, enabled = become false.
        // same for line 2

        System.out.println(enabled);
        System.out.println(idiot);

        //output false - false

    }

    // dummy function
    private static int getNumber(int x){
        return x+x;
    }

}
