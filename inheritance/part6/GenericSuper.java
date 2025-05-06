package inheritance.part6;

public class GenericSuper<T> {
    public void m1(T a) {
        // Code goes here
    }

    public <P extends Employee> void m2(P a) {
        // Code goes here
    }
}

//public class GenericSuper {
//    public void m1(Object a) {
//        // Code goes here
//    }
//
//    public void m2(Employee a) {
//        // Code goes here
//    }
//}