package interfaces.part5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        instanceOfTest(); // giver is an object
        comparableTest();

        comparatorTest1();
        comparatorTestSimplified();
        comparatorMultiple();
        comparatorMultipleMinimized();
    }

    private static void comparatorMultipleMinimized(){
        System.out.println("--------------- comparatorMultipleMinimized --------------------");

        List<Student> list = getStudentList();
        List<Student> list2 = getStudentList();

        printNames(list);
        // Rakib Hasan, Sadia Akter, Ariful Islam, Tasnim Akhter, Rafi Ahmed, Sumaiya Khatun, Sumaiya Akter,


        list2.sort((o1, o2) -> o1.getFirstName().compareTo(o2.getFirstName()));
        printNames(list2);
        // Ariful Islam, Rafi Ahmed, Rakib Hasan, Sadia Akter, Sumaiya Khatun, Sumaiya Akter, Tasnim Akhter,


        list.sort(Comparator.comparing(Student::getFirstName).thenComparing(Student::getLastName));
        printNames(list);
        // Ariful Islam, Rafi Ahmed, Rakib Hasan, Sadia Akter, Sumaiya Akter, Sumaiya Khatun, Tasnim Akhter,

    }

    private static void comparatorMultiple(){
        System.out.println("--------------- comparatorMultiple --------------------");

        List<Student> list = getStudentList();
        List<Student> list2 = getStudentList();

        Comparator<Student> firstNameComparator = new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getFirstName().compareTo(o2.getFirstName());
            }
        };

        Comparator<Student> lastNameComparator = new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getLastName().compareTo(o2.getLastName());
            }
        };

        printNames(list);
        // Rakib Hasan, Sadia Akter, Ariful Islam, Tasnim Akhter, Rafi Ahmed, Sumaiya Khatun, Sumaiya Akter,


        list2.sort(firstNameComparator);
        printNames(list2);
        // Ariful Islam, Rafi Ahmed, Rakib Hasan, Sadia Akter, Sumaiya Khatun, Sumaiya Akter, Tasnim Akhter,

        list.sort(firstNameComparator.thenComparing(lastNameComparator));
        printNames(list);
        // Ariful Islam, Rafi Ahmed, Rakib Hasan, Sadia Akter, Sumaiya Akter, Sumaiya Khatun, Tasnim Akhter,

    }

    private static void comparatorTestSimplified(){
        System.out.println("----------------- comparatorTestSimplified --------------");


        List<Student> list = getStudentList();

        printNames(list);
        // Rakib Hasan, Sadia Akter, Ariful Islam, Tasnim Akhter, Rafi Ahmed, Sumaiya Khatun, Sumaiya Akter,

        // list.sort(Comparator.comparing(Student::getFirstName)); // also valid

        list.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getFirstName().compareTo(o2.getFirstName());
            }
        });

        printNames(list); // sorted by first name
        // Ariful Islam, Rafi Ahmed, Rakib Hasan, Sadia Akter, Sumaiya Khatun, Sumaiya Akter, Tasnim Akhter,

    }

    private static void comparatorTest1(){
        System.out.println("----------------- comparatorTest1 --------------");

        List<Student> list = getStudentList();

        class FirstNameComparator implements Comparator<Student>{
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getFirstName().compareTo(o2.getFirstName());
            }
        };

        FirstNameComparator comparator = new FirstNameComparator();

        printNames(list);
        // Rakib Hasan, Sadia Akter, Ariful Islam, Tasnim Akhter, Rafi Ahmed, Sumaiya Khatun, Sumaiya Akter,

        Collections.sort(list,comparator);

        printNames(list); // sorted by first name
        // Ariful Islam, Rafi Ahmed, Rakib Hasan, Sadia Akter, Sumaiya Khatun, Sumaiya Akter, Tasnim Akhter,

    }

    private static void printNames(List<Student> list){
        for(Student std : list){
            System.out.print(std.getName()+", ");
        }
        System.out.println("");
    }

    private static List<Student> getStudentList(){
        Student student1 = new Student(112, "Rakib Hasan", "rakibhasan@gmail.com", 1.75);
        Student student2 = new Student(23, "Sadia Akter", "sadiaakter@gmail.com", 1.65);
        Student student3 = new Student(34, "Ariful Islam", "arifulislam@gmail.com", 1.80);
        Student student4 = new Student(4, "Tasnim Akhter", "tasnimakhter@gmail.com", 1.55);
        Student student5 = new Student(54, "Rafi Ahmed", "rafi@gmail.com", 1.70);
        Student student6 = new Student(15, "Sumaiya Khatun", "sumaiya@gmail.com", 1.60);
        Student student7 = new Student(18, "Sumaiya Akter", "sumaiya@gmail.com", 1.60);

        List<Student> list = new ArrayList<>();
        list.add(student1); list.add(student2); list.add(student3);
        list.add(student4); list.add(student5); list.add(student6); list.add(student7);
        return list;
    }

    private static void comparableTest(){
        System.out.println("--------------------- comparableTest -----------------");

        // using Bard
        Student student1 = new Student(112, "Rakib Hasan", "rakibhasan@gmail.com", 1.75);
        Student student2 = new Student(23, "Sadia Akter", "sadiaakter@gmail.com", 1.65);
        Student student3 = new Student(34, "Ariful Islam", "arifulislam@gmail.com", 1.80);
        Student student4 = new Student(4, "Tasnim Akhter", "tasnimakhter@gmail.com", 1.55);
        Student student5 = new Student(54, "Rafi Ahmed", "rafi@gmail.com", 1.70);
        Student student6 = new Student(15, "Sumaiya Khatun", "sumaiya@gmail.com", 1.60);

        List<Student> students = new ArrayList<>();
        students.add(student1); students.add(student2); students.add(student3);
        students.add(student4); students.add(student5); students.add(student6);

        printRolls(students); // Rakib(112) Sadia(23) Ariful(34) Tasnim(4) Rafi(54) Sumaiya(15)
        Collections.sort(students);
        printRolls(students); // Tasnim(4) Sumaiya(15) Sadia(23) Ariful(34) Rafi(54) Rakib(112)
    }

    private static void printRolls(List<Student> list){
        for(Student std : list){
            System.out.print(std.getFirstName()+"("+std.getRoll()+") ");
        }
        System.out.println("");
    }

    private static void instanceOfTest(){
        System.out.println("----------------------- instanceOfTest ------------------");
        Giver giver = new Giver();
        if(giver instanceof Object){
            System.out.println("giver is an object");
        }
        else{
            System.out.println("giver is not an object");
        }
    }

}
