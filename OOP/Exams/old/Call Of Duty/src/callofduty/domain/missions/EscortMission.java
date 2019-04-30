package callofduty.domain.missions;

public class EscortMission extends MissionsImpl {

    private static final double DECREASE_RATING = 0.75;
    private static final double INCREASE_BOUNTY = 1.25;

    public EscortMission(String id, Double rating, Double bounty) {
        super(id, rating * DECREASE_RATING, bounty * INCREASE_BOUNTY);
    }
}
