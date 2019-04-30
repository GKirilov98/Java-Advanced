package p01_Vehicles;

public class Car extends VehicleImpl {
    public Car(double fuelQuantity, double fuelConsumption, double capacity) {
        super(fuelQuantity, fuelConsumption, capacity );
    }

    @Override
    protected void setFuelConsumption(double fuelConsumption) {
        super.setFuelConsumption(fuelConsumption + 0.9);
    }

    @Override
    public String drive(double distance) {
        return "Car " + super.drive(distance);
    }
}