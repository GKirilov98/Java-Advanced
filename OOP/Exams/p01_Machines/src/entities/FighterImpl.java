package entities;

import entities.abstractClasses.BaseMachine;
import entities.interfaces.Fighter;

public class FighterImpl extends BaseMachine implements Fighter {
    private static final double FIGHTER_BASE_HEALTHPOINTS = 200;

    private boolean aggressiveMode;

    public FighterImpl(String name, double attackPoints, double defensePoints) {
        super(name, attackPoints, defensePoints, FIGHTER_BASE_HEALTHPOINTS);
        this.aggressiveMode = true;
        this.toggleAggressiveMode();
    }

    @Override
    public boolean getAggressiveMode() {
        return this.aggressiveMode;
    }

    @Override
    public void toggleAggressiveMode() {
        if (aggressiveMode) {
            this.setAttackPoints(this.getAttackPoints()  + 50);
            this.setDefensePoints(this.getDefensePoints() - 25);
            aggressiveMode = false;
        } else {
            this.setAttackPoints(this.getAttackPoints()  - 50);
            this.setDefensePoints(this.getDefensePoints() + 25);
            aggressiveMode = true;
        }
    }

    @Override
    public String toString() {
        String targets = "";
        for (String s : this.getTargets()) {
            targets += s + ", ";
        }
        if (targets.length() == 0) {
            targets = "None";
        } else {
            targets = targets.substring(0, targets.length() - 2);
        }

        String agrresive = "ON";
        if (this.getAggressiveMode()) {
            agrresive = "OFF";
        }
        return String.format(
                        "\n- %s\n" +
                        " *Type: Fighter\n" +
                        " *Health: %.2f\n" +
                        " *Attack: %.2f\n" +
                        " *Defense: %.2f\n" +
                        " *Targets: %s\n" +
                        " *Aggressive Mode(%s)",
                this.getName(),
                this.getHealthPoints(), this.getAttackPoints(), this.getDefensePoints(),
                targets, agrresive);
    }
}
