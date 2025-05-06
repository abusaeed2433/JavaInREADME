package classesandobject.part2;

import static classesandobject.part2.TriState.StateEnum.SECOND;

import classesandobject.Circle;
import classesandobject.part1.Bird;

public class Test {

    public static void main(String[] args) {
        TriState triState = new TriState(SECOND);
        System.out.println(triState.state); // SECOND

        finalTest();

        System.out.println( max() ); // 0
        System.out.println( max(1,22) ); // 22
        System.out.println( max(1,2,3,4,5,6,7,8,10) ); // 10

        simpleGenericTest();
    }

    private static void simpleGenericTest(){
        MyList<Integer> myList = new MyList<>();
        //MyList myList = new MyList<>();
        myList.add(12);
        myList.add(32);
        myList.add(42);
        myList.add(62);

        //System.out.println( myList.get(5) ); // Index out of bound

        System.out.println( myList.get(1) ); // 32

    }

    private static int findMinMax(boolean findMax, int ...arr){
        if(arr.length == 0) return 0;

        if(findMax) return max(arr);

        int mn = Integer.MAX_VALUE;
        for(int num : arr){
            if(num < mn) mn = num;
        }
        return mn;
    }

//    private static void m1(String str, int...n1, int...n2) {
//        // Code goes here
//    }
//
//    private static void m2(int...n1, String str) {
//      //
//    }

    private static int max(int... arr){
        if(arr.length == 0) return 0;
        int mx = Integer.MIN_VALUE;
        for(int num : arr){
            if(num > mx) mx = num;
        }
        return mx;
    }

    private static void finalTest(){
        Circle circle = new Circle();
        System.out.println(circle.getArea()); // 0.0

        Circle circle1 = new Circle(4);
        System.out.println(circle1.getArea()); // 50.264
    }

    private static double getArea(final double r){ // final parameter
        final double pi = 3.1415; // final local variable
        //pi = 3; error
        //r=5;
        return pi*r*r;
    }

}
