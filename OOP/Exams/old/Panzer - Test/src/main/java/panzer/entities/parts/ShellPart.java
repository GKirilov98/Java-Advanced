package panzer.entities.parts;

import panzer.contracts.DefenseModifyingPart;

import java.math.BigDecimal;

public class ShellPart extends PartsImpl implements DefenseModifyingPart {

    private int defenseModifier;

    public ShellPart(String model, double weight, BigDecimal price, int defenseModifier) {
        super(model, weight, price);
        this.defenseModifier = defenseModifier;
    }

    @Override
    public int getDefenseModifier() {
        return this.defenseModifier;
    }
}
