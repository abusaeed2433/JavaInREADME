package interfaces.part7;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Counter {

    private final int delayBetween;

    private int maxCountValue;
    private int currentValue = 1;
    private boolean isRunning, isInPauseState;

    private ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
    private final CounterListener listener;

    public Counter(int delayBetween,CounterListener listener) {
        this.delayBetween = delayBetween;
        this.listener = listener;
    }

    public void startCounter(int maxCountValue){
        if(isInPauseState){
            listener.onMessageFound("Counter is in pause state");
            return;
        }
        if(isRunning) {
            listener.onMessageFound("Counter already running");
            return;
        }

        currentValue = 0;
        this.maxCountValue = maxCountValue;
        startRunning();
        isRunning = true;
    }

    public void stopCounter(){
        if(!isRunning) {
            listener.onMessageFound("Counter not running");
            return;
        }

        isRunning = false;
        isInPauseState = false;

        shutdownNow();

        currentValue = 0;
        listener.onMessageFound("Counter stopped");
    }

    private void shutdownNow(){
        executor.shutdownNow();
        executor = Executors.newSingleThreadScheduledExecutor();
    }

    public void pause(){
        if(!isRunning){
            listener.onMessageFound("Counter not running");
            return;
        }

        if(isInPauseState){
            listener.onMessageFound("Already in pause");
            return;
        }

        listener.onMessageFound("Counter paused");
        isInPauseState = true;
        shutdownNow();
    }

    public void resume(){
        if(!isRunning){
            listener.onMessageFound("Counter not started");
            return;
        }

        if(!isInPauseState){
            listener.onMessageFound("Counter is running...");
            return;
        }

        isInPauseState = false;
        startRunning();
    }

    private void startRunning(){
        if(currentValue >= maxCountValue) return;

        isRunning = true;
        executor.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                currentValue++;
                listener.onTimeChanged(currentValue);
                if(currentValue >= maxCountValue) {
                    listener.onMessageFound("Counting completed");
                    isRunning = false;
                    shutdownNow();
                }
            }
        },0, delayBetween,TimeUnit.MILLISECONDS);
    }
}
