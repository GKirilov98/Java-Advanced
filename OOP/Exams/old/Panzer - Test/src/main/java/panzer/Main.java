package panzer;

import panzer.contracts.Manager;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Manager manager = new ManagerCommandImpl();
         Scanner scanner = new Scanner(System.in);
         String command = scanner.nextLine();
         String resultToPrint = "";
         while (!command.equals("Terminate")){
             List<String> tokens = Arrays.stream(command.split(" ")).collect(Collectors.toList());
             switch (tokens.get(0)){
                 case "Vehicle":
                     resultToPrint = manager.addVehicle(tokens);
                     break;
                 case "Part":
                     resultToPrint = manager.addPart(tokens);
                     break;
                 case "Inspect":
                     resultToPrint = manager.inspect(tokens);
                     break;
                 case "Battle":
                     resultToPrint = manager.battle(tokens);
                     break;
             }

             System.out.println(resultToPrint);
             command = scanner.nextLine();
         }

         resultToPrint = manager.terminate(Collections.emptyList());
        System.out.println(resultToPrint);

    }
}
