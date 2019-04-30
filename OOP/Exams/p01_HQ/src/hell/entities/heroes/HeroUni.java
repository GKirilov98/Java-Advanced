package hell.entities.heroes;

import hell.entities.miscellaneous.HeroInventory;
import hell.interfaces.Hero;
import hell.interfaces.Inventory;
import hell.interfaces.Item;
import hell.interfaces.Recipe;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class HeroUni implements Hero {
    private String name;
    private long strength;
    private long agility;
    private long intelligence;
    private long hitPoints;
    private long damage;
    private List<Item> items;
    private Inventory heroInventory;

    HeroUni(String name, long strength, long agility, long intelligence, long hitPoints, long damage) {
        this.setName(name);
        this.setStrength(strength);
        this.setAgility(agility);
        this.setIntelligence(intelligence);
        this.setHitPoints(hitPoints);
        this.setDamage(damage);
        this.items = new ArrayList<>();
        this.heroInventory = new HeroInventory();
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setStrength(long strength) {
        this.strength = strength;
    }

    private void setAgility(long agility) {
        this.agility = agility;
    }

    private void setIntelligence(long intelligence) {
        this.intelligence = intelligence;
    }

    private void setHitPoints(long hitPoints) {
        this.hitPoints = hitPoints;
    }

    private void setDamage(long damage) {
        this.damage = damage;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public long getStrength() {
        return this.strength + this.heroInventory.getTotalStrengthBonus();
    }

    @Override
    public long getAgility() {
        return this.agility + this.heroInventory.getTotalAgilityBonus();
    }

    @Override
    public long getIntelligence() {
        return this.intelligence + this.heroInventory.getTotalIntelligenceBonus();
    }

    @Override
    public long getHitPoints() {
        return this.hitPoints + this.heroInventory.getTotalHitPointsBonus();
    }

    @Override
    public long getDamage() {
        return this.damage + this.heroInventory.getTotalDamageBonus();
    }

    @Override
    public Collection<Item> getItems() {
        return this.items;
    }

    @Override
    public void addItem(Item item) {
        this.items.add(item);
    }

    @Override
    public void addRecipe(Recipe recipe) {
      //  this.heroInventory.
    }
}
