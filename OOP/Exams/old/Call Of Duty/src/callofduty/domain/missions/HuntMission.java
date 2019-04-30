package callofduty.domain.missions;

public class HuntMission extends MissionsImpl {

    private static final Double INCREASE_RATING = 1.50;
    private static final Double INCREASE_BOUNTY = 2.00;

    public HuntMission(String id, Double rating, Double bounty) {
        super(id, rating * INCREASE_RATING, bounty * INCREASE_BOUNTY);
    }
}
