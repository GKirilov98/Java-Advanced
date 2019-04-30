package cresla.entities.modules.abstractClass;

import cresla.interfaces.EnergyModule;

public abstract class EnergyModuleImpl extends ModulesImpl implements EnergyModule {
    private int energyOutput;
    protected EnergyModuleImpl(int id, int energyOutput) {
        super(id);
        this.energyOutput = energyOutput;
    }

    @Override
    public int getEnergyOutput() {
        return this.energyOutput;
    }

}
