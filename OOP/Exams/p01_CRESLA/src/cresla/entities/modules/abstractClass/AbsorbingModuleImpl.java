package cresla.entities.modules.abstractClass;

import cresla.interfaces.AbsorbingModule;

public abstract class AbsorbingModuleImpl extends ModulesImpl implements AbsorbingModule {
    private int heatAbsorbing;
    protected AbsorbingModuleImpl(int id, int heatAbsorbing) {
        super(id);
        this.heatAbsorbing = heatAbsorbing;
    }

    @Override
    public int getHeatAbsorbing() {
        return heatAbsorbing;
    }
}