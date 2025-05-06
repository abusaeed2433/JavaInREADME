package theobjectclass.part2;

public class Cat implements Cloneable{
    private String name;

    public Cat(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    protected Object clone(){
        try {
            return super.clone();
        }catch (CloneNotSupportedException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println(name);
    }
}
