package inheritance.part3;

public class Test {

    public static void main(String[] args) {
        basicOverriding();
        overridingRule4();
    }

    private static void overridingRule4(){
        System.out.println("------------------- overridingRule4 ---------------------");
        Parent parent = new Parent();
        System.out.println(parent.getOne()); // 1

        parent = new Child();
        System.out.println(parent.getThis()); // Child
    }

    private static void basicOverriding(){
        Child child = new Child();
        child.walk(); // Child walking...

        Parent parent = new Parent();
        parent.walk(); // Parent walking...

        parent = child;
        parent.walk(); // Child walking...

    }

}
