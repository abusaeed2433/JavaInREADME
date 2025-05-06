package interfaces.part7;

public interface CounterListener {
    void onTimeChanged(int currentTime);
    void onMessageFound(String message);
}
