package cresla.entities.modules;

import cresla.entities.modules.abstractClass.AbsorbingModuleImpl;

public class CooldownSystem extends AbsorbingModuleImpl {

    public CooldownSystem(int id, int heatAbsorbing) {
        super(id, heatAbsorbing);
    }

    @Override
    public String toString() {
        return String.format("CooldownSystem Module – %d\n" +
                        "Heat Absorbing: %d",
                this.getId(),
                this.getHeatAbsorbing());
    }
}
