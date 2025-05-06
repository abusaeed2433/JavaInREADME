package inheritance.part3;


import java.io.IOException;

public class Son extends Father{


//    @Override
//    public void calc(int x) throws CheckedException11, IOException { // fine
//        System.out.println("Son");
//    }


    //    @Override
//    public void calc(int x) throws CheckedException2{ // error <------
//        System.out.println("Son");
//    }


//    @Override
//    public void calc(int x) throws CheckedException1{ // valid
//        System.out.println("Son");
//    }


//    @Override
//    public void calc(int x){ // valid
//        System.out.println("Son");
//    }


    @Override
    public void calc(int x) throws CheckedException1, IOException {
        super.calc(x);
    }
}
