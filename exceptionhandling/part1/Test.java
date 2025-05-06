package exceptionhandling.part1;

import java.io.*;

public class Test {

    public static void main(String[] args) {
//        firstTest(0);
//        firstTestBadSolution(0);
//        firstTestSolution(0);

        String fullPath = "/D:/Own/Java/Projects/JavaPractice/out/production/JavaPractice/i_ExceptionHandling/files/dummy.txt";
        catchExceptionOrder(0,"Saeed",fullPath);
        catchExceptionOrder(2,null,fullPath);
        catchExceptionOrder(1,"Saeed","invalid.txt");

        catchMultipleException(1,null,"invalid.txt");

        callHandleChecked();

        finallyTest(fullPath);

        testThrow();

        try {
            MyMessage myMessage = new MyMessage(null,2952);
            testMyException(myMessage);
        }catch (MyException e){
            System.out.println(e.getMessageId()); // 2952
        }
    }

    private static void testMyException(MyMessage myMessage) throws MyException{
        if(myMessage.getMessage() == null){
            throw new MyException(myMessage);
        }
        System.out.println(myMessage.getMessage()+" "+myMessage.getMessageId());
    }

    private static void testThrow(){
        try {
            throwMyException(20); // fine
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        try {
            throwMyException(12);
        }catch (Exception e){
            System.out.println(e.getMessage()); // You are baccha
        }
    }

    private static void throwMyException(int age) throws Exception{
        if(age < 18) throw new Exception("You are baccha");

        System.out.println("fine");
    }


    private static void finallyTest(String filePath){
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(filePath);
            printFile(fileReader);
        }catch (IOException e){
            System.out.println("Failed to read");
        }
        finally {
            if(fileReader != null){
                try {
                    fileReader.close();
                    System.out.println("finally executed");
                }catch (IOException e){e.printStackTrace();}
            }
        }
    }


    private static void callHandleChecked(){
        handleChecked1("invalid");

        try {
            handleChecked2("invalid");
        }catch (IOException e){
            System.out.println("Failed to read");
        }
    }


    private static void handleChecked1(String filePath){
        try {
            FileReader fileReader = new FileReader(filePath);
            printFile(fileReader);
            fileReader.close();
        }catch (IOException e){
            System.out.println("Failed to read");
        }
    }

    private static void handleChecked2(String filePath) throws IOException{
        FileReader fileReader = new FileReader(filePath);
        printFile(fileReader);
        fileReader.close();
    }

    private static void catchMultipleException(int y, String message, String filePath){
        try {
            int x = 10;
            int result = x / y;

            String lower = message.toLowerCase();

            FileReader fileReader = new FileReader(filePath);
            printFile(fileReader);
            fileReader.close();
        }
        catch ( RuntimeException | IOException e){
            System.out.println("Something went wrong");
        }
    }

    private static void catchExceptionOrder(int y, String message, String filePath){
        try{

            int x = 10;
            int result = x/y;

            String lower = message.toLowerCase();

            FileReader fileReader = new FileReader(filePath);
            printFile(fileReader);
            fileReader.close();
        } catch (IOException e) {
            System.out.println("Error in reading file");
        }
        catch (ArithmeticException e){
            System.out.println("Can't divide");
        }
        catch (RuntimeException e){
            System.out.println("lower failed");
        }
    }



    private static void printFile(FileReader fileReader) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        StringBuilder content = new StringBuilder();

        String line;
        while ((line = bufferedReader.readLine()) != null) {
            content.append(line).append("\n"); // Append each line to the StringBuilder
        }
        bufferedReader.close();
        System.out.println(content.toString().trim());

    }

    private static void firstTest(int y){
        int x = 10;

        int result = (x/y); // will throw exception if y == 0

        System.out.println(result); // `/ by zero when` y = 0;

    }

    private static void firstTestBadSolution(int y){
        int x = 10;

        if(y == 0){
            System.out.println("Can't divide"); // Can't divide
        }
        else{
            int result = x/y;
            System.out.println(result);
        }
    }

    private static void firstTestSolution(int y){
        int x = 10;
        try {
            int result = x/y;
            System.out.println(result);
        }
        catch (Exception e){
            System.out.println("Can't divide"); // executed when y = 0
        }
    }

}
