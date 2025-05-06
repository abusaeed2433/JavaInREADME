package interfaces.part4;

public interface Clickable {

    default void onClicked(){
        System.out.println("Clicked in clickable");
    }

}
