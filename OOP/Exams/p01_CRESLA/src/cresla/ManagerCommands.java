package cresla;

import cresla.entities.modules.CooldownSystem;
import cresla.entities.modules.CryogenRod;
import cresla.entities.modules.HeatProcessor;
import cresla.entities.reactors.CryoReactor;
import cresla.entities.reactors.HeatReactor;
import cresla.interfaces.*;
import cresla.interfaces.Module;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ManagerCommands implements Manager {

    private int nextId;
    private Map<Integer, Reactor> allReactors ;
    private Map<Integer, Module> allModules;
    private int cryoReactorCount;
    private int heatReactorCount;
    private int energyModuleCount;
    private int absorbingModuleCount;


    public ManagerCommands() {
        this.nextId = 1;
        this.allReactors = new HashMap<>();
        this.allModules = new HashMap<>();
        this.cryoReactorCount = 0;
        this.heatReactorCount = 0;
        this.energyModuleCount = 0;
        this.absorbingModuleCount = 0;
    }



    @Override
    public String reactorCommand(List<String> arguments) {
       // •	Reactor {reactorType} {additionalParameter} {moduleCapacity}
       Reactor reactor;
        String type = arguments.get(arguments.size() - 3);
        int additionalParameter = Integer.parseInt(arguments.get(arguments.size() - 2));
        int moduleCapacity = Integer.parseInt(arguments.get(arguments.size()-1));
        if ("Cryo".equals(type)) {
            reactor = new CryoReactor(nextId, additionalParameter, moduleCapacity);
            cryoReactorCount++;
            nextId++;
        } else {
            reactor = new HeatReactor(nextId, additionalParameter, moduleCapacity);
            heatReactorCount++;
            nextId++;
        }

        allReactors.put(reactor.getId(), reactor);
        return String.format("Created %s Reactor - %d", type, reactor.getId());
    }

    @Override
    public String moduleCommand(List<String> arguments) {
        //••	Module {reactorId} {type} {additionalParameter}
        int reactorId = Integer.parseInt(arguments.get(arguments.size() - 3));
        String type = arguments.get(arguments.size() - 2);
        int additionalParameter = Integer.parseInt(arguments.get(arguments.size() - 1));

        Reactor reactor = this.allReactors.get(reactorId);
        Module module;

        switch (type) {
            case "CryogenRod":
                module = new CryogenRod(nextId, additionalParameter);
                reactor.addEnergyModule((EnergyModule) module);
                energyModuleCount++;
                nextId++;
                break;
            case "HeatProcessor":
                module = new HeatProcessor(nextId, additionalParameter);
                reactor.addAbsorbingModule((AbsorbingModule) module);
                absorbingModuleCount++;
                nextId++;
                break;
            case "CooldownSystem":
                module = new CooldownSystem(nextId, additionalParameter);
                reactor.addAbsorbingModule((AbsorbingModule) module);
                absorbingModuleCount++;
                nextId++;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + type);
        }

        allModules.put(module.getId(), module);
        return String.format("Added %s - %s to Reactor - %s",
                type, module.getId(), reactor.getId());
    }

    @Override
    public String reportCommand(List<String> arguments) {
        int id = Integer.parseInt(arguments.get(arguments.size() - 1));
        String result = "";
        if (this.allReactors.containsKey(id)) {
            result = this.allReactors.get(id).toString();
        } else if (this.allModules.containsKey(id)) {
            result = this.allModules.get(id).toString();
        }

        return result;
    }

    @Override
    public String exitCommand(List<String> arguments) {
        long energyOutput = 0;
        long heatAbsorbing = 0;

        for (Reactor value : allReactors.values()) {
            energyOutput += value.getTotalEnergyOutput();
            heatAbsorbing += value.getTotalHeatAbsorbing();
        }

        return String.format(
                "Cryo Reactors: %d\nHeat Reactors: %d\nEnergy Modules: %d\nAbsorbing Modules: %d\nTotal Energy Output: %d\nTotal Heat Absorbing: %d",
                cryoReactorCount,
                heatReactorCount,
                energyModuleCount,
                absorbingModuleCount,
                energyOutput,
                heatAbsorbing);
    }
}
