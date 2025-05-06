package exceptionhandling.part2;

import exceptionhandling.part1.MyMessage;

public class MyResource implements AutoCloseable{

    private MyMessage myMessage;
    private String sender;

    public MyResource(String message, int id, String sender) {
        this.myMessage = new MyMessage(message,id);
        this.sender = sender;
    }

    public MyMessage getMyMessage() {
        return myMessage;
    }

    public void setMyMessageId(int id) {
        this.myMessage.setMessageId(id);
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    @Override
    public void close() throws Exception {
        myMessage = null;
        System.out.println("Closed "+sender);
    }

}
