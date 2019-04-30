package panzer.entities.parts;

import panzer.contracts.AttackModifyingPart;

import java.math.BigDecimal;

public class ArsenalPart extends PartsImpl implements AttackModifyingPart {
    private int attackModifier;

    public ArsenalPart(String model, double weight, BigDecimal price, int attackModifier) {
        super(model, weight, price);
        this.attackModifier = attackModifier;
    }

    @Override
    public int getAttackModifier() {
        return this.attackModifier;
    }

//    @Override
//    public String toString() {
////        return String.format("Arsenal Part – {partModel}\n" +
////                "+{additionalParamValue} {additionalParam}"
////        ,super.getModel(), this.getAttackModifier());
//    }
}
