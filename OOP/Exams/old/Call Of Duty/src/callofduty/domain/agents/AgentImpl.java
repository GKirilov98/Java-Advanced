package callofduty.domain.agents;

import callofduty.domain.agents.MasterAgent;
import callofduty.domain.agents.NoviceAgent;
import callofduty.interfaces.Agent;
import callofduty.interfaces.Mission;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public abstract class AgentImpl implements Agent {
    private String id;
    private String name;
    private Double rating;
    private Map<String, Mission> acceptedMissions;
    private Map<String, Mission> completedMissions;
    private int missionCounter;

    protected AgentImpl(String id, String name, Double rating) {
        this.id = id;
        this.name = name;
        this.rating = rating;
        this.acceptedMissions = new LinkedHashMap<>();
        this.completedMissions = new LinkedHashMap<>();
    }

     Map<String, Mission> getCompletedMissions() {
        return completedMissions;
    }

     int getMissionCounter() {
        return missionCounter;
    }

    @Override
    public void acceptMission(Mission mission) {
        this.acceptedMissions.put(mission.getId(), mission);
    }

     Map<String, Mission> getAcceptedMissions() {
        return acceptedMissions;
    }

    @Override
    public void completeMissions() {
        this.completedMissions.putAll(acceptedMissions);
        this.missionCounter = completedMissions.size();
        for (Mission mission : acceptedMissions.values()) {
            this.rating += mission.getRating();
        }
        this.acceptedMissions.clear();
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
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
                        .replace("Agent", " Agent - ")
                        + this.getName()
                        + System.lineSeparator()
                        + "Personal Code: "
                        + this.getId()
                        + System.lineSeparator()
                        + "Assigned Missions: "
                        + this.acceptedMissions.size()
                        + System.lineSeparator()
                        + "Completed Missions: "
                        + this.completedMissions.size()
                        + System.lineSeparator()
                        + String.format("Rating: %.2f", this.getRating());
    }

}
