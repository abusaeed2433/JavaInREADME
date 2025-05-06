package classesandobject.part2;

import java.util.ArrayList;
import java.util.List;

public class MyList <T>{
    private final List<T> list = new ArrayList<>();

    public MyList() {
    }

    public void add(T item){
        list.add(item);
    }

    public T get(int index) throws ArrayIndexOutOfBoundsException{
        if(index > list.size()) throw new ArrayIndexOutOfBoundsException("Index out of bound");

        return list.get(index);
    }

}
