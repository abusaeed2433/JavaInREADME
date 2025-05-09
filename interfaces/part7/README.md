
# Interface - part7

## A Real-World example using interface
- Similar to real world problem,
- We have a `Counter` class: 
  - That increments counter value after some seconds,
  - Notify the values to the user,
  - User can pause, resume, stop and start counter,
  - If any invalid operation is requested, then it notifies user with a message,
- We have a `MyApp` class:
  - That initially starts the counter,
  - Then keep interacting with user,
  - Shows the current counter value to user after getting notified,
  - Shows the error/message from `Counter` class,
- For interacting between `Counter` and `MyApp` class we created `CounterListener` interface,
- `CounterListener` interface
  - Contains two methods:
    - One for getting counter value,
    - One for getting any error/message,

- `CounterListener` interface:
  ```java
  public interface CounterListener {
      void onTimeChanged(int currentTime);
      void onMessageFound(String message);
  }
  ```

- `Counter` class:
    ```java
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
    ```
  
- `MyApp` class:
  ```java
  public class MyApp {
  
      public static void main(String[] args) {
          startCounting(); // initially starting count
      }
  
      private static void startCounting(){
          Counter counter = new Counter(1500, new CounterListener() {
              @Override
              public void onTimeChanged(int currentTime) {
                  System.out.println(currentTime);
              }
  
              @Override
              public void onMessageFound(String message) {
                  System.out.println(message);
              }
          });
  
          counter.startCounter(24);
          
          // below part interact with user
          Scanner sc = new Scanner(System.in);
          while (true){
              int inp = sc.nextInt();
              if(inp == 0) break;
  
              if(inp == 1){
                  counter.stopCounter();
              }
              else if(inp == 2){
                  counter.startCounter(20);
              }
              else if(inp == 3){
                  counter.pause();
              }
              else if(inp == 4){
                  counter.resume();
              }
  
          }
      }
  }
  ```
- Above example can be achieved by using single class also. If you do so, your code will be complex and code readability will decrease,

- **Write the whole example manually. Don't copy & paste. Then try to understand what the interface is doing.**

### <p align="center">Good luck with interface</p>

>> "If at First You Don't Succeed, Call It Version 1.0" -- Khayri R.R. Woulfe

<!-- bottom_nav_bar_1243 -->
<div align="center">
<a href="https://github.com/abusaeed2433/JavaInREADME/tree/main/interfaces/part6/">
    <img src="https://img.shields.io/badge/◀%20Previous-blue?style=for-the-badge" alt="Previous">
</a>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<a href="https://github.com/abusaeed2433/JavaInREADME/tree/main/enum/">
    <img src="https://img.shields.io/badge/Next%20▶-blue?style=for-the-badge" alt="Next">
</a>
</div>
<!-- bottom_nav_bar_1243 -->
    