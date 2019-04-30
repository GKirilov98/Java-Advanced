package cresla.entities.modules.abstractClass;

import cresla.interfaces.Module;

public abstract class ModulesImpl implements Module {
    private int id;

    protected ModulesImpl(int id) {
        this.id = id;
    }

    @Override
    public int getId() {
        return this.id;
    }
}
