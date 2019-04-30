package core;

import common.OutputMessages;
import core.interfaces.MachineFactory;
import core.interfaces.PilotFactory;
import core.interfaces.MachinesManager;

import entities.FighterImpl;
import entities.PilotImpl;
import entities.TankImpl;
import entities.interfaces.Fighter;
import entities.interfaces.Machine;
import entities.interfaces.Pilot;
import entities.interfaces.Tank;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MachinesManagerImpl implements MachinesManager {

    private Map<String, Pilot> pilots;
    private Map<String, Machine> machines;
    private List<String> occupied;

    public MachinesManagerImpl(PilotFactory pilotFactory, MachineFactory machineFactory, Map<String, Pilot> pilots, Map<String, Machine> machines) {
        this.pilots = pilots;
        this.machines = machines;
        occupied = new ArrayList<>();
    }


    @Override
    public String hirePilot(String name) {
        if (this.pilots.containsKey(name)) {
            return String.format(OutputMessages.pilotExists, name);
        }

        Pilot pilot = new PilotImpl(name);
        this.pilots.put(name, pilot);
        return String.format(OutputMessages.pilotHired, name);
    }

    @Override
    public String manufactureTank(String name, double attackPoints, double defensePoints) {
        if (this.machines.containsKey(name)) {
            return String.format(OutputMessages.machineExists, name);
        }

        Tank tank = new TankImpl(name, attackPoints, defensePoints);
        this.machines.put(name, tank);
        return String.format(OutputMessages.tankManufactured, name, attackPoints, defensePoints);
    }

    @Override
    public String manufactureFighter(String name, double attackPoints, double defensePoints) {
        if (this.machines.containsKey(name)) {
            return String.format(OutputMessages.machineExists, name);
        }

        Fighter fighter = new FighterImpl(name, attackPoints, defensePoints);
        this.machines.put(name, fighter);
        return String.format(OutputMessages.fighterManufactured, name, attackPoints, defensePoints);
    }

    @Override
    public String engageMachine(String selectedPilotName, String selectedMachineName) {
        if (!this.pilots.containsKey(selectedPilotName)) {
            return String.format(OutputMessages.pilotNotFound, selectedPilotName);
        }

        if (this.occupied.contains(selectedMachineName)){
            return String.format(OutputMessages.machineHasPilotAlready, selectedMachineName);
        }

        if (!this.machines.containsKey(selectedMachineName)) {
            return String.format(OutputMessages.machineNotFound, selectedMachineName);
        }

        if (this.pilots.containsKey(selectedPilotName) && this.machines.containsKey(selectedMachineName)) {
            Pilot pilot = this.pilots.get(selectedPilotName);
             boolean hasSameMachine = false;
        for (Machine m : pilot.getMachines()) {
            if (m.getName().equals(selectedMachineName)) {
                hasSameMachine = true;
                break;
            }
        }
        if (hasSameMachine) {
            return String.format(OutputMessages.machineHasPilotAlready, selectedMachineName);
        }

            Machine machine = this.machines.get(selectedMachineName);
            pilot.addMachine(machine);
            occupied.add(selectedMachineName);
            return String.format(OutputMessages.machineEngaged, selectedPilotName, selectedMachineName);
        }

        return null;
    }

    @Override
    public String attackMachines(String attackingMachineName, String defendingMachineName) {
        if (!this.machines.containsKey(attackingMachineName)) {
            return String.format(OutputMessages.machineNotFound, attackingMachineName);
        }
        if (!this.machines.containsKey(defendingMachineName)) {
            return String.format(OutputMessages.machineNotFound, defendingMachineName);
        }

        Machine firsMachine = this.machines.get(attackingMachineName);
        Machine secondMachine = this.machines.get(defendingMachineName);

        firsMachine.getTargets().add(defendingMachineName);
        if (firsMachine.getAttackPoints() > secondMachine.getDefensePoints()) {

            double healthSecond =
                    secondMachine.getHealthPoints() -
                            (firsMachine.getAttackPoints() - secondMachine.getDefensePoints());
            secondMachine.setHealthPoints(healthSecond);

            if (secondMachine.getHealthPoints() < 0) {
                secondMachine.setHealthPoints(0);
            }

            return String.format(OutputMessages.attackSuccessful, defendingMachineName, attackingMachineName, healthSecond);
        }

        // TODO: 4/14/2019
        return null;
    }

    @Override
    public String pilotReport(String pilotName) {
        if (this.pilots.containsKey(pilotName)) {
            Pilot pilot = this.pilots.get(pilotName);
            return pilot.report();
        }

        return String.format(OutputMessages.pilotNotFound, pilotName);
    }

    @Override
    public String toggleFighterAggressiveMode(String fighterName) {
        if (this.machines.containsKey(fighterName)) {
            if (this.machines.get(fighterName).getClass().getSimpleName().equals("FighterImpl")) {
                FighterImpl fighter = (FighterImpl) this.machines.get(fighterName);
                fighter.toggleAggressiveMode();
                return String.format(OutputMessages.fighterOperationSuccessful, fighterName);
            }
        }

        return String.format(OutputMessages.notSupportedOperation, fighterName);
    }

    @Override
    public String toggleTankDefenseMode(String tankName) {
        if (this.machines.containsKey(tankName)) {
            if (this.machines.get(tankName).getClass().getSimpleName().equals("TankImpl")){
                Tank tank = (TankImpl) this.machines.get(tankName);
                tank.toggleDefenseMode();
                return String.format(OutputMessages.tankOperationSuccessful, tankName);
            }
        }

        return  String.format(OutputMessages.notSupportedOperation, tankName);
    }
}
