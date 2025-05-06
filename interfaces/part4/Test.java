package interfaces.part4;

public class Test {

    public static void main(String[] args) {
        conflictTest1();
        conflictTest2();
    }

    private static void conflictTest2(){
        System.out.println("------------------- conflictTest2 -------------------");
        new MyEvent().onClicked(); // click from event listener
    }

    private static void conflictTest1(){
        System.out.println("------------------- conflictTest1 -------------------");
        MultipleClick mc = new MultipleClick();
        mc.onClicked(); //Calling from click detector
    }

}
