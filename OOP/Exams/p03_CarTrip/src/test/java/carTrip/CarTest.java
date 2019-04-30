package carTrip;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CarTest {
    private static final String MODEL = "Mercedes-Benz";
    private static final String CHANGE_MODEL = "Audi";
    private static final double TANK_CAPACITY = 300.6;
    private static final double CHANGE_TANK_CAPACITY = 444.6;
    private static final double FUEL_AMOUNT = 60.2;
    private static final double CHANGE_FUEL_AMOUNT_ERROR = 9999.999;
    private static final double CHANGE_FUEL_AMOUNT = 20.122;
    private static final double FUEL_CONSUMATION_PER_KILOMETERS = 12.2;
    private static final double CHANGE_FUEL_CONSUMATION_PER_KILOMETERS = 20.2;
    private static final double DISTANCE_ERROR = 99999.9999;
    private static final double DISTANCE = 2.4;
    private static final double REFUEL = 2.4;


    private Car car;

    @Before
    public void createCar() {
        car = new Car(MODEL, TANK_CAPACITY, FUEL_AMOUNT, FUEL_CONSUMATION_PER_KILOMETERS);
    }

    @Test
    public void constructorShouldCreateCar() {
        Assert.assertEquals(MODEL, car.getModel());
    }


    //SetModel
    @Test(expected = IllegalArgumentException.class)
    public void setModelShouldThrowErrorForNUll() {
        this.car.setModel(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setModelShouldThrowErrorForEmpty() {
        this.car.setModel("");
    }

    @Test
    public void setModelShouldChangeCorectly() {
        this.car.setModel(CHANGE_MODEL);
        Assert.assertEquals(CHANGE_MODEL, this.car.getModel());
    }

    //ThankCapacity
    @Test
    public void setTankCapacityShouldChangeCorrectly() {
        this.car.setTankCapacity(CHANGE_TANK_CAPACITY);
        Assert.assertEquals(CHANGE_TANK_CAPACITY, this.car.getTankCapacity(), 0.01);
    }

    //FuelAmount
    @Test(expected = IllegalArgumentException.class)
    public void setFuelAmountShouldThrowErrorForMoreThanTankCapacity() {
        this.car.setFuelAmount(CHANGE_FUEL_AMOUNT_ERROR);
    }

    @Test
    public void setFuelAmountShouldChangeCorrectly() {
        this.car.setFuelAmount(CHANGE_FUEL_AMOUNT);
        Assert.assertEquals(CHANGE_FUEL_AMOUNT, this.car.getFuelAmount(), 0.01);
    }

    //FuelConsumationPerKm
    @Test(expected = IllegalArgumentException.class)
    public void setFuelConsumationPerKilometersShuldThrowErrorForEqualZero() {
        this.car.setFuelConsumptionPerKm(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setFuelConsumationPerKilometersShuldThrowErrorForLessThanZero() {
        this.car.setFuelConsumptionPerKm(-20);
    }

    @Test
    public void setFuelConsumationPerKilometersShouldChangeCorrectly() {
        this.car.setFuelConsumptionPerKm(CHANGE_FUEL_CONSUMATION_PER_KILOMETERS);
        Assert.assertEquals(CHANGE_FUEL_CONSUMATION_PER_KILOMETERS, this.car.getFuelConsumptionPerKm(), 0.01);
    }

    //Drive
    @Test(expected = IllegalStateException.class)
    public void driveShouldThrowErrorForDontHaveFuel() {
        this.car.drive(DISTANCE_ERROR);
    }

    @Test
    public void driveShouldWorkCorrectly() {
        String result = this.car.drive(DISTANCE);
        Assert.assertEquals("Have a nice trip", result);
    }

    @Test
    public void driveShouldChangeFuelAmount() {
        this.car.drive(DISTANCE);
        double result = FUEL_AMOUNT - (DISTANCE * FUEL_CONSUMATION_PER_KILOMETERS);
        Assert.assertEquals(result, this.car.getFuelAmount(), 0.01);
    }

    //Refuel
    @Test(expected = IllegalStateException.class)
    public void refuelShouldThrowErrorForTooManyFuel(){
        this.car.refuel(CHANGE_FUEL_AMOUNT_ERROR);
    }

    @Test
    public void refuelShouldWorkCorrectly(){
        this.car.refuel(REFUEL);
    Assert.assertEquals(REFUEL + FUEL_AMOUNT, this.car.getFuelAmount(), 0.01);
    }

}