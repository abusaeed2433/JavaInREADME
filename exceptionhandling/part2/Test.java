package exceptionhandling.part2;

public class Test {

    public static void hideTrace() {
        try {
            m1();
        }
        catch(Exception e) {
            e.printStackTrace(); // hidden original trace
        }
    }

    public static void m1() throws Exception {
        try {
            m2();
        }
        catch(Exception e) {
            e.fillInStackTrace(); // hide trace here
            throw e; // rethrowing
        }
    }

    public static void m2() throws Exception {
        throw new Exception("An error has occurred."); // just throw
    }


    private static void testRethrow2(int y){
        try {
            try {
                int ans = 10 / y;
                System.out.println(ans);
            } catch (Exception e) {
                throw new RuntimeException("Can't divide by zero too");
            }
        }catch (Exception e){
            e.printStackTrace(); // executed
        }
    }

    private static void testRethrow(){
        try {
            rethrowException(0);
        }catch (Exception e){
            e.printStackTrace(); // executed
        }
    }

    private static void rethrowException(int y){
        try{
            int ans = 10/y;
            System.out.println(ans);
        }catch (Exception e){
            throw new RuntimeException("Can't divide by zero");
        }
    }

    // -------------------- ------------------- ---------------- -------------------- ------------------------


    private static void throwMultiple(Integer y) throws RuntimeException{
        if(y == null) throw new NullPointerException("Can't be null");

        if(y == 0) throw new ArithmeticException("Can't be zero");

        System.out.println("ok");
    }

    public static void main(String[] args) {
        System.out.println("------------- testRethrow ---------------");
        testRethrow();
        System.out.println("------------- testRethrow2 --------------");
        testRethrow2(0);
        System.out.println("------------- hideTrace -----------------");
        hideTrace();
        System.out.println("------------- throwMultiple -------------");
        try {
            throwMultiple(0);
        }catch (Exception e){
            System.out.println(e.getMessage()); // Can't be zero
        }
        System.out.println("------------ testTryWithResource --------");
        testTryWithResource();
    }


    private static void testTryWithResource(){
        try(
                MyResource res1 = new MyResource("Hello world!",1,"Saeed");
                MyResource res2 = new MyResource("Hi world!",2,"None");
        ){
            System.out.println(res1.getSender()); // Saeed
            System.out.println(res2.getSender()); // None
        }
        catch (Exception e){
            System.out.println("Something went wrong");
        }
        // Closed None. JVM automatically call close method on res2
        // Closed Saeed. JVM automatically call close method on res1
        System.out.println("Resource will be closed before this"); // Resource will be closed before this
    }

}
