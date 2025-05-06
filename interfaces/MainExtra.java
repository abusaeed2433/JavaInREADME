package interfaces;

import java.util.Random;

import interfaces.conflicts_not.Player;
import interfaces.conflicts_not.RunAndWalkable;
import interfaces.random_not.Child;
import interfaces.with_not.Bird;
import interfaces.with_not.Flyable;
import interfaces.with_not.Girl;
import interfaces.without_not.Animal;
import interfaces.without_not.Duck;
import interfaces.without_not.Person;
import interfaces.without_not.Walkable;

public class MainExtra {

    public static void main(String[] args) {
        //new Main().withoutInterface();
        //new Main().withoutInterface2();
        //new Main().withInterface();
        //new Main().interfaceConflict();
        new MainExtra().randomTest();

    }

    private void randomTest(){
        interfaces.conflicts_not.Walkable walkable = new Child(1);
        walkable.walk();


    }

    private void interfaceConflict(){

        interfaces.conflicts_not.Walkable walkable = new Player(1);

        walkable.walk(); // Player walking...

        RunAndWalkable able2 = new Player(2);
        System.out.println(able2.getStatus()); // 1

        //ignoring others assuming easy


        int val = new Random().nextInt(10);
        RunAndWalkable able;
        System.out.println(val);
        if(val % 2 == 0)
            able = new Player(3);
        else
            able = new Person(3);

        /*
            no compile time error since there is a possibility that Person/Player class may implement RunAndWalkable interface.
         */
        System.out.println( able instanceof Player );


        Duck duck = new Duck(1);
        // compile error since compile type of duck is Duck which isn't possible to be an instance of Player
       // System.out.println(duck instanceof Player);

    }

    private void withInterface(){
        Flyable[] flyables = new Flyable[5];

        flyables[0] = new Bird("Bird-1");
        flyables[1] = new Girl("Girl-1");
        flyables[2] = new Bird("Bird-2");
        flyables[3] = new Girl("Girl-2");
        flyables[4] = new Bird("Bird-3");

        Walkable.startFlying(flyables);

        /*
            Bird-1 is flying...
            Girl-1 is flying...
            Bird-2 is flying...
            Girl-2 is flying...
            Bird-3 is flying...
         */

    }

    private void withoutInterface2(){
        Animal[] animals = new Animal[5];

        animals[0] = new Person(0);
        animals[1] = new Duck(0);
        animals[2] = new Person(1);
        animals[3] = new Duck(1);
        animals[4] = new Person(2);

        Walkable.startWalking(animals);

        /*
            Person 0 is walking...
            Duck 0 is walking...
            Person 1 is walking...
            Duck 1 is walking...
            Person 2 is walking...
         */

    }

    private void withoutInterface(){
        Object[] objects = new Object[5];
        objects[0] = new Person(0);
        objects[1] = new Duck(0);
        objects[2] = new Person(1);
        objects[3] = new Duck(1);
        objects[4] = new Person(2);

        Walkable.startWalking(objects);

        /*
            Person 0 is walking...
            Duck 0 is walking...
            Person 1 is walking...
            Duck 1 is walking...
            Person 2 is walking.
         */

    }

}
