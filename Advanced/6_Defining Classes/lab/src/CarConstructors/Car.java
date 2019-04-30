package CarConstructors;

class Car {
   private String make ;
   private String model = "unknown";
   private int horsePower = -1;

    public Car(String make) {
        this.make = make;
    }

    public Car(String make, String model, int horsePower) {
        this.make = make;
        this.model = model;
        this.horsePower = horsePower;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public String carInfo() {
       return String.format("The car is: %s %s - %d HP.", this.make, this.model, this.horsePower);
    }
}
