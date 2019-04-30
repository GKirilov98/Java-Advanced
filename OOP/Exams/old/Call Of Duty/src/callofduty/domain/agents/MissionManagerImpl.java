package callofduty.domain.agents;

import callofduty.core.MissionControlImpl;
import callofduty.interfaces.Mission;
import callofduty.interfaces.MissionControl;
import callofduty.interfaces.MissionManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MissionManagerImpl implements MissionManager {
    private Map<String, NoviceAgent> allNoviceAgetns;
    private Map<String, MasterAgent> allMasterAgents;
    private Map<String, Mission> allMissions;
    private List<String> complatedMissionsList;
    private MissionControl missionControl;

    public MissionManagerImpl() {
        this.allNoviceAgetns = new HashMap<>();
        this.allMasterAgents = new HashMap<>();
        this.missionControl = new MissionControlImpl();
        this.allMissions = new HashMap<>();
        this.complatedMissionsList = new ArrayList<>();
    }

    @Override
    public String agent(List<String> arguments) {
        String id = arguments.get(arguments.size() - 2);
        String name = arguments.get(arguments.size() - 1);

        NoviceAgent agent = new NoviceAgent(id, name);
        allNoviceAgetns.putIfAbsent(id, agent);

        return String.format("Registered Agent - %s:%s", name, id);
    }

    @Override
    public String request(List<String> arguments) {
        //– agentId (string), missionId (string), missionRating (double), missionBounty (double)
        String agentId = arguments.get(arguments.size() - 4);

        String missionId = arguments.get(arguments.size() - 3);
        Double missionRating = Double.parseDouble(arguments.get(arguments.size() - 2));
        Double missionBounty = Double.parseDouble(arguments.get(arguments.size() - 1));

        Mission mission = this.missionControl.generateMission(missionId, missionRating, missionBounty);

        if (this.allNoviceAgetns.containsKey(agentId)) {
            this.allNoviceAgetns.get(agentId).acceptMission(mission);
            this.allMissions.put(missionId, mission);
            return String.format("Assigned %s Mission - %s to Agent - %s",
                    mission.getClass().getSimpleName().replace("Mission", ""),
                    missionId,
                    this.allNoviceAgetns.get(agentId).getName());
        } else if (this.allMasterAgents.containsKey(agentId)) {
            this.allMasterAgents.get(agentId).acceptMission(mission);
            this.allMissions.put(missionId, mission);
            return String.format("Assigned %s Mission - %s to Agent - %s",
                    mission.getClass().getSimpleName().replace("Mission", ""),
                    missionId,
                    this.allMasterAgents.get(agentId).getName());
        }

        return null;
    }

    @Override
    public String complete(List<String> arguments) {
        String agentId = arguments.get(arguments.size() - 1);
        if (this.allNoviceAgetns.containsKey(agentId)) {
            NoviceAgent noviceAgent = this.allNoviceAgetns.get(agentId);
            noviceAgent.completeMissions();
            this.complatedMissionsList.addAll(noviceAgent.getCompletedMissions().keySet());

            if (noviceAgent.getMissionCounter() >= 3) {
                MasterAgent masterAgent = new MasterAgent(agentId, noviceAgent.getName(), noviceAgent.getRating());
                masterAgent.getCompletedMissions().putAll(noviceAgent.getCompletedMissions());
                masterAgent.setPastMission(noviceAgent.getCompletedMissions().values().stream().collect(Collectors.toList()));
                this.allMasterAgents.putIfAbsent(agentId, masterAgent);
                this.allNoviceAgetns.remove(agentId);
            }

            return String.format("Agent - %s:%s has completed all assigned missions.", noviceAgent.getName(),
                    noviceAgent.getId());
        } else if (this.allMasterAgents.containsKey(agentId)) {
            MasterAgent masterAgent = this.allMasterAgents.get(agentId);
            masterAgent.completeMissions();
            this.complatedMissionsList.addAll(masterAgent.getCompletedMissions().keySet());
            return String.format("Agent - %s:%s has completed all assigned missions.", masterAgent.getName(),
                    masterAgent.getId());
        }

        return null;
    }

    @Override
    public String status(List<String> arguments) {
        String id = arguments.get(arguments.size() - 1);
        if (this.allMissions.containsKey(id)) {
            Mission mission = this.allMissions.get(id);
            String status = "Open";
            for (String missions : complatedMissionsList) {
                if(missions.equals(id)){
                    status = "Completed";
                    break;
                }
            }
            return
                    this
                            .getClass()
                            .getSimpleName()
                            .replace("Mission", " Mission - ")
                            + mission.getId()
                            + System.lineSeparator()
                            + "Status: " + status
                            + System.lineSeparator()
                            + String.format("Rating: %.2f", mission.getRating())
                            + System.lineSeparator()
                            + String.format("Bounty: %.2f", mission.getBounty());


        } else if (this.allNoviceAgetns.containsKey(id)) {
            return this.allNoviceAgetns.get(id).toString();
        } else if (this.allMasterAgents.containsKey(id)) {
            return this.allMasterAgents.get(id).toString();
        }

        return null;
    }

    @Override
    public String over(List<String> arguments) {
        int missionComplated = 0;
        double totalRating = 0;
        double totalBounty = 0;
        for (NoviceAgent agent : allNoviceAgetns.values()) {
            missionComplated += agent.getCompletedMissions().size();
            totalRating += agent.getRating();
        }

        for (MasterAgent agent : allMasterAgents.values()) {
            missionComplated += agent.getCompletedMissions().size();
            totalRating += agent.getRating();
            totalBounty += agent.getBounty();
        }

        return String.format(
                "Novice Agents: %d\n" +
                        "Master Agents: %d\n" +
                        "Assigned Missions: %d\n" +
                        "Completed Missions: %d\n" +
                        "Total Rating Given: %.2f\n" +
                        "Total Bounty Given: $%.2f",
                allNoviceAgetns.size(),
                allMasterAgents.size(),
                allMissions.size(),
                missionComplated,
                totalRating,
                totalBounty);
    }
}
