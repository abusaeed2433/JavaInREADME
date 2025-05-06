package exceptionhandling.part1;

public class MyMessage {
    private final String message;
    private int messageId;

    public MyMessage(String message, int messageId) {
        this.message = message;
        this.messageId = messageId;
    }

    public String getMessage() {
        return message;
    }

    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }
}
