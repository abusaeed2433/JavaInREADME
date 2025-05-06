package regex.part3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {

    public static void main(String[] args) {

        groupNameTest();
        resetTest();
        solution();
    }

    private static void solution(){
        System.out.println("------------------------ solution ------------------------");

        String input = "A train carrying 125 men and women was traveling at the speed of 100 miles per hour. "+
                "The train fare was 75 dollars per person.";

        String regex = "\\b\\d+\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        StringBuilder output = new StringBuilder();

        while (matcher.find()){
            String text = matcher.group();
            int num = Integer.parseInt(text);

            String replaceWith;

            if(num == 100) replaceWith = "a hundred";
            else if(num < 100) replaceWith = "less than a hundred";
            else replaceWith = "more than a hundred";

            matcher.appendReplacement(output,replaceWith);

            //System.out.println(num);

        }

        matcher.appendTail(output); // rest of the part

        System.out.println(output);

    }

    private static void resetTest(){
        System.out.println("---------------------- resetTest ---------------------------");
        String[] arr = {"+8801792101111", "+8801234567890", "+8804324567890","+2101234"};

        String regex = "(?<code>\\+\\d{3})(?<num>\\d+)\\b";
        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(""); // dummy

        for(String phone : arr){
            matcher.reset(phone);

            matcher.find();

            String code = matcher.group("code");
            String num = matcher.group("num");
            System.out.println(code+" - "+num);
        }

        /*
        Output
        +880 - 1792101111
        +880 - 1234567890
        +880 - 4324567890
        +210 - 1234
        */
    }

    private static void groupNameTest(){
        System.out.println("------------------- groupNameTest -----------------------------------");

        /*
            will find phone number,
            find code & number from that phone number,
            format the number & print
        */

        String phones = "+8801792101111, +8801234567890, +++8804324567890,+-+2101234";

        String regex = "(?<code>\\+\\d{3})(?<num>\\d+)\\b"; // \ is used before +, since + has special meaning
        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(phones);

        while (matcher.find()){
            String code = matcher.group("code");
            String num = matcher.group("num");

            System.out.println(code+" - "+num);
        }

        /*
        +880 - 1792101111
        +880 - 1234567890
        +880 - 4324567890
        +210 - 1234
        */

    }

}
