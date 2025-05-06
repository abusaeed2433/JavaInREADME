package interfaces.random_not;

public class Child extends Parent{
    private final int id;

    public Child(int id) {
        this.id = id;
    }

    /**
     *
     * @return <code>id</code> of the person
     */
    public int getId() {
        return id;
    }

}
