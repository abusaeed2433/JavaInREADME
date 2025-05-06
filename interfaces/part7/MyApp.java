package interfaces.part7;

import java.util.Scanner;

public class MyApp {

    public static void main(String[] args) {
        startCounting();
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
