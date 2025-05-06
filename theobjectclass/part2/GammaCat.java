package theobjectclass.part2;

public class GammaCat {
    private final String name; // <------- final optional though

    public GammaCat(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
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
