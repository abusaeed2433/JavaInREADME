package java17.part1;

import java.util.Map;

public class Test {

    public static void main(String[] args) {
        varTest();
        switchTest();
        instanceofTest();
        multilineString();
        recordTest();
    }

    private static void recordTest(){
        System.out.println("------------- recordTest -------------------------------------");

        Person person = new Person("Saeed",2345);

        PersonRecord record = new PersonRecord("Saeed",2345);

        System.out.println(person.getName() + " - " + record.name()); // Saeed - Saeed

        System.out.println(person.getAge() + " - " + record.age()); // 2345 - 2345

    }

    private static void multilineString(){
        System.out.println("------------------- multilineString --------------------------");

        String formattedTextEarlier = "This is first line.\n"+
                "THis is second line.\n"+
                "Continue like that";
        System.out.println(formattedTextEarlier);

        String formattedText = """
                This is first line.
                THis is second line.
                Continue like that""";
        System.out.println(formattedText);
        /*
        Output
        This is first line.
        THis is second line.
        Continue like that
        */

        //invalid
//        String formattedText2 = """This is first line. // this is invalid. You can write just after first """
//                THis is second line.
//                Continue like that""";

    }

    private static void instanceofTest(){
        System.out.println("------------- instanceofTest ---------------------------------");

        Student student = new PartTimeStudent(12,"Imran",5.5,12);

        PartTimeStudent partTimeStudent;
        if(student instanceof PartTimeStudent){
            partTimeStudent = (PartTimeStudent)student;
        }

        if(student instanceof PartTimeStudent partTimeStudent1){
            // partTimeStudent1
        }

    }

    private static void switchTest(){
        System.out.println("------------------------- switchTest -------------------------");

        int i = 20;
        switch (i){
            case 10 -> {
                System.out.println(10);
                System.out.println("10");
            }
            case 20-> System.out.println(20); // executed
            default-> System.out.println("Other");
        }

        i = 40;
        String message = switch (i){
            case 10 -> "10";
            case 20 -> "20";
            case 30 -> throw new RuntimeException("idk");
            case 40 ->{
                System.out.println("40"); // executed
                yield "like return";
            }
            default -> "none";
        };

        System.out.println(message); // like return

    }


    private static void varTest(){
        System.out.println("------------------- varTest -------------------------");
        var name = new String("hello");
        System.out.println(name); // hello

        var student = new Student(121,"Doniel",5.9);
        System.out.println(student.getName()); // Doniel
        System.out.println(student.getHeight()); // 5.9

    }

}
