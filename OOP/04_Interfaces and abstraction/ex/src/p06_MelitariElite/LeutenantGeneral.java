package p06_MelitariElite;

import java.util.LinkedHashSet;
import java.util.Set;

public  class LeutenantGeneral extends Private implements ILeuterantGeneral {
    private Set<Private> privates;

    public LeutenantGeneral(String id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName, salary);
        this.privates = new LinkedHashSet<>();
    }

    @Override
    public void addPrivate(Private privates) {
        this.privates.add(privates);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(super.toString()).append(System.lineSeparator()).append("Privates:").append(System.lineSeparator());
        privates.stream().sorted((p1, p2) -> p2.getID().compareTo(p1.getID())).forEach(p -> sb.append("  ").append(p).append(System.lineSeparator()));

        return sb.toString();
    }
}