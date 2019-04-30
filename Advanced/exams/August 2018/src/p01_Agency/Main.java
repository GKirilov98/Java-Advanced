package p01_Agency;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] entryID = scanner.nextLine().split("\\s+");
        ArrayDeque<String> allEntryID = new ArrayDeque<>();
        Arrays.stream(entryID).forEach(allEntryID::push);
        String[] entryAgents = scanner.nextLine().split("\\s+");
        ArrayDeque<String> allAgents = new ArrayDeque<>(Arrays.asList(entryAgents));
        String command = scanner.nextLine();
        while (!command.equals("stop")) {
            String[] tokens = command.split("\\s+");
            if (tokens.length == 2) {
                if (tokens[0].equals("add-ID")) {
                    allEntryID.push(tokens[1]);
                } else {
                    allAgents.add(tokens[1]);
                }
            } else {
                if (tokens[0].equals("remove-ID")) {
                    System.out.println(allEntryID.pop() + " has been removed.");
                } else if (tokens[0].equals("remove-agent")) {
                    System.out.println(allAgents.removeLast() + " has left the queue.");
                } else {
                    allEntryID = allEntryID.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toCollection(ArrayDeque::new));
                }
            }

            command = scanner.nextLine();
        }

        while (!allAgents.isEmpty() && !allEntryID.isEmpty()) {
            System.out.println(allAgents.poll() + " takes ID number: " + allEntryID.pop());
        }

        if (allAgents.size() == 0 && allEntryID.size() == 0) {
            return;
        }

        if (allAgents.size() != 0) {
            while (!allAgents.isEmpty()) {
                System.out.println(allAgents.poll() + " does not have an ID.");
            }
        } else {
            System.out.println("No more agents left.");
            while (!allEntryID.isEmpty()) {
                System.out.println("ID number: " + allEntryID.pop());
            }
        }
    }
}
