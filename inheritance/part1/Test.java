package inheritance.part1;

public class Test {

    public static void main(String[] args) {
        testUpcasting();
        testUpDownCasting();
        instanceOfTest();
    }

    static private void instanceOfTest(){
        System.out.println("--------------- instanceOfTest -------------------");

        Employee abulKalam = new Employee(1, "Abul Kalam", 50000);

        Employee employee = new Manager(2,"Employee",20034,10000);

        Manager manager;

        if(employee instanceof Manager){
            manager = (Manager) employee; // executed
        }
        else{
            System.out.println("Can't down-cast");
        }

        if(abulKalam instanceof Manager){
            manager = (Manager)abulKalam;
        }
        else{
            System.out.println("Can't down-cast"); // executed
        }
    }

    private static void testUpDownCasting(){
        System.out.println("--------------------- testUpDownCasting --------------------");
        Employee abulKalam = new Employee(1, "Abul Kalam", 50000);

        Employee employee = new Manager(2,"Employee",20034,10000);

        Manager atikurRahman = new Manager(1, "Atikur Rahman", 80000, 10000);

        Employee emp;
        emp = atikurRahman; // upCasting

        Manager manager;
        //manager = abulKalam; // compile error
        //manager = employee; // compile error

        //manager = (Manager)abulKalam; // runtime error

        manager = (Manager) employee; // fine - Down-casting <------------ (a)

    }

    private static void printName(Employee emp){
        System.out.println(emp.name);
    }

    private static void testUpcasting(){
        Employee employee = new Employee(1, "John Doe", 50000);

        Manager manager = new Manager(2, "Jane Foe", 70000, 10000);

        printName(employee); // John Doe
        printName(manager); // Jane Foe  <- --- --- upcasting

    }

}
