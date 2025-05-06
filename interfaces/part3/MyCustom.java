package interfaces.part3;

import java.io.IOException;

public class MyCustom implements Clickable,Pressable{

    @Override
    public void onPressed() throws IOException {

    }

    @Override
    public void onClicked() {
        Clickable.super.onClicked();
    }

}
