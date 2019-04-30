package callofduty.util.reflection;

import callofduty.interfaces.Agent;
import callofduty.interfaces.Mission;
import callofduty.interfaces.MissionExtraction;
import callofduty.util.common.GlobalConstants;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MissionExtractionUtil implements MissionExtraction {
    private static final String AGENT_ASSIGNED_MISSIONS_FIELD_NAME = "assignedMissions";

    private static final String AGENT_COMPLETED_MISSIONS_FIELD_NAME = "completedMissions";

    private List<Mission> extractAssignedMissions(Agent agent) throws NoSuchFieldException, IllegalAccessException {
        Field assignedMissionsField = agent
                .getClass()
                .getSuperclass()
                .getDeclaredField(AGENT_ASSIGNED_MISSIONS_FIELD_NAME);

        assignedMissionsField.setAccessible(true);

        return ((List<Mission>) assignedMissionsField.get(agent));
    }

    private List<Mission> extractCompletedMissions(Agent agent) throws NoSuchFieldException, IllegalAccessException {
        Field completedMissionsField = agent
                .getClass()
                .getSuperclass()
                .getDeclaredField(AGENT_COMPLETED_MISSIONS_FIELD_NAME);

        completedMissionsField.setAccessible(true);

        return ((List<Mission>) completedMissionsField.get(agent));
    }

    public List<Mission> extractMissionsByStatus(Agent agent, String status) {
        try {
            if (status.equals(GlobalConstants.MISSION_STATUS_ASSIGNED)) {
                return this.extractAssignedMissions(agent);
            } else if (status.equals(GlobalConstants.MISSION_STATUS_COMPLETED)) {
                return this.extractCompletedMissions(agent);
            } else if (status.equals(GlobalConstants.MISSION_STATUS_ALL)) {
                List<Mission> allMissions = new ArrayList<>();

                allMissions.addAll(this.extractAssignedMissions(agent));
                allMissions.addAll(this.extractCompletedMissions(agent));

                return allMissions;
            }
        } catch (IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        }

        return null;
    }

    public List<Mission> extractAllMissionsFromAgentsByStatus(Collection<Agent> agents, String status) {
        List<Mission> extractedMissions = new ArrayList<>();

        for (Agent agent : agents) {
            extractedMissions.addAll(this.extractMissionsByStatus(agent, status));
        }

        return extractedMissions;
    }
}
