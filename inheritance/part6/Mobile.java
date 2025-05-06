package inheritance.part6;

public class Mobile {

    private String brand;
    private MobileDisplay display;

    public Mobile(String brand) {
        this.brand = brand;
        this.display = new MobileDisplay(16);
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public MobileDisplay getDisplay() {
        return display;
    }

    public void showData(){
        display.showSomething();
    }

    private class MobileDisplay {
        private int density;

        public MobileDisplay(int density) {
            this.density = density;
        }

        private void showSomething(){
            for(int i=0; i<density; i++){
                System.out.print("@");
            }
            System.out.println("");
        }

        public int getDensity() {
            return density;
        }

        public void setDensity(int density) {
            this.density = density;
        }

    }

}
