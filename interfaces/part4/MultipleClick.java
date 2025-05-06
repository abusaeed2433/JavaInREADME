package interfaces.part4;

public class MultipleClick extends ClickDetector implements Clickable {

}

class ClickDetector{
    public void onClicked(){ // should be public
        System.out.println("Calling from click detector");
    }
}