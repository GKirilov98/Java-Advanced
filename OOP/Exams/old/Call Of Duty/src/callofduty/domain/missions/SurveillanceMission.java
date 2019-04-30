package callofduty.domain.missions;

public class SurveillanceMission extends MissionsImpl {

    private static final Double DECREASE_RATING = 0.25;
    private static final Double INCREASE_BOUNTY = 1.50;

    public SurveillanceMission(String id, Double rating, Double bounty) {
        super(id, rating * DECREASE_RATING, bounty * INCREASE_BOUNTY);
    }
}
