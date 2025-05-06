package classesandobject.part3;

public class Test {

    public static void main(String[] args) {

        Student hasib = new Student(6,"Hasib",21);
        printInfo(hasib);
        System.out.println(hasib.getName()); // Hasib

        Student imran = new Student(12,"Imran",21);
        printInfoAdvanced(imran);
        System.out.println(imran.getName()); // Prottoy

    }

    private static void printInfo(Student student){
        System.out.println(student.getRoll()); // 6
        System.out.println(student.getName()); // Hasib
        System.out.println(student.getAge()); // 21

        // actual data won't be changed. Remember, lvalue is copied but both point to same object
        student = new Student(18,"Rifat",23); // will make lvalue to point different object. But won't affect actual data

    }

    private static void printInfoAdvanced(Student student){
        System.out.println(student.getRoll()); // 12
        System.out.println(student.getName()); // Imran
        System.out.println(student.getAge()); // 21

        student.setRoll(25);
        student.setName("Prottoy");
        student.setAge(21);

        // above 3 lines change the properties of the object to which student is pointing. This is changing the properties of object, so affect actual data
    }

}
