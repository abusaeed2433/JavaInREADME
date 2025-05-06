package r_Enum;

public enum CommandList implements Executable{
    RUN{
        @Override
        public void doNothing() {

        }
    },
    JUMP{
        @Override
        public void doNothing() {

        }
    };

    @Override
    public void execute() {
        if(this.equals(RUN)){
            System.out.println("Running");
        }
        else if(this.equals(JUMP)){
            System.out.println("Jumping");
        }
    }

    public abstract void doNothing();

}
