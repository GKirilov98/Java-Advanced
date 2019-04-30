package callofduty.domain.agents;

import callofduty.interfaces.BountyAgent;
import callofduty.interfaces.Bountyable;
import callofduty.interfaces.Mission;

import java.util.ArrayList;
import java.util.List;

public class MasterAgent extends AgentImpl implements BountyAgent {
    private Double bounty;
    private List<Mission> pastMission;

    public MasterAgent(String id, String name, Double rating) {
        super(id, name, rating);
        this.bounty = 0.0;
        pastMission = new ArrayList<>();
    }

    void setPastMission(List<Mission> pastMission) {
        this.pastMission = pastMission;
    }

    @Override
    public Double getBounty() {
        return this.bounty =  super.getCompletedMissions()
                .values()
                .stream()
                .mapToDouble(Bountyable::getBounty)
                .sum()  -  this.pastMission.stream().mapToDouble(Bountyable::getBounty).sum();
    }

    @Override
    public String toString() {
        return super.toString() + String.format("\nBounty Earned: $%.2f", this.getBounty());
    }
}
