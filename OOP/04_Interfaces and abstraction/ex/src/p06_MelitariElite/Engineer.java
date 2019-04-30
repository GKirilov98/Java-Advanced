package p06_MelitariElite;

import java.util.LinkedHashSet;
import java.util.Set;

public class Engineer extends SpecialisedSoldier implements IEngineer {
    private Set<Repair> repairs;

    public Engineer(String id, String firstName, String lastName, double salary, String corps) {
        super(id, firstName, lastName, salary, corps);
        this.repairs = new LinkedHashSet<>();
    }

    @Override
    public void addRepair(Repair repair) {
        this.repairs.add(repair);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(super.toString()).append(System.lineSeparator()).append("Repairs:").append(System.lineSeparator());
        repairs.forEach(r -> sb.append("  ").append(r).append(System.lineSeparator()));
        return sb.toString();
    }
}