package exceptionhandling.part2;

public class StackFrameTest {
    public static void main(String[] args) {
        m1();
    }
    public static void m1() {
        m2();
    }
    public static void m2() {
        m3();
    }

    public static void m3() {
        Throwable t = new Throwable();
        StackTraceElement[] frames = t.getStackTrace(); // will get current stack frame content.
        /*
        stack content will be
         m3()
         m2()
         m1()
         main()
         */

        printStackDetails(frames);
    }
    public static void printStackDetails(StackTraceElement[] frames) {
        System.out.println("Frame count: " + frames.length);
        for (int i = 0; i < frames.length; i++) {


            String fileName = frames[i].getFileName();
            String className = frames[i].getClassName();
            String methodName = frames[i].getMethodName();
            int lineNumber = frames[i].getLineNumber();


            System.out.println("Frame Index: " + i);
            System.out.println("File Name: " + fileName);
            System.out.println("Class Name: " + className);
            System.out.println("Method Name: " + methodName);
            System.out.println("Line Number: " + lineNumber);
            System.out.println("---------------------------");
        }
    }
}