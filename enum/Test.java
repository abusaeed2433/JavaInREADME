package r_Enum;

import java.sql.SQLSyntaxErrorException;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

import static r_Enum.MyWeekDay.*;
import static r_Enum.CommandList.*;


public class Test {

    public static void main(String[] args) {
        testGenderEnum();
        testMyWeekDayEnum();
        compareEnum();
        implementInterfaceInEnum();
        reverseLookUp();
        rangeLookUp();
    }

    private static void rangeLookUp(){
        System.out.println("---------------- rangeLookUp -------------");
        EnumSet<MyWeekDay> days = EnumSet.allOf(MyWeekDay.class);
        printArray(days.toArray()); // SATURDAY SUNDAY MONDAY TUESDAY WEDNESDAY THURSDAY FRIDAY

        EnumSet<MyWeekDay> workingDays = EnumSet.range(SUNDAY,THURSDAY);
        printArray(workingDays.toArray()); // SUNDAY MONDAY TUESDAY WEDNESDAY THURSDAY

        EnumSet<MyWeekDay> holidays = EnumSet.complementOf(workingDays);
        printArray(holidays.toArray()); // SATURDAY FRIDAY
    }

    private static void reverseLookUp(){
        System.out.println("----------------- reverseLookUp -----------------------");
        System.out.println(MyWeekDay.valueOf("SATURDAY")); // SATURDAY
        System.out.println(MyWeekDay.values()[0]); // SATURDAY

    }

    private static void implementInterfaceInEnum(){
        System.out.println("------------------ implementInterfaceInEnum ---------------");
        RUN.execute(); // Running
        JUMP.execute(); // Jumping
    }

    //nested enum
    public enum NestedEnum{
        MY_VALUE1,MY_VALUE2;
    }


    private static void compareEnum(){
        System.out.println(" ------------------- compareEnum ----------------");
        Gender gender1 = Gender.MALE;
        Gender gender2 = Gender.FEMALE;
        Gender gender3 = Gender.MALE;

        MyWeekDay day1 = SATURDAY;
        MyWeekDay day2 = MONDAY;
        MyWeekDay day3 = MONDAY;

        // compareTo
        System.out.println(gender1.compareTo(gender2)); // -1
        System.out.println(gender1.compareTo(gender3)); // 0

        // equals
        System.out.println(gender1.equals(day1)); // false
        System.out.println(day1.equals(day2)); // false
        System.out.println(day2.equals(day2)); // true

        // ==
        System.out.println(gender1 == gender3); // true
        System.out.println(day1 == day3); // false

    }

    private static void testMyWeekDayEnum(){
        // statically imported. So can be directly used by constant name
        System.out.println(SATURDAY.name());

        ArrayList<MyWeekDay> days = new ArrayList<>();
        days.add(SATURDAY);
        days.add(MONDAY);
        days.add(THURSDAY);

        System.out.println(countWorkingDays(days)); // 2

    }

    private static int countWorkingDays(List<MyWeekDay> days){
        int counter = 0;

        for(MyWeekDay day : days){
            if(day.isHoliday()) continue;

            counter++;
        }

        return counter;
    }

    private static void testGenderEnum(){

        System.out.println(Gender.MALE); // MALE
        System.out.println(Gender.FEMALE); // FEMALE
        System.out.println(Gender.OTHERS); // OTHERS

        System.out.println(Gender.MALE.name()); // MALE
        System.out.println(Gender.FEMALE.name()); // FEMALE
        System.out.println(Gender.OTHERS.name()); // OTHERS

        System.out.println(Gender.MALE.ordinal());   // 0
        System.out.println(Gender.FEMALE.ordinal()); // 1
        System.out.println(Gender.OTHERS.ordinal()); // 2

        Gender[] values = Gender.values();
        printArray(values); // MALE FEMALE OTHERS
    }

    private static<T> void printArray(T[] arr){
        for(T t : arr){
            System.out.print(t+" ");
        }
        System.out.println("");
    }

}
