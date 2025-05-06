package regex.part1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {

    public static void main(String[] args) {
        basicRegex();
        performRegexOperation1();
    }

    private static void performRegexOperation1(){
        System.out.println("--------------- compileRegex -------------------");

        String regex = "[ABO][+-]";
        Pattern pattern = Pattern.compile(regex);

        String input = "O+A+B+O-MNB-";
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()){
            String bg = matcher.group(); // or
            String sameBg = input.substring(matcher.start(),matcher.end());

            System.out.println(bg+" = "+sameBg);
        }

        /*
        output
        O+ = O+
        A+ = A+
        B+ = B+
        O- = O-
        B- = B-
         */

    }

    private static void basicRegex(){
        System.out.println("--------------- basicRegex --------------------");

        String regex = "[ABO][+-]";
        Pattern pattern = Pattern.compile(regex);

        String[] arr = {"A+","AB-","B-","O"};

        for(String bg : arr) {
            Matcher matcher = pattern.matcher(bg);

            if(matcher.matches()){ System.out.println(bg+" passed"); }
            else{ System.out.println(bg+" failed"); }

        }

        /*
         A+ passed
         AB- failed
         B- passed
         O failed
         */

    }

}
