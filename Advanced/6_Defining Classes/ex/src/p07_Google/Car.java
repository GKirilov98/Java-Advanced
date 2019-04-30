package p07_Google;

public class Car {
    private String model;
    private int speed;


    public Car(String model, int speed) {
        this.model = model;
        this.speed = speed;
    }

    public Car() {
        this.model = "";
        this.speed = 0;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public String getInfo(){
        if(model.isEmpty()){
            return "";
        }
         return "\n" + this.model + " " + this.speed;
    }
}
