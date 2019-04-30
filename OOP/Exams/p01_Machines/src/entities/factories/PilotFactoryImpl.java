package entities.factories;

import core.interfaces.PilotFactory;
import entities.PilotImpl;
import entities.interfaces.Pilot;

public class PilotFactoryImpl implements PilotFactory {
    private Pilot pilot;
    @Override
    public Pilot createPilot(String name) {
        return this.pilot = new PilotImpl(name);
    }
}
