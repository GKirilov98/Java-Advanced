package p06_PokemonTrainer;

import java.util.ArrayList;
import java.util.List;

public class Trainer {
    public String name;
    public Integer badges;
    public List<Pokemon> pokemonList;

    public Trainer(String name, String PokemonName, String PokemonElement, int PokemonHealth)
    {
        this.name = name;
        this.badges = 0;
        pokemonList = new ArrayList<>();
        AddPokemon(PokemonName, PokemonElement, PokemonHealth);
    }
    public void AddPokemon(String name, String element, int health)
    {
        Pokemon pokemon = new Pokemon(name, element, health);
        pokemonList.add(pokemon);
    }
}
