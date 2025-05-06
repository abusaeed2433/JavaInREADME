package classesandobject.part2;

public class LocalVariable {
    private static int counter; // 0
    private String name; // default null
    private int num; // by default 0


    public static void main(String[] args) {

        LocalVariable lv = new LocalVariable();

        System.out.println(lv.name); // null
        System.out.println(lv.num); // 0
        lv.num = 24;
        System.out.println(
                lv.calculateDifference(25)
        ); // -1

        lv.assignMust();
    }

    public void assignMust(){
        int num;
        //System.out.println(num); // variable num might not have been initialized
    }

    public int calculateDifference(int num2){
        // num2 is local since this is formal parameter of method. Remember?
        int num = 1001;
        System.out.println(num); // 1001 because local variable takes precedence over global variable

        return this.num - num2; // this will be discussed later. Just know that this referring to current instant which is `lv`

    }

}
