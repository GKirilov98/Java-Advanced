package callofduty.domain.missions;

import callofduty.interfaces.Mission;

public abstract class MissionsImpl implements Mission {

    private String id;
    private Double rating;
    private Double bounty;

    protected MissionsImpl(String id, Double rating, Double bounty) {
        this.id = id;
        this.rating = rating;
        this.bounty = bounty;
    }

    @Override
    public Double getBounty() {
        return bounty;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public Double getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return
                this
                        .getClass()
                        .getSimpleName()
                        .replace("Mission", " Mission - ")
                        + this.getId()
                        + System.lineSeparator()
                        + "Status: {missionStatus}"
                        + System.lineSeparator()
                        + String.format("Rating: %.2f", this.getRating())
                        + System.lineSeparator()
                        + String.format("Bounty: %.2f", this.getBounty());
    }
}
