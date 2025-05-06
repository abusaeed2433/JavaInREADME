package theobjectclass.part2;

public class Human implements Cloneable{
    private String name;
    private Cat cat;

    public Human(String name, String catName) {
        this.name = name;
        this.cat = new Cat(catName);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Cat getCat() {
        return cat;
    }

    public void setCat(Cat cat) {
        this.cat = cat;
    }

    public void setCatName(String newName){
        this.cat.setName(newName);
    }

    @Override
    public String toString() {
        return "owner: " + name + ", " + "catName: " + cat.getName();
    }

    @Override
    protected Object clone() {
        try {
            return super.clone();
        }catch (CloneNotSupportedException e){
            e.printStackTrace();
            return null;
        }
    }

    // cloning nested object also
//    @Override
//    protected Object clone() {
//        try {
//            Human human = (Human) super.clone();
//            human.cat = (Cat)this.cat.clone();
//            return human;
//        }catch (CloneNotSupportedException e){
//            e.printStackTrace();
//            return null;
//        }
//    }

}
