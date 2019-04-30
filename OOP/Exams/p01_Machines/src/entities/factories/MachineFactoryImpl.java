package entities.factories;

import core.interfaces.MachineFactory;
import entities.FighterImpl;
import entities.TankImpl;
import entities.interfaces.Fighter;
import entities.interfaces.Tank;

public class MachineFactoryImpl implements MachineFactory {
    private Tank tank;
    private Fighter fighter;

    @Override
    public Tank createTank(String name, double attackPoints, double defensePoints) {
        return this.tank = new TankImpl(name, attackPoints, defensePoints);
    }

    @Override
    public Fighter createFighter(String name, double attackPoints, double defensePoints) {
        return this.fighter = new FighterImpl(name, attackPoints, defensePoints);
    }
}
