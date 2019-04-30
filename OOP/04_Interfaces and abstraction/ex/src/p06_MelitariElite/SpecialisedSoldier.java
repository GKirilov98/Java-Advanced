package p06_MelitariElite;

public class SpecialisedSoldier extends Private implements ISpecifiedSoldier {
    private String corps;

    public SpecialisedSoldier(String id, String firstName, String lastName, double salary, String corps) {
        super(id, firstName, lastName, salary);
        this.setCorps(corps);
    }

    @Override
    public String getCorps() {
        return this.corps;
    }

    @Override
    public void setCorps(String corp) {
        if (!"Airforces".equals(corp) && !"Marines".equals(corp)) {
            throw new IllegalArgumentException("invalid");
        }

        this.corps = corp;
    }

    @Override
    public String toString() {
        StringBuilder specialisedSoldier = new StringBuilder(super.toString()).append(System.lineSeparator());

        specialisedSoldier.append(String.format("Corps: %s", this.corps));

        return specialisedSoldier.toString();
    }
}