package interfaces.part3;

public class Test {

    public static void main(String[] args) {
        testReferenceType();
        testOperationOnVariable();
        variableTest();
        methodOverriding();
        subSuperTest();
    }

    private static void subSuperTest(){
        System.out.println("------------------- subSuperTest -----------------------");
        Clickable clickable = new MyCustom();
        requestClick(clickable); // Clicked in clickable

        MyCustom myCustom = new MyCustom();
        requestClick(myCustom); // Clicked in clickable
    }

    private static void requestClick(Clickable clickable){
        clickable.onClicked();
    }

    private static void methodOverriding(){
        MyView myView = new MyView();

        myView.onClicked();
        try {
            myView.onPressed();
        }catch (Exception e){
            e.printStackTrace();
        }

    }


    private static void variableTest(){
        Swimmable tuna = new Swimmer("Tuna",22);
        Swimmable dolphin = new Swimmer("Dolphin",23);

        Swimmer shark = new Swimmer("Shark",45);

        tuna = dolphin; // valid
        dolphin = tuna; // valid

        tuna = shark; // valid
        dolphin = shark; // valid


//        shark = tuna; // invalid
//        shark = dolphin; // invalid

    }

    private static void testReferenceType(){
        System.out.println("------------- testReferenceType ---------------------------");
        Swimmer swimmer = new Swimmer("John",1);
        swimmer.swim();
    }

    private static void testOperationOnVariable(){
        System.out.println("------------------------ testOperationOnVariable ----------------");

        Swimmable swimmable = null; // can be null
        System.out.println(swimmable);

        swimmable = new Swimmer("Tamim",60);
        double speed = swimmable.DEFAULT_SPEED; // can access constant field
        System.out.println(speed); // 20.0

    }

}
