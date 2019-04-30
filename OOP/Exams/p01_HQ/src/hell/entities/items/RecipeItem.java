package hell.entities.items;

import hell.entities.miscellaneous.ItemCollection;
import hell.interfaces.Recipe;

import java.util.List;

public class RecipeItem extends ItemUni implements Recipe {
    @ItemCollection
    private List<CommonItem> requiredItems;

    public RecipeItem(String name, int strengthBonus, int agilityBonus, int intelligenceBonus, int hitPointsBonus, int damageBonus, List<CommonItem> requiredItems) {
        super(name, strengthBonus, agilityBonus, intelligenceBonus, hitPointsBonus, damageBonus);
        this.requiredItems = requiredItems;
    }

    public List<String> getRequiredItems() {
        return null;
    }

    //    @Override
//    public List<String> getRequiredItems() {
//        return requiredItems;
//    }
}
