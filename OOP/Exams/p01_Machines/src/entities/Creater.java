package entities;

import core.interfaces.MachineFactory;
import core.interfaces.PilotFactory;
import entities.interfaces.Fighter;
import entities.interfaces.Pilot;
import entities.interfaces.Tank;

public class Creater implements MachineFactory, PilotFactory {


    @Override
    public Tank createTank(String name, double attackPoints, double defensePoints) {
        return null;
    }

    @Override
    public Fighter createFighter(String name, double attackPoints, double defensePoints) {
        return null;
    }

    @Override
    public Pilot createPilot(String name) {
        return null;
    }
}
