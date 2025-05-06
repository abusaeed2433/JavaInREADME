
# interface part-7

> CODES ARE IN `partSeven` PACKAGE

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

- `CounterListener` interface: See `CounterListener.java`,
  ```
  public interface CounterListener {
      void onTimeChanged(int currentTime);
      void onMessageFound(String message);
  }
  ```

- `Counter` class: See `Counter.java`,
  ```
  public class Counter {
      ...
      private final CounterListener listener;
  
      public Counter(int delayBetween,CounterListener listener) {
          ...
          this.listener = listener;
      }
  
      public void startCounter(int maxCountValue){
          ...
              listener.onMessageFound("Counter is in pause state");
          ...
              listener.onMessageFound("Counter already running");
          ...
      }
  
      public void stopCounter(){
          ...
              listener.onMessageFound("Counter not running");
          ...
          listener.onMessageFound("Counter stopped");
      }
  
      ...
  
      public void pause(){
          ...
              listener.onMessageFound("Counter not running");
          ...
              listener.onMessageFound("Already in pause");
          ...
          listener.onMessageFound("Counter paused");
          ...
      }
  
      public void resume(){
          ...
              listener.onMessageFound("Counter not started");
          ...
              listener.onMessageFound("Counter is running...");
          ...
      }
  
      private void startRunning(){
          ...
          executor.scheduleAtFixedRate(new Runnable() {
              @Override
              public void run() {
                  ...
                  listener.onTimeChanged(currentValue);
                  ...
                      listener.onMessageFound("Counting completed");
                      ...
                  ...
              }
          },0, delayBetween,TimeUnit.MILLISECONDS);
      }
  }
  ```
  
- `MyApp` class: See `MyApp.java`:
  ```
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
