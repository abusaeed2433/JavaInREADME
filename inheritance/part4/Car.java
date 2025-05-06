package inheritance.part4;

public class Car extends Vehicle{

    int noOfDoors;

    public Car(String brand, int noOfDoors) {
        super(brand); // <------------ calling parent class constructor and passing brand value
        this.noOfDoors = noOfDoors;
    }

    public int getNoOfDoors() {
        return noOfDoors;
    }

    public void setNoOfDoors(int noOfDoors) {
        this.noOfDoors = noOfDoors;
    }

}
