package softUniParking;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Parking {
    private Map<String, Car> cars;
    private int capacity;

    public Parking(int capacity) {
        this.capacity = capacity;
        cars = new HashMap<>();
    }

    public String  addCar(Car car) {
        if (this.cars.containsKey(car.getRegistrationNumber())){
            return "Car with that registration number, already exists!";
        } else if (this.cars.size() == this.capacity){
            return "Parking is full!";
        } else {
            this.cars.putIfAbsent(car.getRegistrationNumber(), car);
            return String.format("Successfully added new car %s %s", car.getMake(), car.getRegistrationNumber());
        }
    }

    public Car getCar(String registrationNumber) {
        return this.cars.get(registrationNumber);
    }

    public String  removeCar(String registrationNumber) {
        if (this.cars.containsKey(registrationNumber)){
            this.cars.remove(registrationNumber);
            return String.format("Successfully removed %s", registrationNumber);
        } else {
            return "Car with that registration number, doesn't exists!";
        }
    }

    public int getCount() {
        return this.cars.size();
    }

    public void removeSetOfRegistrationNumber(List<String> registrationNumbers) {
        for (String registrationNumber : registrationNumbers) {
            this.removeCar(registrationNumber);
        }
    }
}
