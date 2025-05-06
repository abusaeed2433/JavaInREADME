package classesandobject.part2;

public class TriState {

    public enum StateEnum{ // no need to understand it right now. Think of it as constant
        FIRST,SECOND,THIRD;
    }

    public StateEnum state = StateEnum.FIRST;

    public TriState(StateEnum state) {
        System.out.println(this.state); // FIRST
        System.out.println(state); // SECOND
        this.state = state; // this.state refers to the global state
    }

    public static void printInfo(){
        //System.out.println(this.state); // cannot be referenced from a static context
    }

    public void goNextState(){
        if(state == StateEnum.FIRST) state = StateEnum.SECOND;
        else if(state == StateEnum.SECOND) state = StateEnum.THIRD;
        else if(state == StateEnum.THIRD) state = StateEnum.FIRST;
    }

    public StateEnum getIntState(){
        return state;
    }

    public void setState(StateEnum state) {
        this.state = state;
    }

}
