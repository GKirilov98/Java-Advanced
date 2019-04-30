package p04_Agents;

import java.util.*;

public class Main {

   static class Agents {
        private  String name;
        private  LinkedHashMap<String, Double> missions;

        public Agents(String name) {
            this.name = name;
            this.missions = new LinkedHashMap<>();
        }

        public LinkedHashMap<String, Double> getMissions() {
            return missions;
        }

        public void setMissions(LinkedHashMap<String, Double> missions) {
            this.missions = missions;
        }

        public Double getRate(){
            if (missions.size() == 0){
                return -1.0;
            }

            return missions.values().stream().reduce((a, c) -> a + c).get();
        }
    }

    static LinkedHashMap<String, Double> allMisions = new LinkedHashMap<>();
    static HashSet<String> allAgents = new HashSet<>();
    static LinkedHashMap<String, Agents> validAgents = new LinkedHashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        while (!line.equals("registration")) {
            if (line.startsWith("#")) {
                String[] tokens = line.split(":");
                addMission(tokens[0], Double.parseDouble(tokens[1]));
            } else if (line.charAt(line.length() - 3) == '0') {
                addAgent(line);
            }

            line = scanner.nextLine();
        }

        String command = scanner.nextLine();
        while (!command.equals("operate")) {
            String[] tokens = command.split("->");
            switch (tokens[0]) {
                case "assign":
                    assignedMissions(tokens[1], tokens[2]);
                    break;
                case "abort":
                    abortMission(tokens[1]);
                    break;
                case "change":
                    changeMissions(tokens[1], tokens[2]);
                    break;
            }

            command = scanner.nextLine();
        }

        sortAndPrintAgents();
    }

    private static void changeMissions(String firstAgent, String secondAgent) {
        LinkedHashMap<String, Double> firstAgentMissions = new LinkedHashMap<>(
                validAgents.get(firstAgent).getMissions());

        LinkedHashMap<String, Double> secondAgentMissions = new LinkedHashMap<>(
                validAgents.get(secondAgent).getMissions());

        validAgents.get(firstAgent).getMissions().clear();
        validAgents.get(firstAgent).getMissions().putAll(secondAgentMissions);
        validAgents.get(secondAgent).getMissions().clear();
        validAgents.get(secondAgent).getMissions().putAll(firstAgentMissions);

    }

    private static void sortAndPrintAgents() {
        StringBuilder stringBuilder = new StringBuilder();
        ArrayList<String> sortedAgents = new ArrayList<>();
        validAgents
                .entrySet()
                .stream()
                .sorted((a, b) -> b.getValue().getRate().compareTo(a.getValue().getRate()))
                .forEach( e ->
            sortedAgents.add(e.getKey()));
        for (String agent : sortedAgents) {
            if (validAgents.get(agent).getMissions().size() == 0) {
                continue;
            }

            stringBuilder.append(String.format("Agent: %s - Total Rating: %.2f\n", agent, validAgents.get(agent).getRate()));
            LinkedHashMap<String, Double> missions = validAgents.get(agent).getMissions();
            for (String mission : missions.keySet()) {
                stringBuilder.append(
                        String.format(" - %s -> %.2f\n", mission, missions.get(mission)));
            }
        }

        System.out.println(stringBuilder);
    }

    private static void abortMission(String mission) {
        for (String agent : validAgents.keySet()) {
            LinkedHashMap<String, Double> missions = validAgents.get(agent).getMissions();
            missions.remove(mission);
        }
    }

    private static void assignedMissions(String agent, String mission) {
        if (allMisions.containsKey(mission) && allAgents.contains(agent)) {
            validAgents.putIfAbsent(agent, new Agents(agent));
            validAgents.get(agent).getMissions().putIfAbsent(mission, allMisions.get(mission));
        }
    }

    private static void addAgent(String name) {
        allAgents.add(name);
    }

    private static void addMission(String name, double rate) {
        allMisions.put(name, rate);
    }
}
