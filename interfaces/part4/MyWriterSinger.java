package interfaces.part4;

public class MyWriterSinger implements TestInheritanceOne.SingerWriter {

    private double rate;

    @Override
    public void sing() {
        System.out.println("Singing...");
    }

    @Override
    public void write() {
        System.out.println("Writing...");
    }

    @Override
    public void setRate(double rate) {
        this.rate = rate;
    }

    @Override
    public double getRate() {
        return rate;
    }

}
