package trafficLight;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] initialStates = scanner.nextLine().split("\\s+");
        int updatesCount = Integer.parseInt(scanner.nextLine()) ;
        ArrayList<Service> trаfficLights = new ArrayList<>();
        for (String initialState : initialStates) {
            Service service = new Service(LightStates.valueOf(initialState));
            trаfficLights.add(service);
        }

        StringBuilder printed = new StringBuilder();
        for (int i = 0; i < updatesCount; i++) {
            for (Service trefficLight : trаfficLights) {
                trefficLight.update();
                printed.append(trefficLight.toString()).append(" ");
            }
            printed.append("\n");
        }

        System.out.println(printed);
    }
}
