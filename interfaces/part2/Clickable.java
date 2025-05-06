package interfaces.part2;

public interface Clickable {
    int SINGLE_CLICK = 1;
    int DOUBLE_CLICK = 2;
    int DOUBLE_CLICK_INTERVAL = 500; // ms


    //public abstract void onClick();
    void onViewSingleClick();
    void onViewDoubleClick() throws RuntimeException;

    static void printConstant(){
        System.out.println("SINGLE_CLICK: "+SINGLE_CLICK);
        System.out.println("DOUBLE_CLICK: "+DOUBLE_CLICK);
        System.out.println("DOUBLE_CLICK_INTERVAL: "+DOUBLE_CLICK_INTERVAL);
    }

    default void requestSingleClick(){
        this.onViewSingleClick(); //
    }

}
