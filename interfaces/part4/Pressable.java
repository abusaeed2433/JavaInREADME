package interfaces.part4;

import java.io.IOException;

public interface Pressable {
    int LONG_PRESS_DURATION = 200; // ms

    void onPressed() throws IOException;
    void onClicked();

}
