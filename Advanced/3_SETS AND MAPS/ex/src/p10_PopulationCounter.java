import java.util.LinkedHashMap;
import java.util.Scanner;

public class p10_PopulationCounter {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String command = console.nextLine();
        LinkedHashMap<String, Long> countriesPopulations = new LinkedHashMap<>();
        LinkedHashMap<String, LinkedHashMap<String, Long>> world = new LinkedHashMap<>();
        while (!command.equals("report")) {
            String[] tokens = command.split("\\|");
            String city = tokens[0];
            String country = tokens[1];
            long population = Long.parseLong(tokens[2]);
            if (!world.containsKey(country)) {
                world.put(country, new LinkedHashMap<>() {{ put(city, population); }});
                countriesPopulations.put(country, population);
            } else {
                if (!world.get(country).containsKey(city)) {
                    world.get(country).put(city, population);
                    countriesPopulations.put(country, countriesPopulations.get(country) + population);
                } else {
                    world.get(country).put(city, world.get(country).get(city) + population);
                    countriesPopulations.put(country, countriesPopulations.get(country) + population);
                }
            }

            command = console.nextLine();
        }

        Object[] sortedCountry =  countriesPopulations.keySet()
                .stream()
                .sorted((e1, e2) -> Long.compare(countriesPopulations.get(e2), countriesPopulations.get(e1)))
        .toArray();

        for (Object country : sortedCountry) {
            long totalPopulation = countriesPopulations.get(country);
            System.out.printf("%s (total population: %d)%n", country, totalPopulation);
            Object[] sortedCity =  world.get(country).keySet()
                    .stream()
                    .sorted((e1, e2) ->
                            Long.compare(world.get(country).get(e2), world.get(country).get(e1)))
                    .toArray();
            for (Object city : sortedCity) {
                System.out.printf("=>%s: %d%n", city, world.get(country).get(city));
            }
        }
    }
}
