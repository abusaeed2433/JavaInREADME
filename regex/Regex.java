package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {

    public static void main(String[] args) {
        //new Regex().containTest();
        //new Regex().exactMatch();
        //new Regex().escapeTest();
        //new Regex().testEmailValidity();
        //new Regex().countryCodeFromPhone();
        new Regex().replaceNumberWithText();
    }

    private void replaceNumberWithText(){
        String src = "A train carrying 125 men and women was traveling at the speed of 100 miles per hour.\n" +
                "The train fare was 75 dollars per person. Train code is train247.";

        String regex = "\\b\\d+\\b";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(src);

        StringBuilder builder = new StringBuilder();

        while(matcher.find()){

            String txt = matcher.group();
            int num = Integer.parseInt(txt);

            String tmp;

            if(num < 100)
                tmp = "less than one hundred";
            else if(num == 100)
                tmp = "one hundred";
            else
                tmp = "more than one hundred";

            matcher.appendReplacement(builder,tmp);
        }

        matcher.appendTail(builder);

        System.out.println(builder);

        /*
            A train carrying more than one hundred men and women was traveling at the speed of one hundred miles per hour.
            The train fare was less than one hundred dollars per person. Train code is train247.
         */

    }

    private void countryCodeFromPhone(){
        String phone = "+8801792106800";

        String regex = "\\B\\+(\\d{3})\\d{10}\\b"; // capital B must, won't work if small b is used. (\\d{3}) is group-1, whole string is group-0

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phone);

        if(matcher.find()){
            System.out.println(matcher.group(1)); // 880
        }
        else{
            System.out.println("Invalid phone");
        }

    }

    private void testEmailValidity(){
        String email = "abusaeed2433@gmail.com, test@email.#net abu@yahoo.net";

        String regex = "\\w+@\\w+\\.\\w+"; // \w = [a-zA-Z_0-9]

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);

        int count = 0;
        while (matcher.find()){
            System.out.println(matcher.group());
            count++;
        }
        System.out.println(count+ " emails found");

        /*
            abusaeed2433@gmail.com
            abu@yahoo.net
            2 emails found
         */

    }

    private void escapeTest(){

        String str = "Be confident bro. [I can]. Just believe I can"; // will find [I can]

        String regex = "[I can]"; // interpreted as regex = I can . so will match single character I, , c, a, n

        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(str);

        while(matcher.find()){
            System.out.println(matcher.group());
        }

        regex = "\\[I can\\]"; // also working without last \\

        pattern = Pattern.compile(regex);
        matcher = pattern.matcher(str);

        while(matcher.find()){
            System.out.println(matcher.group());
        }
        /*
            [I can]
         */
    }

    private void exactMatch(){
        String src = "abu@gmail.com";

        String pattern = "[a-z][a-z][a-z]@gmail\\.com"; // \\ can be removed also

        System.out.println( src.matches(pattern) ); // true

        System.out.println( "a@b".matches("\\w@\\w") ); // true

        System.out.println( "abc".matches("\\w@\\w") ); // false

    }

    private void containTest(){
        String str = "Be confident bro. [I can]. Just believe I can";

        String regex = "I can";
        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(str);

        while(matcher.find()){
            String txt = matcher.group();
            System.out.println(txt);
        }

        /*
         * I can
         * I can
         */
    }

}
