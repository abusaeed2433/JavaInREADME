package string.part2;

import java.text.Collator;
import java.util.Arrays;
import java.util.Locale;

public class Test {

    public static void main(String[] args) {

        testFewOperations();

        testSwitchExpression();

        stringBuilderTest();
        stringBufferTest();
        concatenateTest();

        dictCompare();
    }

    private static void dictCompare(){
        System.out.println("----------------------- dictCompare -----------------------");

        String str1 = "abc";
        String str2 = "bcd";
        String str3 = "Bcd";

        Collator collator = Collator.getInstance(Locale.US);

        int res;

        res = collator.compare(str1,str2);
        System.out.println(res); // -1 since abc is before bcd

        res = collator.compare(str2,str1);
        System.out.println(res); // 1 since bcd is after abc

        res = collator.compare(str2,str3);
        System.out.println(res); // -1 since bcd is before Bcd

    }

    private static void concatenateTest(){
        System.out.println("------------------ concatenateTest ------------------------");
        int num = 5;

        String total = "This ";
        total += "is ";
        total += String.valueOf(num);

        System.out.println(total); // This is 5

        // better approach since multiple objects are not created
        StringBuilder builder = new StringBuilder();
        builder.append("This ").append("is ").append(num);
        System.out.println(builder); // This is 5
    }

    private static void stringBufferTest(){
        System.out.println("------------------- stringBufferTest ----------------------");

        StringBuffer buffer = new StringBuffer();
        buffer.append("This is buffer-").append(5).append(". ");

        String phone = "0179210xxxx";

        buffer.append("His phone number is: ").append(phone).append(", Bg:").append('O');

        System.out.println(buffer); // This is buffer-5. His phone number is: 0179210xxxx, Bg:O

        buffer.insert(0,"Hello, ");
        System.out.println(buffer); // Hello, This is buffer-5. His phone number is: 0179210xxxx, Bg:O

        buffer.delete(0,7);
        System.out.println(buffer); // This is buffer-5. His phone number is: 0179210xxxx, Bg:O

        buffer.reverse();
        System.out.println(buffer); // O:gB ,xxxx0129710 :si rebmun enohp siH .5-redliub si sihT

        // palindrome check
        String toCheck = "Step on no pets";

        StringBuffer b1 = new StringBuffer(toCheck).reverse();
        System.out.println(toCheck.equalsIgnoreCase(b1.toString())); // true

    }

    private static void stringBuilderTest(){
        System.out.println("------------------- stringBuilderTest ----------------------");

        StringBuilder builder = new StringBuilder();
        builder.append("This is builder-").append(5).append(". ");

        String phone = "0179210xxxx";

        builder.append("His phone number is: ").append(phone).append(", Bg:").append('O');

        System.out.println(builder); // This is builder-5. His phone number is: 0179210xxxx, Bg:O

        builder.insert(0,"Hello, ");
        System.out.println(builder); // Hello, This is builder-5. His phone number is: 0179210xxxx, Bg:O

        builder.delete(0,7);
        System.out.println(builder); // This is builder-5. His phone number is: 0179210xxxx, Bg:O

        builder.reverse();
        System.out.println(builder); // O:gB ,xxxx0129710 :si rebmun enohp siH .5-redliub si sihT

        // palindrome check
        String toCheck = "Step on no pets";

        StringBuilder b1 = new StringBuilder(toCheck).reverse();
        System.out.println(toCheck.equalsIgnoreCase(b1.toString())); // true

    }

    private static void testSwitchExpression(){
        System.out.println("----------------- testSwitchExpression -----------------");


        String status = "on";

        switch (status){ // status mustn't be null
            case "on":
                System.out.println("on"); //executed
                break;
            case "off": // check if status.equals("off")
                System.out.println("off");
                break;
        }

    }

    private static void testFewOperations(){
        String str = "I can write poems";

        // str.charAt(int i) return character at position i, Runtime error if i is invalid
        System.out.println( str.charAt(2) ); // c

        // str1.equals(str2) or str1.equalsIgnoreCase(str2)
        String str1 = "Hello";
        String str2 = "hello";

        System.out.println( str1.equals(str2) ); // false
        System.out.println( str1.equalsIgnoreCase(str2) ); // true

        System.out.println("--------------------------- ");
        // empty check
        String name = "";

        System.out.println( name.isEmpty() ); // true
        System.out.println( name.equals("") ); // true
        System.out.println( name.length()==0 ); // true

        System.out.println("--------------------------- ");
        // changing case - new object is created. Remember, String is immutable

        String mix = "Process FINISHED";
        System.out.println( mix.toUpperCase() ); // PROCESS FINISHED
        System.out.println( mix.toLowerCase() ); // process finished

        System.out.println("--------------------------- ");

        String msg = "You are welcome";
        System.out.println( msg.indexOf('o') ); // 1 - first o
        System.out.println( msg.indexOf('x') ); // -1
        System.out.println( msg.indexOf("are") ); // 4

        System.out.println( msg.lastIndexOf('o') ); // 12

        System.out.println("--------------------------- ");

        // Representing value into String
        String strInt = String.valueOf(1000);
        System.out.println(strInt); // 10000

        String strDou = String.valueOf(200.5d);
        System.out.println(strDou); // 200.5

        String strBoo = String.valueOf(true);
        System.out.println(strBoo); // true

        System.out.println("--------------------------- ");

        // substring(startIndex) or substring(startIndex,lastIndex) = startIndex = before lastIndex

        String total = "Rahim Karim Tamim";

        String rahim = total.substring(0,5);
        System.out.println(rahim); // Rahim

        String karim = total.substring(6,11);
        System.out.println(karim); // Karim

        // str.trim() remove all leading and trailing whitespaces and control characters from a string

        String code = " \n hello pluto \t ";
        System.out.println( code.trim() ); // hello pluto


        System.out.println("-----------------------------------");
        // replace(old,new)

        String greeting = "Hello old man, Hello";
        System.out.println( greeting.replace("Hello","Hi") ); // Hi old man, Hi
        System.out.println( greeting.replaceAll("Hello","Hi") ); // Hi old man, Hi
        // in replaceAll regex(will discuss later insha'Allah) can be used.

        System.out.println("-----------------------------------");
        // Matching Start and End of a String
        String eq = "20 + 22 = 42";
        System.out.println( eq.startsWith("2")); // true
        System.out.println( eq.endsWith("42")); // true

        System.out.println("-----------------------------------");

        // splitting and joining string
        String strVowels = "a,e,i,o,u";
        String[] vowels = strVowels.split(","); //split(regex)
        System.out.println(Arrays.toString(vowels)); // [a, e, i, o, u]

        System.out.println("-----------------------------------");

        String joined = String.join(",","A","E","I","O","U"); // 1st one is separator
        System.out.println(joined); // A,E,I,O,U

        System.out.println("-----------------------------------");



    }

}
