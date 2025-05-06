package interfaces.without_not;

import interfaces.conflicts_not.RunAndWalkable;

public class Person extends Animal implements RunAndWalkable {

    private final int id;

    public Person(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public void walk(){
        System.out.println("Person "+id+" is walking...");
    }

    @Override
    public void run() {
        System.out.println("Person is running...");
    }

    @Override
    public int getStatus() {
        return RunAndWalkable.super.getStatus();
    }

}
