package array;

import java.sql.Array;
import java.sql.SQLSyntaxErrorException;
import java.util.ArrayList;

public class Test {

    public static void main(String[] args) {
        declareArray();
        arrayTest();
        arrayListTest();
        passArray();
        multiDimenArray();
        arrayListToArray();
    }

    private static void arrayListToArray(){
        System.out.println("------------------------------ arrayListToArray ---------------------");
        ArrayList<String> names = new ArrayList<>();

        names.add("John");
        names.add("Jane");
        names.add("Mary");

        Object[] arr = names.toArray(); // <--------- way-1
        printArray(arr); // John Jane Mary

        String[] brr = new String[names.size()];
        names.toArray(brr); // <------------ way-2
        printArray(brr); // John Jane Mary

    }

    private static void multiDimenArray(){
        System.out.println("------------------------- multiDimenArray -----------------------------");
        int[][] table = new int[3][2];

        int[][] tbl = {
                {1,2},
                {3,4},
                {5,6}
        };

        for(int i=0;i<tbl.length; i++){
            for(int j=0; j<tbl[i].length; j++){
                System.out.print(tbl[i][j]+" ");
            }
            System.out.println("");
        }

        System.out.println("---");
        // better approach
        for(int[] arr : tbl){
            for(int ij : arr){
                System.out.print(ij+" ");
            }
            System.out.println("");
        }
        /*
        output
        1 2
        3 4
        5 6
         */
        // normal like 1D array
    }

    private static void passArray(){
        int[] arr = {1,2,23,24,25,3};

        printArray(arr); // 1 2 23 24 25 3
        resizeValues(arr);
        printArray(arr); // 1 2 20 20 20 3
    }

    private static void resizeValues(int[] arr){
        for(int i=0; i<arr.length; i++) {
            if(arr[i] > 20) arr[i] = 20;
        }
    }

    private static void arrayListTest(){
        System.out.println("----------------------- arrayListTest ------------------------ ");
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2000);
        arr.add(3);

        Integer num1 = 1;
        Integer num2 = 2000;

        for(int i=0; i<arr.size(); i++) System.out.print(arr.get(i)+" ");
        System.out.println("");

        System.out.println(arr.size()); // 3

        arr.add(20);
        arr.add(22);
        System.out.println(arr.size()); // 5

    }

    private static void arrayTest(){
        int[] arr = new int[5];
        for(int i=0;i<arr.length;i++) arr[i] = i+5;

        Object obj = arr; // array are object. So assignment is possible
        printArray(arr); // 5 6 7 8 9

        int[] brr = (int[])obj;
        printArray(brr); // 5 6 7 8 9

        // default
        String[] names = new String[4];
        printArray(names); // null null null null

        names[0] = "Pantho";
        names[2] = "Aslam";
        printArray(names); // Pantho null Aslam null

        names[1] = "Maruf";
        names[3] = "Anik";

        printArray(names); // Pantho Maruf Aslam Anik
        for (int i=0;i<names.length; i++){
            names[i] = names[i].substring(0,1);
        }
        printArray(names); // P M A A

        int[] rolls = new int[]{1,2,3,4,5};
        int[] rolls2 = {1,2,3,4,5};

    }

    private static void printArray(int[] arr){
        for (int t : arr) {
            System.out.print(t + " ");
        }
        System.out.println("");
    }

    private static <T> void printArray(T[] arr){
        for (T t : arr) {
            System.out.print(t + " ");
        }
        System.out.println("");
    }

    private static void declareArray(){
        int[] arr = new int[5];
        for(int i=0; i<5; i++) arr[i] = i+1;

        for(int i=0; i<5; i++) System.out.print(arr[i]+" "); // 1 2 3 4 5
        System.out.println("");
    }
}
