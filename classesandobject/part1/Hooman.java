package classesandobject.part1;

public class Hooman {

    // Field - 2 Class variables
    public static final String SPECIES;
    private static int objectCounter = 0; // can also be written inside static{}

    // Field - 3 instance variables
    private String name;
    private int age;
    private boolean isAdult;

    //static initializers
    static {
        System.out.println("static initializers");
        SPECIES = "Homo Sapiens"; // normally other calculation is performed. This is simple example
    }

    //instance initializers
    {
        System.out.println("instance initializer");
        isAdult = false; // by default false though
    }


    //constructor 1
    public Hooman() {
        System.out.println("Constructor-1");
        objectCounter++;
    }

    //constructor 2
    public Hooman(String name, int age) {
        System.out.println("Constructor-2");
        this.name = name;
        this.age = age;
        isAdult = age >= 18;
        objectCounter++;
    }

    // all methods are shown below
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(age < 0 || age < this.age) return;

        this.age = age;
        isAdult = (age>=18);
    }

    public boolean isAdult() {
        return isAdult;
    }

    public static int getObjectCounter() {
        return objectCounter;
    }

    public static void showSomeCharacter(){
        System.out.println("General characteristics");
        //System.out.println(name);//can't access name here
    }

    public void showSpecificCharacter(){
        System.out.println("Name is => "+name);
    }

}
