package cresla.entities.modules;

import cresla.entities.modules.abstractClass.EnergyModuleImpl;

public class CryogenRod extends EnergyModuleImpl {
    public CryogenRod(int id, int energyOutput) {
        super(id, energyOutput);
    }

    @Override
    public String toString() {
        return String.format("CryogenRod Module – %d\n" +
                "Energy Output: %d",
                this.getId(),
                this.getEnergyOutput());
    }
}
