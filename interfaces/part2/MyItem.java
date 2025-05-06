package interfaces.part2;

public class MyItem implements Clickable{

    @Override
    public void onViewSingleClick() {
        System.out.println("Single click");
    }

    @Override
    public void onViewDoubleClick() throws RuntimeException {
        System.out.println("Double click");
    }

//    public void requestSingleClick(){
//        System.out.println("Does nothing");
//    }

}
