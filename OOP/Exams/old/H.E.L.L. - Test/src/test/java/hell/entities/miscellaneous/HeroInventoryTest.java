package hell.entities.miscellaneous;

import hell.interfaces.Inventory;
import hell.interfaces.Item;
import hell.interfaces.Recipe;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class HeroInventoryTest {
    private final Item item = Mockito.mock(Item.class);
    private final Recipe recipe = Mockito.mock(Recipe.class);
    private final String NAME_ITEM = "Sword";
    private final String NAME_RECIPE = NAME_ITEM + "RECIPE";
    private final int STRENGHT_ITEM = 1;
    private final int AGILITY_ITEM = 1;
    private final int INTELIENCE_ITEM = 1;
    private final int HITPOINTS_ITEM = 1;
    private final int DEMAGE_ITEM = 1;
    private Inventory heroInventory;

    @Before
    public void setUp() {
        heroInventory = new HeroInventory();
        Mockito.when(item.getName()).thenReturn(NAME_ITEM);
    }

    private Item createCommonItemMock() {
        Item item = Mockito.mock(Item.class);
        Mockito.when(item.getStrengthBonus()).thenReturn(STRENGHT_ITEM);
        Mockito.when(item.getAgilityBonus()).thenReturn(AGILITY_ITEM);
        Mockito.when(item.getIntelligenceBonus()).thenReturn(INTELIENCE_ITEM);
        Mockito.when(item.getHitPointsBonus()).thenReturn(HITPOINTS_ITEM);
        Mockito.when(item.getDamageBonus()).thenReturn(DEMAGE_ITEM);

        return item;
    }

    private void seedCommonItem() {
        Item itemMock1 = this.createCommonItemMock();
        Item itemMock2 = this.createCommonItemMock();
        Item itemMock3 = this.createCommonItemMock();
        Mockito.when(itemMock1.getName()).thenReturn("1");
        Mockito.when(itemMock2.getName()).thenReturn("2");
        Mockito.when(itemMock3.getName()).thenReturn("3");

        this.heroInventory.addCommonItem(itemMock1);
        this.heroInventory.addCommonItem(itemMock2);
        this.heroInventory.addCommonItem(itemMock3);
    }

    private void seedRecipeItem() {
        Recipe recipeMock = Mockito.mock(Recipe.class);

        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("4");

        Mockito.when(recipeMock.getName()).thenReturn(NAME_RECIPE);
        Mockito.when(recipeMock.getRequiredItems()).thenReturn(list);
       this.heroInventory.addRecipeItem(recipeMock);
    }

    @Test
    public void addCommonItemShouldWorkCorrectly() {

        this.seedCommonItem();
        this.seedRecipeItem();

        Item item4 = createCommonItemMock();
        Mockito.when(item4.getName()).thenReturn("4");

        this.heroInventory.addCommonItem(item4);

        try {
            Field commonItems = this.heroInventory.getClass().getDeclaredField("commonItems");
            commonItems.setAccessible(true);
            assertEquals(2, ((Map<String, Item>) commonItems.get(heroInventory)).size());
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void checkRecipeItemSuccessCreated() {
        try {
            Field recipeItems = HeroInventory.class.getDeclaredField("recipeItems");
            recipeItems.setAccessible(true);
            assertEquals(0, ((Map<String, Item>) recipeItems.get(heroInventory)).size());
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void checkCommonItemSuccessCreated() {
        try {
            Field commonItems = HeroInventory.class.getDeclaredField("commonItems");
            commonItems.setAccessible(true);
            assertEquals(0, ((Map<String, Item>) commonItems.get(heroInventory)).size());
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getTotalStrengthBonusForNull() {
        //  Mockito.when(item.getStrengthBonus()).thenReturn(STRENGHT_ITEM);
        assertEquals(0, heroInventory.getTotalStrengthBonus());
    }

    @Test
    public void getTotalStrengthBonusShouldWorkCorrectly() {
        Mockito.when(item.getStrengthBonus()).thenReturn(STRENGHT_ITEM);
        this.heroInventory.addCommonItem(item);
        assertEquals(STRENGHT_ITEM, heroInventory.getTotalStrengthBonus());
    }

    @Test
    public void getTotalAgilityBonusForNull() {
        assertEquals(0, this.heroInventory.getTotalAgilityBonus());
    }

    @Test
    public void getTotalAgilityBonusShouldWorkForOneItem() {
        Mockito.when(item.getAgilityBonus()).thenReturn(AGILITY_ITEM);
        this.heroInventory.addCommonItem(item);
        assertEquals(AGILITY_ITEM, this.heroInventory.getTotalAgilityBonus());
    }

    @Test
    public void getTotalIntelligenceBonusForNull() {
        assertEquals(0, this.heroInventory.getTotalIntelligenceBonus());
    }

    @Test
    public void getTotalIntelligenceBonusShouldWorkForOneItem() {
        Mockito.when(item.getIntelligenceBonus()).thenReturn(INTELIENCE_ITEM);
        this.heroInventory.addCommonItem(item);
        assertEquals(INTELIENCE_ITEM, this.heroInventory.getTotalIntelligenceBonus());
    }

    @Test
    public void getTotalHitPointsBonusForNull() {
        assertEquals(0, this.heroInventory.getTotalHitPointsBonus());
    }

    @Test
    public void getTotalHitPointsBonusShouldWorkCorrectlyForOneItem() {
        Mockito.when(item.getHitPointsBonus()).thenReturn(HITPOINTS_ITEM);
        this.heroInventory.addCommonItem(item);
        assertEquals(HITPOINTS_ITEM, this.heroInventory.getTotalHitPointsBonus());
    }

    @Test
    public void getTotalDamageBonusForNull() {
        assertEquals(0, this.heroInventory.getTotalDamageBonus());
    }

    @Test
    public void getTotalDamageBonusWorkCorrectlyForOneItem() {
        Mockito.when(item.getDamageBonus()).thenReturn(DEMAGE_ITEM);
        this.heroInventory.addCommonItem(item);
        assertEquals(DEMAGE_ITEM, this.heroInventory.getTotalDamageBonus());
    }

    @Test(expected = NullPointerException.class)
    public void addCommonItemForNull() {
        this.heroInventory.addCommonItem(null);
    }

    @Test
    public void addRecipeItemShouldWorkCorrectlyForOneRecipe() {
        Mockito.when(recipe.getName()).thenReturn(NAME_RECIPE);
        List<String> list = new ArrayList<>();
        list.add(NAME_ITEM);
        Mockito.when(recipe.getRequiredItems()).thenReturn(list);
        this.heroInventory.addRecipeItem(recipe);
        try {
            Field recipeItems = HeroInventory.class.getDeclaredField("recipeItems");
            recipeItems.setAccessible(true);
            assertEquals(1, ((Map<String, Item>) recipeItems.get(heroInventory)).size());
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void addRecipeItemShouldWorkCorrectlyForOneRecipeNullStringName() {
        Mockito.when(recipe.getName()).thenReturn("");
        List<String> list = new ArrayList<>();
        list.add(NAME_ITEM);
        Mockito.when(recipe.getRequiredItems()).thenReturn(list);
        this.heroInventory.addRecipeItem(recipe);
        try {
            Field recipeItems = HeroInventory.class.getDeclaredField("recipeItems");
            recipeItems.setAccessible(true);
            assertEquals(1, ((Map<String, Item>) recipeItems.get(heroInventory)).size());
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void addRecipeItemShouldWorkCorrectlyForOneRecipeOtherNameItem() {
        Mockito.when(recipe.getName()).thenReturn(NAME_RECIPE);
        List<String> list = new ArrayList<>();
        list.add(NAME_ITEM + "TEST");
        Mockito.when(recipe.getRequiredItems()).thenReturn(list);
        this.heroInventory.addRecipeItem(recipe);
        try {
            Field recipeItems = HeroInventory.class.getDeclaredField("recipeItems");
            recipeItems.setAccessible(true);
            assertEquals(1, ((Map<String, Item>) recipeItems.get(heroInventory)).size());
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Test(expected = NullPointerException.class)
    public void addRecipeItemShouldThrowErrorForNull() {
        this.heroInventory.addRecipeItem(null);
    }
}