package interfaces.part5;

public class InstanceOfTest {

    public static void main(String[] args) {
        Munificent john = new MunificentGiver();
        System.out.println(john instanceof Munificent); // true

        Giver giver = new Giver();
        System.out.println (giver instanceof Munificent); // false

        Giver kim = new StingyGiver();
        System.out.println(kim instanceof Munificent); // false

        StingyGiver jim = new StingyGiver();
        //System.out.println(jim instanceof Munificent);

        //compile time error. Right side(Munificent) is not assignment compatible to left side(StingyGiver)
        //How can the compiler be so sure about this possibility? It is easy.
        //You have declared the StingyGiver class as final, which means it cannot be subclassed. This implies that the variable jim
        //whose compile-time type is StingyGiver can only refer to an object whose class is StingyGiver. The compiler also
        //knows that the StingyGiver class and none of its ancestor classes implement the Munificent interface. With all these
        //reasoning, the compiler determines that you have a logical error in your program & you need to fix it


    }
}

interface Generous {
    void give();
}

interface Munificent extends Generous {
    void giveALot();
}

class Giver {}

class GenerousGiver extends Giver implements Generous {
    public void give() {
    }
}

class MunificentGiver extends Giver implements Munificent {
    public void give() {
    }
    public void giveALot() {
    }
}

final class StingyGiver extends Giver {
    public void giveALittle() {
    }
}

