package interfaces.part4;

import java.io.IOException;

public class MyEvent2 implements Clickable,Pressable{

    @Override
    public void onPressed() throws IOException {

    }

    @Override
    public void onClicked() {
        Clickable.super.onClicked();
    }

}
