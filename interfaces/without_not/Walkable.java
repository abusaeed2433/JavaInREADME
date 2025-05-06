package interfaces.without_not;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import interfaces.with_not.Flyable;

public class Walkable {

    public static void startWalking(Animal[] animals){
        for(Animal animal : animals){
            animal.walk();
        }
    }

    public static void startFlying(Flyable[] flyables){
        for(Flyable flyable : flyables){
            flyable.fly();
        }
    }

    public static void startWalking(Object[] objects){

        for(Object obj : objects){
            Method method = getWalkMethod(obj);

            if(method != null){
                try {
                    method.invoke(obj);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    private static Method getWalkMethod(Object obj){
        Class c = obj.getClass();
        Method method = null;
        try {
           method = c.getMethod("walk");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return method;
    }

}
