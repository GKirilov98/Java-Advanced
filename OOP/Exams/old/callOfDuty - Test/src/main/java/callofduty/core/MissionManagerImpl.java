package callofduty.core;

import callofduty.domain.agents.MasterAgent;
import callofduty.domain.agents.NoviceAgent;
import callofduty.interfaces.*;
import callofduty.util.common.GlobalConstants;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MissionManagerImpl implements MissionManager {
    private static final Mission DEFAULT_MISSION_RESULT = null;

    private static final String MISSION_DETAILS_STATUS_PLACEHOLDER = "{missionStatus}";

    private static final String MISSION_DETAILS_STATUS_ASSIGNED = "Open";

    private static final String MISSION_DETAILS_STATUS_COMPLETED = "Completed";

    private static final String REGISTER_AGENT_MESSAGE = "Registered Agent - %s:%s";

    private static final String REQUEST_MISSION_MESSAGE = "Assigned %s Mission - %s to Agent - %s";

    private static final String COMPLETE_MISSIONS_MESSAGE = "Agent - %s:%s has completed all assigned missions.";

    private static final String OVER_COMMAND_OUTPUT =
            "Novice Agents: %d" + System.lineSeparator()
            + "Master Agents: %d" + System.lineSeparator()
            + "Assigned Missions: %d" + System.lineSeparator()
            + "Completed Missions: %d" + System.lineSeparator()
            + "Total Rating Given: %.2f" + System.lineSeparator()
            + "Total Bounty Given: $%.2f";

    private Map<String, Agent> agentsById;

    private Map<String, Agent> noviceAgentsById;

    private Map<String, BountyAgent> masterAgentsById;

    private final MissionControl missionControl;

    private final MissionExtraction missionExtractionUtil;

    public MissionManagerImpl(MissionControl missionControl, MissionExtraction missionExtractionUtil) {
        this.agentsById = new HashMap<>();
        this.noviceAgentsById = new HashMap<>();
        this.masterAgentsById = new HashMap<>();
        this.missionControl = missionControl;
        this.missionExtractionUtil = missionExtractionUtil;
    }

    private Agent getAgentById(String agentId) {
        if (this.agentsById.containsKey(agentId)) {
            return this.agentsById.get(agentId);
        }

        return null;
    }

    private Mission getAssignedMissionById(String missionId) {
        return this.missionExtractionUtil
                .extractAllMissionsFromAgentsByStatus(
                        this.agentsById.values(), GlobalConstants.MISSION_STATUS_ASSIGNED)
                .stream()
                .filter(x -> x.getId().equals(missionId))
                .findFirst()
                .orElse(DEFAULT_MISSION_RESULT);
    }

    private Mission getCompletedMissionById(String missionId) {
        return this.missionExtractionUtil
                .extractAllMissionsFromAgentsByStatus(
                        this.agentsById.values(), GlobalConstants.MISSION_STATUS_COMPLETED)
                .stream()
                .filter(x -> x.getId().equals(missionId))
                .findFirst()
                .orElse(DEFAULT_MISSION_RESULT);
    }

    private String getMissionDataByMissionId(String missionId) {
        Mission missionById = this.getAssignedMissionById(missionId);

        if (missionById != null) {
            return missionById.toString()
                    .replace(MISSION_DETAILS_STATUS_PLACEHOLDER, MISSION_DETAILS_STATUS_ASSIGNED);
        } else {
            return this.getCompletedMissionById(missionId).toString()
                    .replace(MISSION_DETAILS_STATUS_PLACEHOLDER, MISSION_DETAILS_STATUS_COMPLETED);
        }
    }

    private void promoteAgent(Agent agent) {
        this.agentsById.remove(agent.getId());
        this.noviceAgentsById.remove(agent.getId());

        BountyAgent promotedAgent = new MasterAgent(
                agent.getId(),
                agent.getName(),
                agent.getRating(),
                this.missionExtractionUtil.extractMissionsByStatus(agent, GlobalConstants.MISSION_STATUS_COMPLETED)
        );

        this.agentsById.put(promotedAgent.getId(), promotedAgent);
        this.masterAgentsById.put(promotedAgent.getId(), promotedAgent);
    }

    private Integer getAllAssignedMissionsCount() {
        return this.missionExtractionUtil
                .extractAllMissionsFromAgentsByStatus(this
                        .agentsById
                        .values(), GlobalConstants.MISSION_STATUS_ALL)
                .size();
    }

    private Integer getAllCompletedMissionsCount() {
        return this.missionExtractionUtil
                .extractAllMissionsFromAgentsByStatus(this
                        .agentsById
                        .values(), GlobalConstants.MISSION_STATUS_COMPLETED)
                .size();
    }

    private Double getTotalRatingGiven() {
        return this.agentsById
                .values()
                .stream()
                .mapToDouble(Rateable::getRating).sum();
    }

    private Double getTotalBountyGiven() {
        return this.masterAgentsById
                .values()
                .stream()
                .mapToDouble(BountyAgent::getBounty).sum();
    }

    @Override
    public String agent(List<String> arguments) {
        String agentId = arguments.get(0);
        String agentName = arguments.get(1);

        Agent agent = new NoviceAgent(agentId, agentName);

        this.noviceAgentsById.put(agent.getId(), agent);
        this.agentsById.put(agent.getId(), agent);

        return String.format(REGISTER_AGENT_MESSAGE, agent.getName(), agent.getId());
    }

    @Override
    public String request(List<String> arguments) {
        String agentId = arguments.get(0);
        String missionId = arguments.get(1);
        Double missionRating = Double.parseDouble(arguments.get(2));
        Double missionBounty = Double.parseDouble(arguments.get(3));

        Agent agent = this.getAgentById(agentId);
        Mission mission = this.missionControl.generateMission(missionId, missionRating, missionBounty);

        agent.acceptMission(mission);

        return String.format(REQUEST_MISSION_MESSAGE,
                mission
                        .getClass()
                        .getSimpleName()
                        .replace("Mission", ""),
                mission.getId(),
                agent.getName());
    }

    @Override
    public String complete(List<String> arguments) {
        String agentId = arguments.get(0);

        Agent agent = this.getAgentById(agentId);

        agent.completeMissions();

        if (this.noviceAgentsById.containsKey(agentId) && this.missionExtractionUtil.extractMissionsByStatus(agent, GlobalConstants.MISSION_STATUS_COMPLETED).size() >= 3) {
            this.promoteAgent(agent);
        }

        return String.format(
                COMPLETE_MISSIONS_MESSAGE,
                agent.getName(),
                agent.getId());
    }

    @Override
    public String status(List<String> arguments) {
        String id = arguments.get(0);

        if (this.agentsById.containsKey(id)) {
            return this.getAgentById(id).toString();
        } else {
            return this.getMissionDataByMissionId(id);
        }
    }

    @Override
    public String over(List<String> arguments) {
        return String.format(OVER_COMMAND_OUTPUT,
                this.noviceAgentsById.size(),
                this.masterAgentsById.size(),
                this.getAllAssignedMissionsCount(),
                this.getAllCompletedMissionsCount(),
                this.getTotalRatingGiven(),
                this.getTotalBountyGiven());
    }
}
