package p06_MelitariElite;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Private> privateMap = new HashMap<>();

        while (true) {
            String inputLine = reader.readLine();

            if ("End".equals(inputLine)) {
                break;
            }

            String[] tokens = inputLine.split(" ");

            String soldier = tokens[0];

            String id = tokens[1];
            String firstName = tokens[2];
            String lastName = tokens[3];

            switch (soldier) {
                case "Private":
                    double salary = Double.parseDouble(tokens[4]);
                    Private privates = new Private(id, firstName, lastName, salary);
                    privateMap.putIfAbsent(id, privates);
                    System.out.println(privates);
                    break;
                case "LeutenantGeneral":
                    salary = Double.parseDouble(tokens[4]);
                    LeutenantGeneral leutenantGeneral = new LeutenantGeneral(id, firstName, lastName, salary);
                    for (int i = 5; i < tokens.length; i++) {
                        String idtoAdd = tokens[i];
                        if (privateMap.containsKey(idtoAdd)){
                            leutenantGeneral.addPrivate(privateMap.get(idtoAdd));
                        }
                    }
                    System.out.print(leutenantGeneral);
                    break;
                case "Engineer":
                    salary = Double.parseDouble(tokens[4]);
                    String corp = tokens[5];
                    try {
                        Engineer engineer = new Engineer(id, firstName, lastName, salary, corp);
                        for (int i = 6; i < tokens.length; i += 2) {
                            String item = tokens[i];
                            int hour = Integer.parseInt(tokens[i + 1]);
                            Repair repair = new Repair(item, hour);
                            engineer.addRepair(repair);
                        }
                        System.out.print(engineer);
                    } catch (IllegalArgumentException ignored) {

                    }
                    break;
                case "Commando":
                    salary = Double.parseDouble(tokens[4]);
                    corp = tokens[5];
                    try {
                        Commando commando = new Commando(id, firstName, lastName, salary, corp);
                        for (int i = 6; i < tokens.length; i += 2) {
                            String missionName = tokens[i];
                            String state = tokens[i + 1];
                            try {
                                Mission mission = new Mission(missionName, state);
                                commando.addMission(mission);
                            } catch (IllegalArgumentException ignored) {

                            }
                        }

                        System.out.print(commando);
                    } catch (IllegalArgumentException ignored) {

                    }
                    break;
                case "Spy":
                    String codeNumber = tokens[4];
                    Spy spy = new Spy(id, firstName, lastName, codeNumber);
                    System.out.println(spy);
                    break;
            }
        }
    }
}
