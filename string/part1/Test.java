package string.part1;

public class Test {

    public static void main(String[] args) {

        escapeTest();
        charSequenceTest();
        stringConstructorTest();

        somePropertiesTest();
        immutableTest();

        stringCompareTo();

        stringPoolTest();
        internTest();

    }

    private static void internTest(){
        System.out.println("---------------------- internTest ---------------------");

        String var = "My variable";
        String s2 = (var + " is actually pooled").intern(); // added to pool

        String res = "My variable is actually pooled";
        System.out.println(s2 == res); // true. without intern() output is false
    }

    private static void stringPoolTest(){
        System.out.println("---------------- stringPoolTest -------------------------");

        // Bard
        String rohit = "Rohit";
        String salma = "Salma";

        String rohitAgain = "Rohit";
        String rohitNew = new String("Rohit");

        System.out.println(rohit == salma); // false
        System.out.println(rohit == rohit); // true
        System.out.println(rohit == rohitAgain); // true, since referring same object in String pool
        System.out.println(rohit == rohitNew); // false, Remember new always creates new object


        String added = "Have" + "Fun";
        String together = "HaveFun";

        System.out.println(added == together); // true, since ("Have" + "Fun") is evaluated at compile time and result "HaveFun" is added to pool


        final String constStr = "Constant"; // constStr is a constant since final
        String s1 = constStr + " is pooled"; // "Constant is pooled" will be added to the string pool

        String res1 = "Constant is pooled";
        System.out.println(s1 == res1); // true


        String varStr = "Variable"; // varStr is not a constant since not final
        String s2 = varStr + " is not pooled";

        String res2 = "Variable is not pooled";
        System.out.println(s2 == res2); // false

    }

    private static void stringCompareTo(){
        System.out.println("------------------- stringCompareTo ---------------------");

        String val1 = "abc";
        String val2 = "abc";
        String val3 = "aBc";
        String val4 = "zbd";
        String val5 = "abcd";

        System.out.println(val1.compareTo(val2)); // 0

        System.out.println(val1.compareTo(val3)); // 32

        System.out.println(val3.compareTo(val1)); // -32

        System.out.println(val1.compareTo(val4)); // -25
        System.out.println(val4.compareTo(val1)); // 25

        System.out.println(val1.compareTo(val5)); // -1
        System.out.println(val5.compareTo(val1)); // 1

    }

    private static void immutableTest(){
        System.out.println("------------------- immutableTest -----------------------");

        String var1 = "Test Case";
        String var2 = var1.substring(0,4);

        System.out.println(var1); // Test Case
        System.out.println(var2); // Test
    }

    private static void somePropertiesTest(){
        System.out.println("---------------------- somePropertiesTest -----------------");

        String name = new String("Hello March");
        System.out.println(name.length()); // 11

        String msg = "This is Pluto"; // "This is Pluto" is an object
        System.out.println(msg.length()); // 13
        System.out.println("This is Pluto".length()); // 13


    }

    private static void stringConstructorTest(){
        System.out.println("--------------------- constructorTest ---------------------");

        String name;

        name = new String(); // empty String
        System.out.println(name); //

        name = new String("Hello");
        System.out.println(name); // Hello

        char[] chars = {'1','2','3','4','a','b','d'};
        name = new String(chars);
        System.out.println(name); // 1234abd

        name = new String(chars,3,3); // start from index - 3 & take 3 characters from index-3
        System.out.println(name); // 4ab

    }


    private static void printWithLength(CharSequence cs){
        System.out.println(cs+" -> "+cs.length());
    }

    private static void charSequenceTest(){
        System.out.println("--------------------- charSequenceTest -----------------------");

        String name = new String("Hello S");
        printWithLength(name); // Hello S -> 7

        StringBuffer buffer = new StringBuffer("Buffer"); // will be discussed later
        printWithLength(buffer); // Buffer -> 6

        StringBuilder builder = new StringBuilder("Builder"); // will be discussed later
        printWithLength(builder); // Builder -> 7

    }


    private static void escapeTest(){
        System.out.println( "hello" ); // hello

        System.out.println( "he\nllo" );
        // he
        // llo

        System.out.println( "100%" ); // 100%
        System.out.println( "Said by \"Unknown\"" ); // Said by "Unknown"

        System.out.println("Apple"); // Apple
        System.out.println("\u0041pple"); // Apple

    }


}
