package inheritance.part3;

public class Parent {

    public void walk(){
        System.out.println("Parent walking...");
    }

    int getOne(){ return 1; }
    Parent getThis(){ return this; }

    @Override
    public String toString() {
        return "Parent";
    }
}
