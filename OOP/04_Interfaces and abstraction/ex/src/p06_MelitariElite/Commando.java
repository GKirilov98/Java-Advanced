package p06_MelitariElite;

import java.util.LinkedHashSet;
import java.util.Set;

public class Commando extends SpecialisedSoldier implements ICommando {
    private Set<Mission> missions;

    public Commando(String id, String firstName, String lastName, double salary, String corps) {
        super(id, firstName, lastName, salary, corps);
        this.missions = new LinkedHashSet<>();
    }


    @Override
    public void addMission(Mission mission) {
        this.missions.add(mission);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(super.toString()).append(System.lineSeparator()).append("Missions:").append(System.lineSeparator());
        missions.forEach(m -> sb.append("  ").append(m).append(System.lineSeparator()));
        return sb.toString();
    }
}