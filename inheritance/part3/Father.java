package inheritance.part3;

import java.io.IOException;

public class Father {

    public void calc(int x) throws CheckedException1, IOException {
        System.out.println("Father");

        if(x == -1) throw new CheckedException1();

        if(x == 0) throw new IOException();

    }

}
