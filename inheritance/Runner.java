package inheritance;

public class Runner {

    public static void main(String[] args) {

        Child child = new Child("Jack","Serial killer");

        child.print(); // Jack Serial killer

        ((Parent)child).print(); // Jack Serial killer without static

        ((Parent)child).print(); //Static name with static

        Parent parent = new Parent("Jack");
       // ((Child) parent).print(); // compile error as expected


        parent = child;
        ((Child) parent).print(); // Static name and type

        // field hiding
        System.out.println( parent.isArrested() ); // true
        System.out.println( child.isArrested() ); // true
        System.out.println( child.isArrested() ); // true

    }

}
