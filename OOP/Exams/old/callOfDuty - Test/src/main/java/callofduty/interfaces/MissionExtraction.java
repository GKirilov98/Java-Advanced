package callofduty.interfaces;

import callofduty.interfaces.Agent;
import callofduty.interfaces.Mission;

import java.util.Collection;
import java.util.List;

public interface MissionExtraction {
    List<Mission> extractMissionsByStatus(Agent agent, String status);

    List<Mission> extractAllMissionsFromAgentsByStatus(Collection<Agent> agents, String status);


}
