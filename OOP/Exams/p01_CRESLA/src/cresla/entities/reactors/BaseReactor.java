package cresla.entities.reactors;

import cresla.entities.containers.ModuleContainer;
import cresla.interfaces.AbsorbingModule;
import cresla.interfaces.Container;
import cresla.interfaces.EnergyModule;
import cresla.interfaces.Reactor;

public abstract class BaseReactor implements Reactor {
    private int id;
    private Container moduleContainer;

    BaseReactor(int id, int moduleCapacity ) {
        this.id = id;
        moduleContainer = new ModuleContainer(moduleCapacity);
    }

    @Override
    public long getTotalEnergyOutput() {
        return this.moduleContainer.getTotalEnergyOutput() ;
    }

    @Override
    public long getTotalHeatAbsorbing() {
        return this.moduleContainer.getTotalHeatAbsorbing();
    }

    @Override
    public int getModuleCount() {
      return this.moduleContainer.getModuleByInputCount();
    }

    @Override
    public void addEnergyModule(EnergyModule energyModule) {
        this.moduleContainer.addEnergyModule(energyModule);
    }

    @Override
    public void addAbsorbingModule(AbsorbingModule absorbingModule) {
        this.moduleContainer.addAbsorbingModule(absorbingModule);
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public String toString() {
      return   String.format("%s - %d\n" +
                        "Energy Output: %d\n" +
                        "Heat Absorbing: %d\n" +
                        "Modules: %d",
                this.getClass().getSimpleName(), this.getId(),
                this.getTotalEnergyOutput(),
                this.getTotalHeatAbsorbing(),
                this.getModuleCount());
    }
}
