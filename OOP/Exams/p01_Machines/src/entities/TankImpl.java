package entities;

import entities.abstractClasses.BaseMachine;
import entities.interfaces.Tank;

public class TankImpl extends BaseMachine implements Tank {
    private static final double TANK_BASE_HEALTHPOINTS = 100;

    private boolean defenseMode;
    private double attackPointsModifier;
    private double deffencePointsModifier;

    public TankImpl(String name, double attackPoints, double defensePoints) {
        super(name, attackPoints, defensePoints, TANK_BASE_HEALTHPOINTS);
        this.defenseMode = true;
        toggleDefenseMode();
    }

    @Override
    public boolean getDefenseMode() {
        return defenseMode;
    }

    @Override
    public void toggleDefenseMode() {
        if (defenseMode){
            this.setAttackPoints(this.getAttackPoints() - 40);
            this.setDefensePoints(this.getDefensePoints() + 30);
            defenseMode = false;
        } else {
            this.setAttackPoints(this.getAttackPoints() + 40);
            this.setDefensePoints(this.getDefensePoints() - 30);
            defenseMode = true;
        }
    }

    @Override
    public String toString() {
        String targets = "";
        for (String s : this.getTargets()) {
            targets += s + ", ";
        }
        if (targets.length() == 0){
            targets = "None";
        } else {
            targets = targets.substring(0, targets.length() - 2);
        }

        String agrresive = "ON";
        if (this.getDefenseMode()){
            agrresive = "OFF";
        }
        return   String.format(
                        "\n- %s\n" +
                        " *Type: Tank\n" +
                        " *Health: %.2f\n" +
                        " *Attack: %.2f\n" +
                        " *Defense: %.2f\n" +
                        " *Targets: %s\n" +
                        " *Defense Mode(%s)",
                this.getName(),
                this.getHealthPoints(), this.getAttackPoints(), this.getDefensePoints(),
                targets, agrresive);
    }
}
