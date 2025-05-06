package interfaces.part5;

import java.util.ArrayList;

public class MarkerTest {

    public static void main(String[] args) {
        Human john = new Human("John");

        Cat tom = new Cat("Tom");
        Mouse jerry = new Mouse("Jerry");

        ArrayList<Object> list = new ArrayList<>();
        list.add(john);
        list.add(tom);
        list.add(jerry);
        countFunny(list); // 2 are funny
    }

    private static void countFunny(ArrayList<Object> list){
        int count = 0;
        for (Object fun : list){
            if(fun instanceof Funny) count++;
        }
        System.out.println(count+" are funny");
    }


}

interface Funny { // marker interface

}

class Human{
    String name;

    public Human(String name) {
        this.name = name;
    }
}

class Cat implements Funny {
    String name;

    public Cat(String name) {
        this.name = name;
    }
}

class Mouse implements Funny {
    String name;

    public Mouse(String name) {
        this.name = name;
    }
}
