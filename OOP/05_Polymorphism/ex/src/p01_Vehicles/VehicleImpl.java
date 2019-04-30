package p01_Vehicles;

import java.text.DecimalFormat;

public abstract class VehicleImpl implements Vehicle {
    private double fuelQuantity;
    private double fuelConsumption;
    private double tankCapacity;
    private boolean isEmpty = false;

    public void  setIsEmpty(boolean empty) {
         isEmpty = empty;
    }

    public boolean getIsEmpty() {
        return isEmpty;
    }

    public VehicleImpl(double fuelQuantity, double fuelConsumption, double capacity) {
        this.setFuelQuantity(fuelQuantity);
        this.setFuelConsumption(fuelConsumption);
        this.tankCapacity = capacity;
    }

    protected void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    protected void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    protected double getFuelConsumption() {
        return fuelConsumption;
    }

    @Override
    public void refuel(double liters) {
        if (liters <= 0) {
            System.out.println("Fuel must be a positive number");
        } else if (isEmpty || this.fuelQuantity + liters > this.tankCapacity ) {
            System.out.println("Cannot fit fuel in tank");
        } else {
            this.fuelQuantity += liters;
        }
    }

    @Override
    public String drive(double distance) {
        double fuelNeeded = distance * this.fuelConsumption;
        DecimalFormat df = new DecimalFormat("#.##");
        String result = "needs refueling";
        if (this.fuelQuantity >= fuelNeeded) {
            result = String.format("travelled %s km", df.format(distance));
            this.fuelQuantity -= fuelNeeded;
        }

        return result;
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", this.getClass().getSimpleName(), this.fuelQuantity);
    }
}
