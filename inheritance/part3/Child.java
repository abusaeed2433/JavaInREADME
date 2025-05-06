package inheritance.part3;

public class Child extends Parent{

    @Override // optional annotation
    public void walk(){
        System.out.println("Child walking...");
    }


    @Override
    int getOne(){ return -1; }
    @Override
    Child getThis(){ return this; }

    @Override
    public String toString() {
        return "Child";
    }
}
