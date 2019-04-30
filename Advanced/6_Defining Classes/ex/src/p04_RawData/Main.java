package p04_RawData;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        LinkedHashMap<String, ArrayList<Car>> allCars = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String model = tokens[0];
            int enginSpeed = Integer.parseInt(tokens[1]);
            int enginePower = Integer.parseInt(tokens[2]);
            int cargoWeight = Integer.parseInt(tokens[3]);
            String cargoType = tokens[4];
            double tire1Pressure = Double.parseDouble(tokens[5]);
            int tire1Age = Integer.parseInt(tokens[6]);
            double tire2Pressure = Double.parseDouble(tokens[7]);
            int tire2Age = Integer.parseInt(tokens[8]);
            double tire3Pressure = Double.parseDouble(tokens[9]);
            int tire3Age = Integer.parseInt(tokens[10]);
            double tire4Pressure = Double.parseDouble(tokens[11]);
            int tire4Age = Integer.parseInt(tokens[12]);

            Engine engine = new Engine(enginSpeed, enginePower);
            Cargo cargo = new Cargo(cargoWeight, cargoType);
            Tires tires = new Tires(tire1Pressure, tire1Age, tire2Pressure, tire2Age, tire3Pressure, tire3Age, tire4Pressure, tire4Age);

            if (cargoType.equals("fragile") && tires.isTresureLessThan1()) {
                allCars.putIfAbsent(cargoType, new ArrayList<>());
                allCars.get(cargoType).add(new Car(model, engine, cargo, tires));
            } else if (cargoType.equals("flamable") && enginePower > 250) {
                allCars.putIfAbsent(cargoType, new ArrayList<>());
                allCars.get(cargoType).add(new Car(model, engine, cargo, tires));
            }

        }

        String command = scanner.nextLine();

        if (allCars.size() >0 && allCars.containsKey(command)){
            for (Car car : allCars.get(command)) {
                System.out.println(car.getModel());
            }
        }
    }
}
