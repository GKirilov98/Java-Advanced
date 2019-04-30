import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Stream;

public class p12_LegendaryFarming {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        TreeMap<String, Integer> remainingShard = new TreeMap<>() {{
            put("fragments", 0);
            put("motes", 0);
            put("shards", 0);
        }};
        TreeMap<String, Integer> junks = new TreeMap<>();
        int shadowmourne = 0;
        int valanyr = 0;
        int dragonwrath = 0;
        while (shadowmourne < 250 && valanyr < 250 && dragonwrath < 250) {
            String[] tokens = console.nextLine().toLowerCase().split(" ");
            for (int i = 0; i < tokens.length; i += 2) {
                if (shadowmourne >= 250 || valanyr >= 250 || dragonwrath >= 250){
                    break;
                }
                int quantity = Integer.parseInt(tokens[i]);
                String material = tokens[i + 1];
                switch (material) {
                    case "shards":
                        shadowmourne += quantity;
                        remainingShard.put("shards", remainingShard.get("shards") + quantity);
                        break;
                    case "fragments":
                        valanyr += quantity;
                        remainingShard.put("fragments", remainingShard.get("fragments") + quantity);
                        break;
                    case "motes":
                        dragonwrath += quantity;
                        remainingShard.put("motes", remainingShard.get("motes") + quantity);
                        break;
                    default:
                        if (!junks.containsKey(material)) {
                            junks.put(material, quantity);
                        } else {
                            junks.put(material, quantity + junks.get(material));
                        }
                }
            }
        }

        if (shadowmourne >= 250){
            remainingShard.put("shards", remainingShard.get("shards") - 250);
            System.out.println("Shadowmourne obtained!");
        } else if (valanyr >= 250){
            remainingShard.put("fragments", remainingShard.get("fragments") - 250);
           System.out.println("Valanyr obtained!");
        } else {
            remainingShard.put("motes", remainingShard.get("motes") - 250);
           System.out.println("Dragonwrath obtained!");
        }

            Stream<String> sortedMaterial = remainingShard.keySet().stream()
                .sorted((e1, e2) -> Integer.compare(remainingShard.get(e2),
                        remainingShard.get(e1)));
        for (Object mat : sortedMaterial.toArray()) {
            System.out.printf("%s: %d%n", mat, remainingShard.get(mat));
        }

        for (String j : junks.keySet()) {
            System.out.printf("%s: %d%n", j, junks.get(j));
        }
    }
}
