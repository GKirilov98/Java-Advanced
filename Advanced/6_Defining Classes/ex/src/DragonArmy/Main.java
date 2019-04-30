package DragonArmy;

import java.util.*;

public class Main {
    private static Map<String, Map<String, Dragon>> typesDragon = new LinkedHashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        List<String> ah = new ArrayList<>();
        ArrayList<String> ah2 = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String type = tokens[0];
            String name = tokens[1];
            String demage = tokens[2];
            String health = tokens[3];
            String armor = tokens[4];

            typesDragon.putIfAbsent(type, new TreeMap<>());
            if (typesDragon.get(type).containsKey(name)) {
                typesDragon.get(type).get(name).setArmor(armor);
                typesDragon.get(type).get(name).setHealth(health);
                typesDragon.get(type).get(name).setDemage(demage);
            } else {
                typesDragon.get(type).put(name, new Dragon(name, demage, health, armor));
            }
        }

        printTypesDragon();
    }

    private static void printTypesDragon() {
        for (String type : typesDragon.keySet()) {
            double avDemage = 0;
            double avHealth = 0;
            double avArmor = 0;
            int counter = 0;
            StringBuilder stringBuilder = new StringBuilder();
            for (Dragon dragon : typesDragon.get(type).values()) {
                counter++;
                avDemage += dragon.getDemage();
                avHealth += dragon.getHealth();
                avArmor += dragon.getArmor();

                stringBuilder.append(String.format("-%s -> damage: %d, health: %d, armor: %d\n", dragon.getName(), dragon.getDemage(), dragon.getHealth(), dragon.getArmor()));
            }

            avDemage /= counter;
            avHealth /= counter;
            avArmor /= counter;

            System.out.printf("%s::(%.2f/%.2f/%.2f)\n", type, avDemage, avHealth, avArmor);
            System.out.print(stringBuilder);
        }
    }


}
