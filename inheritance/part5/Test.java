package inheritance.part5;

import java.util.Map;
import java.util.Random;

public class Test {

    public static void main(String[] args) {
        testAbstract();
        testAbstract2();
    }

    private static void printName(Shape[] shapes){
        for(int i=0; i<shapes.length; i++){
            Shape sp = shapes[i];
            System.out.print(sp.getName());

            if(i != shapes.length - 1) System.out.print(", ");
        }
        System.out.println("");
    }

    private static void testAbstract2() {
        System.out.println("------------------ testAbstract2 -------------------");

        Shape[] shapes = new Shape[6];

        for(int i=0; i<shapes.length; i++){
            int rand = new Random().nextInt(10);
            shapes[i] = (rand % 2 == 0) ? new Rectangle("Rectangle",2,4) : new Circle("Circle",5);
        }
        printName(shapes); // Circle, Circle, Circle, Rectangle, Rectangle, Circle
    }

    private static void testAbstract(){
        System.out.println("------------------ testAbstract -------------------");

        Shape rectangle = new Rectangle("Rectangle",5,10);
        rectangle.draw(); // Rectangle

        Shape circle = new Circle("Circle",5);
        System.out.println(circle.getArea()); // 78.53975

    }

}
