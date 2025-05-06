package classesandobject.part1;

public class Bird {

    private String name;
    private String species;
    private boolean canFly;


    // constructor - 1
    public Bird() {
        this.name = "Unknown";
        this.species = "Not found";
        this.canFly = false;
    }

    // constructor - 2
    public Bird(boolean canFly) {
        this("unknown","Not found",canFly); // calling other constructor. Remember `this`. must be first line
    }

    // constructor - 3
    public Bird(String name, String species, boolean canFly) {
        this.name = name;
        this.species = species;
        this.canFly = canFly;
    }

    // constructor - 4 . Copy constructor
    public Bird(Bird bird){
        this.name = bird.name;
        this.species = bird.species;
        this.canFly = bird.canFly;
    }

    public void printDetails(){
        System.out.println(name+" -> "+species+" -> "+canFly);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public boolean canFly() {
        return canFly;
    }

    public void setCanFly(boolean canFly) {
        this.canFly = canFly;
    }

}
