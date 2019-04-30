package p06_MelitariElite;

public class Repair {
    private String partName;
    private int workedHours;

    public Repair(String partName, int workedHours) {
        this.partName = partName;
        this.workedHours = workedHours;
    }

    @Override
    public String toString() {
        return String.format("Part Name: %s Hours Worked: %d", this.partName, this.workedHours);
    }
}