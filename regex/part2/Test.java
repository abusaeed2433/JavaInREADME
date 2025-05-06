package regex.part2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {

    public static void main(String[] args) {

        backslashTest();
        quantityTest1();
        quantityTest2();

        boundaryMatcher1();
        boundaryMatcher1Manually();

        groupTest();
        groupTest2();
    }

    private static void groupTest2(){
        System.out.println("------------------- groupTest2 -----------------------------------");

        /*
            will find phone number,
            find code & number from that phone number,
            format the number & print
        */

        String phones = "+8801792101111, +8801234567890, +++8804324567890,+-+2101234";

        String regex = "(\\+\\d{3})(\\d+)\\b"; // \ is used before +, since + has special meaning
        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(phones);

        while (matcher.find()){
            String found = matcher.group(0); // or .group()

            String code = matcher.group(1);
            String num = matcher.group(2);

            System.out.println(code+" - "+num);
        }

        /*
        +880 - 1792101111
        +880 - 1234567890
        +880 - 4324567890
        +210 - 1234
        */

    }


    private static void groupTest(){
        System.out.println("------------------ groupTest -------------------------------------");

        String regex = "((AB)(CD))(XY)";
        String input = "ABCDXY";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        int total = matcher.groupCount();

        System.out.println(total);
        matcher.find();

        for(int i=0; i<=total; i++){
            System.out.println(matcher.group(i));
        }


    }

    private static void boundaryMatcher1Manually(){
        System.out.println("--------------------- boundaryMatcher1Manually -------------------");

        String input = "apple, I have an apple, and five pineapples & two more apple";

        String regex = "\\bapple\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()){
            System.out.println(matcher.group()+" from "+matcher.start()+" to "+matcher.end());
        }

        /*
        output
        apple from 0 to 5
        apple from 17 to 22
        apple from 55 to 60
         */

    }

    private static void boundaryMatcher1(){
        System.out.println("--------------------- boundaryMatcher1 -------------------");

        String input = "I have an apple and five pineapples";

        String regex = "\\bapple\\b"; // Use \\b to get \b inside the string literal
        String replacedWith = "orange";

        String output = input.replaceAll(regex,replacedWith);
        System.out.println(output); // I have an orange and five pineapples

    }


    private static void quantityTest2(){
        System.out.println("---------------------- quantityTest2 ---------------------");

        // Word containing small letter && contain single small 's' only once or not at all

        String regex = "[a-rt-z]*s?[a-rt-z]*";
        Pattern pattern = Pattern.compile(regex);

        String[] arr = {"amskn","sssla","substr","ms","s"};

        for(String str : arr){
            Matcher matcher = pattern.matcher(str);

            if(matcher.matches()){
                System.out.println(str+" -> passed");
            }
            else{
                System.out.println(str+" -> failed");
            }

        }
        /*
        amskn -> passed
        sssla -> failed
        substr -> failed
        ms -> passed
        s -> passed
         */
    }

    private static void quantityTest1(){
        System.out.println("------------------ quantityTest1 -------------------------");

        // matches the format `fName lName`, where fName at least 3 letter and lName 5 to 10 letters. Ex: Salim Shakib

        String regex = "[a-zA-Z]{3,} [A-Za-z]{5,10}";
        Pattern pattern = Pattern.compile(regex);

        String[] arr = {
                "Ibne Sina",
                "Shujoy Kundu",
                "Hasib Hasan Hasib Hasan",
                "Mahir Abrar",
                "gd n8"
        };

        for(String name : arr){
            Matcher matcher = pattern.matcher(name);
            if(matcher.matches()){
                System.out.println(name+" -> passed");
            }
            else{
                System.out.println(name+" -> failed");
            }
        }

        /*
        Ibne Sina -> failed
        Shujoy Kundu -> passed
        Hasib Hasan Hasib Hasan -> failed
        Mahir Abrar -> passed
        gd n8 -> failed
        */

    }

    private static void backslashTest(){
        System.out.println("-------------------- backslashTest ----------------------");

        //String regex = "\\[[0-9]\\]";
        String regex = "\\[[0-9]]"; // both are valid. ] itself don't have special meaning. So backslashes is optional

        Pattern pattern = Pattern.compile(regex);

        String[] arr = {"[0]","[1","[s]","2]","[5]","[O]"};

        for (String str : arr){
            Matcher matcher = pattern.matcher(str);
            if(matcher.find()){
                System.out.println(str+" -> passed");
            }
            else {
                System.out.println(str+" -> failed");
            }
        }

        /*
         Output:
         [0] -> passed
         [1 -> failed
         [s] -> failed
         2] -> failed
         [5] -> passed
         [O] -> failed. This capital 'O', not zero
         */

    }

}
