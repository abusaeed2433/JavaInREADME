package exceptionhandling.part1;

public class MyException extends Exception{

    private final int messageId;

    public MyException() {
        super();
        this.messageId = -1;
    }

    public MyException(MyMessage myMessage) {
        super(myMessage.getMessage());
        messageId = myMessage.getMessageId();
    }

    public int getMessageId() {
        return messageId;
    }

}

