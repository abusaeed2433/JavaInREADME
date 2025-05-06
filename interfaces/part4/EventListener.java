package interfaces.part4;

public interface EventListener extends Clickable{

    @Override
    default void onClicked() {
        System.out.println("click from event listener");
    }

}
