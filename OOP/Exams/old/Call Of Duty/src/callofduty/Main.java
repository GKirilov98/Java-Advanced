package callofduty;

import callofduty.domain.agents.MissionManagerImpl;
import callofduty.interfaces.MissionManager;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        MissionManager missionManager = new MissionManagerImpl();
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        String result = "";
        while (!command.equals("Over")) {
            List<String> tokens = Arrays.stream(command.split(" ")).collect(Collectors.toList());
            switch (tokens.get(0)){
                case "Agent":
                    result =  missionManager.agent(tokens);
                    break;
                case "Request":
                    result =  missionManager.request(tokens);
                    break;
                case "Complete":
                    result =  missionManager.complete(tokens);
                    break;
                case "Status":
                    result =  missionManager.status(tokens);
                    break;
            }

            System.out.println(result);

            command = scanner.nextLine();
        }

        result = missionManager.over(Collections.emptyList());
        System.out.println(result);
    }
}




