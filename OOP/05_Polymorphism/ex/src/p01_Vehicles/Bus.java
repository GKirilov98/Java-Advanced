package p01_Vehicles;

public class Bus extends VehicleImpl {


    public Bus(double fuelQuantity, double fuelConsumption, double capacity) {
        super(fuelQuantity, fuelConsumption, capacity);
    }



    @Override
    public String drive(double distance) {
        if (!super.getIsEmpty()){
            super.setFuelConsumption(super.getFuelConsumption() + 1.4);
        } else {
            super.setFuelConsumption(super.getFuelConsumption() );
        }

        return "Bus " + super.drive(distance);
    }
}
