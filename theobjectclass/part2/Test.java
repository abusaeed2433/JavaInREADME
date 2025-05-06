package theobjectclass.part2;

public class Test {


    public static void main(String[] args) {

        cloneTest();
        cloneTest2();
        finalizeTest();

        immutableTest();
    }

    private static void immutableTest(){
        System.out.println("---------------- immutableTest -----------------");
        Cat cat = new Cat("Oscar");
        System.out.println(cat.getName()); // Oscar

        cat.setName("Billi"); // state changed
        System.out.println(cat.getName()); // Billi
    }

    private static void finalizeTest(){
        System.out.println("------------------ finalizeTest ---------------");

        int MAX = 20;
        Cat[] cats = new Cat[MAX];
        for(int i=0; i<MAX; i++) cats[i] = new Cat(i+"");

        for(int i=0; i<MAX; i++) {
            cats[i] = null;
        }
    }

    private static void cloneTest2(){
        System.out.println("-------------------- cloneTest2 ---------------");

        Human tomal = new Human("Tomal","Loki");

        System.out.println(tomal); // owner: Tomal, catName: Loki

        Human copied = (Human) tomal.clone();

        System.out.println(copied); // owner: Tomal, catName: Loki

        copied.setName("Totomal");
        System.out.println(tomal); // owner: Tomal, catName: Loki
        System.out.println(copied); // owner: Totomal, catName: Loki

        copied.setCatName("kilo");
        System.out.println(tomal); // owner: Tomal, catName: kilo <--------------------
        System.out.println(copied);// owner: Totomal, catName: kilo <-------------------

    }

    private static void cloneTest(){
        System.out.println("-------------------- cloneTest ---------------");

        Student who = new Student(269,"who",23,173);

        System.out.println(who); // roll: 269, name: who, age: 23, height: 173.0

        Student copied = (Student) who.clone();

        System.out.println(copied); // roll: 269, name: who, age: 23, height: 173.0

        copied.setAge(30);
        System.out.println(copied); // roll: 269, name: who, age: 30, height: 173.0
        System.out.println(who); // roll: 269, name: who, age: 23, height: 173.0
    }

}
