package p01_Vehicles;

public class Truck extends VehicleImpl {
    private static final double addedConsumption = 1.6;

    public Truck(double fuelQuantity, double fuelConsumption, double capacity) {
        super(fuelQuantity, fuelConsumption, capacity);
    }

    @Override
    protected void setFuelConsumption(double fuelConsumption) {
        super.setFuelConsumption(fuelConsumption + addedConsumption);
    }

    @Override
    public String drive(double distance) {
        return "Truck " + super.drive(distance);
    }

    @Override
    public void refuel(double amount) {
        super.refuel(amount * 0.95);
    }

}