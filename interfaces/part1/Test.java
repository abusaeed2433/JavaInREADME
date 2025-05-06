package interfaces.part1;

import java.lang.reflect.Method;

public class Test {

    public static void main(String[] args) {
        intro();
        solution1();
        solution2();
        idealSolution();
    }

    private static void idealSolution(){
        System.out.println("--------------- idealSolution --------------");
        Walkable[] arr = new Walkable[4];
        arr[0] = new Person2("Abu");
        arr[1] = new Person2("Saeed");
        arr[2] = new Person2("John");

        arr[3] = new Duck2("duck1");
        letAllWalkTogether(arr);
    }

    private static void letAllWalkTogether(Walkable[] arr){
        for(Walkable obj : arr){
            obj.walk();
        }
    }

    private static void letDuckWalk(Duck[] list){
        for(Duck duck : list) {
            if(duck == null) continue;
            duck.walk();
        }
    }

    private static void letPersonWalk(Person[] list){
        for(Person person : list) {
            if(person == null) continue;
            person.walk();
        }
    }

    private static void solution2(){
        Person[] persons = new Person[3];
        persons[0] = new Person("Jack");
        persons[1] = new Person("Jeff");
        persons[2] = new Person("John");
        letPersonWalk(persons);

        Duck[] ducks = new Duck[3];
        ducks[0] = new Duck("Ab");
        ducks[1] = new Duck("Bc");
        ducks[2] = new Duck("Ka");
        letDuckWalk(ducks);
    }

    private static Method getWalkMethod(Object obj) {
        Class c = obj.getClass();
        Method walkMethod = null;
        try {
            walkMethod = c.getMethod("walk");
            return walkMethod;
        }
        catch (NoSuchMethodException e) {
            // walk() method does not exist
        }
        return null;
    }

    private static void letThemWalkUpdated(Object[] list){
        for(Object  obj : list) {
            Method walkMethod = getWalkMethod(obj); // getting method reference
            if (walkMethod != null) {
                try {
                    walkMethod.invoke(obj); // calling walk method on the obj
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void solution1(){
        System.out.println("---------------- solution1 -------------------");
        Object[] objects = new Object[4];
        objects[0] = new Person("Jack");
        objects[1] = new Person("Jeff");
        objects[2] = new Person("John");
        objects[3] = new Duck("Duck1");
        letThemWalkUpdated(objects);
    }


    private static void letThemWalk(Person[] list){
        for(Person person : list) {
            if(person == null) continue;
            person.walk();
        }
    }

    private static void intro(){
        Person[] persons = new Person[4];
        persons[0] = new Person("Jack");
        persons[1] = new Person("Jeff");
        persons[2] = new Person("John");
        //persons[3] = new Duck("Duck1"); // compile time error
        letThemWalk(persons);
    }

}
