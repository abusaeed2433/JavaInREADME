package string;

import java.text.Collator;
import java.util.Locale;

public class Test {

    public Test(){

    }

    public static void main(String[] args) {
        //new Test().startTest();
        //new Test().dictCompare();
        //new Test().random();
    }

    private void random(){
        String s1 = "Hello".concat(" World");
        String s2 = "Hello World";
        String s3 = new String("Hello World");
        String s31 = new String("Hello World");
        String s4 = "Hello World";

        System.out.println(s1 == s2); // false
        System.out.println(s2 == s3); // false
        System.out.println(s3 == s31); // false
        System.out.println(s2 == s4); // true

    }

    private void startTest(){


        StringBuffer obj1 = new StringBuffer("The");
        StringBuffer obj2 = new StringBuffer("Name");

        System.out.println(obj1);
        System.out.println(obj2);

        StringBuffer obj = obj1;
        obj.append("Full");

        System.out.println(obj);
        System.out.println(obj1);

        System.out.println(obj==obj1);
        //mutable class above


        System.out.println(" -- -- -- - - - ");
        String str1 = new String("The");
        String str2 = new String("Name");

        System.out.println(str1);
        System.out.println(str2);

        String str = str1;
        str += "Full";
        System.out.println(str);
        System.out.println(str1);
        System.out.println(str==str1);
        //immutable completed



        System.out.println(" -- - - - -- - - - ");



        String val1 = "Abc", val2 = "Abc"; //
        // val1, val2 are just reference variable
        // when we write val1 = "Abc" two objects are created, one is char[] and another is string object itself and
        // the reference of this string object is assigned to val1
        // now for val2 = "Abc", it just uses the previously created string object. so same string object and char[] are reused
        // whenever we write "Abc", it uses the same string object that is previously created

        System.out.println(System.identityHashCode(val1));
        System.out.println(System.identityHashCode(val2));
        //1828972342 - 1828972342

        String val3 = "Abc";
        String val4 = new String("Abc");
        System.out.println(System.identityHashCode(val3));
        System.out.println(System.identityHashCode(val4));
        //1828972342 - 1452126962

        // As you can see val3 is referencing same object as val1 and val2; But
        // val4 is not same, because when we write new String("Abc"),
        // "Abc" (2 objects) will be created, since it already exists, so won't be created anymore, so interpreted as
        // new String(prevObj), it will create a new String object, but uses the same char[] as val1,val2,val3
        // Just String object is different but char[] is same for all

        System.out.println(" -- - - --  -- ");
        String val5 = "Abc";
        String val6 = "AAbc".substring(1); // "Abc" but "AAbc" is created then substring is called, so
        // val5, val6 uses to different char[] even though they are same after calling substring(1)

        System.out.println(System.identityHashCode(val5));
        System.out.println(System.identityHashCode(val6));
        //1828972342 - 931919113

        val6 = val6.intern();
        //When the intern method is invoked,
        // if the pool already contains a string equal to this String object as determined by the equals(Object) method,
        // then the string from the pool is returned.

        System.out.println(System.identityHashCode(val5));
        System.out.println(System.identityHashCode(val6));
        //1828972342 - 1828972342

        System.out.println(" -- -- - - -- ");
        String val7 = "Abc";
        String val8 = "Abc".substring(1);
        System.out.println(System.identityHashCode(val7));
        System.out.println(System.identityHashCode(val8));
        //1828972342 - 1607521710
        // different because substring(-) return new String("---") and new String() create new String object using same char[] if found


        String tmp = new String("Abc");
        String tmp2 = new String("Abc");

        //764977973 - 381259350
        tmp = tmp.intern();
        System.out.println(System.identityHashCode(tmp)); // 1828972342 - 764977973
        tmp2 = tmp2.intern();
        System.out.println(System.identityHashCode(tmp2)); // 1828972342 - 1828972342


        System.out.println(" - -- - -  -- - - ");

        final String s1 = "Sae";
        String s2 = s1+"ed";
        String s3 = "Saeed";
        System.out.println(s2==s3); // true, but

        String s4 = "Idi";
        String s5 = s4+"ot";
        String s6 = "Idiot";
        System.out.println(s5==s6); // false, because s4 is not constant/final, and it may be changed later by program somehow, i.e.
        // s5 is not inserted into string pool

    }

    private void dictCompare(){

        System.out.println(" - -- - - compare starts - -- - - -");

        Locale locale = new Locale("en","US");

        Collator collator = Collator.getInstance(locale);
        //Collator collator = Collator.getInstance(); // working same

        String val1 = "ABC", val2 = "abc";
        int diff = collator.compare(val1,val2);
        printState(val1,val2,diff); // ABC is after abc

        val1 = "ABC"; val2 = "bbc"; diff = collator.compare(val1,val2);
        printState(val1,val2,diff); // ABC is before bbc

        val1 = "bbc"; val2 = "bbc"; diff = collator.compare(val1,val2);
        printState(val1,val2,diff); // Same

        val1 = "cat"; val2 = "Dog"; diff = collator.compare(val1,val2);
        printState(val1,val2,diff); // Same

        diff = val1.compareTo(val2);
        printState(val1,val2,diff); // cat is after Dog


    }

    private void printState(String s1, String s2,int diff){
        if(diff < 0){
            System.out.println(s1 +" is before "+s2);
        }
        else if(diff > 0){
            System.out.println(s1 +" is after "+s2);
        }
        else{
            System.out.println("Same");
        }
    }

}
