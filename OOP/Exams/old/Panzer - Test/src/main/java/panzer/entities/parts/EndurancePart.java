package panzer.entities.parts;

import panzer.contracts.HitPointsModifyingPart;

import java.math.BigDecimal;

public class EndurancePart extends PartsImpl implements HitPointsModifyingPart {
    private int hitPointsModifier;

    public EndurancePart(String model, double weight, BigDecimal price, int hitPointsModifier) {
        super(model, weight, price);
        this.hitPointsModifier = hitPointsModifier;
    }

    @Override
    public int getHitPointsModifier() {
        return this.hitPointsModifier;
    }
}
