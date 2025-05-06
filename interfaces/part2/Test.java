package interfaces.part2;

public class Test {

    public static void main(String[] args) {
        testConstantField();
        staticMethodTest();
        defaultMethodTest();
        nestedClassTest(); // Nothing
    }

    private static void nestedClassTest(){
        System.out.println("------------- nestedClassTest --------------------");
        Job.EMPTY_JOB.runJob();
    }

    private static void defaultMethodTest(){
        System.out.println("------------- defaultMethodTest --------------------");
        Clickable myItem = new MyItem();
        myItem.requestSingleClick(); // Single click
    }

    private static void staticMethodTest(){
        System.out.println("------------- staticMethodTest --------------------");
        Clickable.printConstant();

        Clickable c = new MyItem();
        //c.printConstant(); // error
    }

    private static void testConstantField(){
        System.out.println("------------- testConstantField --------------------");
        System.out.println(Clickable.SINGLE_CLICK); // 1

        System.out.println(Clickable.DOUBLE_CLICK_INTERVAL); // 500

        //Clickable.DOUBLE_CLICK = 10; // error since implicitly final

    }

}
