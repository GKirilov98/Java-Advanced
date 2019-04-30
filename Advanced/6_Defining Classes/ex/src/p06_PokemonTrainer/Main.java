package p06_PokemonTrainer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    static List<Trainer> trainers;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        int pokemonsCount = 0;

        trainers = new ArrayList<>();
        String input = scanner.nextLine();
        while (!input.equals("Tournament")) {
            String[] trainerInfo = input.split("\\s+");

            Trainer trainer;
            if ((trainer = ContainTrainer(trainerInfo[0])) == null) {
                trainer = new Trainer(trainerInfo[0], trainerInfo[1], trainerInfo[2], Integer.parseInt(trainerInfo[3]));
                trainers.add(trainer);
            } else
                trainer.AddPokemon(trainerInfo[1], trainerInfo[2], Integer.parseInt(trainerInfo[3]));
            input = scanner.nextLine();
        }
        String elementInput = scanner.nextLine().trim();
        while (!elementInput.equals("End")) {
            for (Trainer currentTrainer : trainers) {
                for (Pokemon pokemon : currentTrainer.pokemonList) {
                    if (pokemon.element.equals(elementInput) && pokemon.health > 0) {
                        count++;
                    }
                }
                if (count > 0)
                    currentTrainer.badges++;
                else {
                    for (Pokemon pokemon : currentTrainer.pokemonList) {
                        pokemon.health -= 10;
                    }
                }
                count = 0;
            }

            elementInput = scanner.nextLine().trim();
        }

        for (Trainer currentTrainer :
                trainers.stream().sorted((a, b) -> b.badges.compareTo(a.badges)).collect(Collectors.toList())) {
            for (Pokemon pokemon : currentTrainer.pokemonList) {
                if (pokemon.health > 0) {
                    pokemonsCount++;
                }
            }
            System.out.println(currentTrainer.name + " " + currentTrainer.badges + " " + pokemonsCount);
            pokemonsCount = 0;
        }
    }


    static Trainer ContainTrainer(String name) {
        for (Trainer item : trainers) {
            if (item.name.equals(name)) {
                return item;
            }
        }
        return null;
    }
}
