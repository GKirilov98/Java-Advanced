package cresla;

import cresla.interfaces.Manager;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Manager managerCommands = new ManagerCommands();
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        String result = "";
        while (!command.equals("Exit")) {
            String[] tokens = command.split(" ");
            switch (tokens[0]) {
                case "Reactor":
                    result = managerCommands.reactorCommand(Arrays.asList(tokens));
                    break;
                case "Module":
                    result = managerCommands.moduleCommand(Arrays.asList(tokens));
                    break;
                case "Report":
                    result = managerCommands.reportCommand(Arrays.asList(tokens));
            }

            System.out.println(result);
            command = scanner.nextLine();
        }

        result = managerCommands.exitCommand(Arrays.asList(command.split(" ")));
        System.out.println(result);
    }
}
