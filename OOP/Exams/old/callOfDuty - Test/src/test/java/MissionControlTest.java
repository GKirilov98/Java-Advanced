import callofduty.core.MissionControlImpl;
import callofduty.domain.missions.EscortMission;
import callofduty.domain.missions.HuntMission;
import callofduty.domain.missions.SurveillanceMission;
import callofduty.interfaces.Mission;
import callofduty.interfaces.MissionControl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MissionControlTest {
    private static final String ID_MISSION = "MISSION";
    private static final String ID_INVALID_MISSION = "123456789010";
    private static final String ID_VALID_MISSION = "12345678";

    private static final Double RATING_MISSION = 10.0;
    private static final Double RATING_INVALID_MINIMUM_MISSION = -50.0;
    private static final Double RATING_VALID_MINIMUM_MISSION = 0.0;
    private static final Double RATING_INVALID_MAXIMUM_MISSION = 999.0;
    private static final Double RATING_VALID_MAXIMUM_MISSION = 75.0;

    private static final Double BOUNTY_MISSION = 1000.0;
    private static final Double BOUNTY_INVALID_MINIMUM_MISSION = -999.0;
    private static final Double BOUNTY_VALID_MINIMUM_MISSION = 0.0;
    private static final Double BOUNTY_INVALID_MAXIMUM_MISSION = 999999999.0;
    private static final Double BOUNTY_VALID_MAXIMUM_MISSION = 125000D;

    private static final Mission ESCORT_BASE_MISSION = new EscortMission(ID_MISSION, RATING_MISSION, BOUNTY_MISSION);
    private static final Mission HUNT_BASE_MISSION = new HuntMission(ID_MISSION, RATING_MISSION, BOUNTY_MISSION);
    private static final Mission SURVEILLAN_BASE_MISSION = new SurveillanceMission(ID_MISSION, RATING_MISSION, BOUNTY_MISSION);


    MissionControl missionControl;

    @Before
    public void createMC() {
        missionControl = new MissionControlImpl();
    }


    //generatorMission
    @Test
    public void generateMissionShouldCreateMissionGetBounty() {
        Mission currMission = this.missionControl.generateMission(ID_MISSION, RATING_MISSION, BOUNTY_MISSION);
        Assert.assertEquals(ESCORT_BASE_MISSION.getBounty(), currMission.getBounty());
    }

    @Test
    public void generateMissionShouldCreateMissionGetId() {
        Mission currMission = this.missionControl.generateMission(ID_MISSION, RATING_MISSION, BOUNTY_MISSION);
        Assert.assertEquals(ESCORT_BASE_MISSION.getId(), currMission.getId());
    }

    @Test
    public void generateMissionShouldCreateMissionGetRating() {
        Mission currMission = this.missionControl.generateMission(ID_MISSION, RATING_MISSION, BOUNTY_MISSION);
        Assert.assertEquals(ESCORT_BASE_MISSION.getRating(), currMission.getRating());
    }


    //CheckReformID
    @Test
    public void checkAndReformIDShouldReform() {
        Mission currMission = this.missionControl.generateMission(ID_INVALID_MISSION, RATING_MISSION, BOUNTY_MISSION);
        Assert.assertEquals(ID_VALID_MISSION, currMission.getId());
    }

    //CR_Rating
    @Test
    public void checkAndReformRatingShouldReformMinimum() {
        Mission currMission = this.missionControl.generateMission(ID_VALID_MISSION, RATING_INVALID_MINIMUM_MISSION, BOUNTY_MISSION);
        Assert.assertEquals(RATING_VALID_MINIMUM_MISSION, currMission.getRating(), 0.01);
    }

    @Test
    public void checkAndReformRatingShouldReformMaximum() {
        Mission currMission = this.missionControl.generateMission(ID_VALID_MISSION, RATING_INVALID_MAXIMUM_MISSION, BOUNTY_MISSION);
        Assert.assertEquals(RATING_VALID_MAXIMUM_MISSION, currMission.getRating(), 0.01);
    }

    //CR_Bounty
    @Test
    public void checkAndReformBountyShouldReformMinimum() {
        Mission currMission = this.missionControl.generateMission(ID_VALID_MISSION, RATING_MISSION, BOUNTY_INVALID_MINIMUM_MISSION);
        Assert.assertEquals(BOUNTY_VALID_MINIMUM_MISSION, currMission.getBounty(), 0.01);
    }

    @Test
    public void checkAndReformBountyShouldReformMaximum() {
        Mission currMission = this.missionControl.generateMission(ID_VALID_MISSION, RATING_MISSION, BOUNTY_INVALID_MAXIMUM_MISSION);
        Assert.assertEquals(BOUNTY_VALID_MAXIMUM_MISSION, currMission.getBounty(), 0.01);
    }

    //CheckSimpleClassName
    @Test
    public void generateMissionShouldCreateMissionEscortMissionClass() {
        Mission currMission = this.missionControl.generateMission(ID_MISSION, RATING_MISSION, BOUNTY_MISSION);
        Assert.assertEquals(ESCORT_BASE_MISSION.getClass().getSimpleName(), currMission.getClass().getSimpleName());
    }

    @Test
    public void generateMissionShouldCreateMissionHuntMission() {
        Mission escortMission = this.missionControl.generateMission(ID_MISSION, RATING_MISSION, BOUNTY_MISSION);
        Mission currMission = this.missionControl.generateMission(ID_MISSION, RATING_MISSION, BOUNTY_MISSION);
        Assert.assertEquals(HUNT_BASE_MISSION.getClass().getSimpleName(), currMission.getClass().getSimpleName());
    }

    @Test
    public void generateMissionShouldCreateMissionSurveillanMission() {
        Mission escortMission = this.missionControl.generateMission(ID_MISSION, RATING_MISSION, BOUNTY_MISSION);
        Mission HuntMission = this.missionControl.generateMission(ID_MISSION, RATING_MISSION, BOUNTY_MISSION);
        Mission currMission = this.missionControl.generateMission(ID_MISSION, RATING_MISSION, BOUNTY_MISSION);
        Assert.assertEquals(SURVEILLAN_BASE_MISSION.getClass().getSimpleName(), currMission.getClass().getSimpleName());
    }

}


