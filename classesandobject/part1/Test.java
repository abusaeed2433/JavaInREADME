package classesandobject.part1;

public class Test {

    public static void main(String[] args) {

        //creating object
        Hooman saeed = new Hooman("Saeed",21);
        System.out.println(saeed.isAdult()); // true

        // null
        String name = null;
        Integer number = null;
        Hooman none = null;
        //int count = null; //compile time error
        //none.getAge(); // runtime exception

        Hooman sh = new Hooman("sh",22);
        sh = null;


        Hooman anik = new Hooman("Anik",22);
        anik.showSpecificCharacter(); // Name is => Anik

        anik.showSomeCharacter(); // General characteristics. ok but not recommended
        Hooman.showSomeCharacter(); // General characteristics. best practice

        birdTest();
    }

    private static void birdTest(){
        Bird deadBird = new Bird(); // 1
        deadBird.printDetails(); // Unknown -> Not found -> false

        Bird unknownBird = new Bird(true); // 2
        unknownBird.printDetails(); // unknown -> Not found -> true

        Bird eagle = new Bird("Eagle", "Eagle", true); // 3
        eagle.printDetails(); // Eagle -> Eagle -> true

        Bird secondEagle = new Bird(eagle); // 4
        secondEagle.printDetails(); // Eagle -> Eagle -> true
    }

    public int add(int num1, int num2){
        return num1+num2;
    }

}
