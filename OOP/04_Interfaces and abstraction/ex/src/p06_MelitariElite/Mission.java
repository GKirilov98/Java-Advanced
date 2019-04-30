package p06_MelitariElite;

public class Mission implements IMission {
    private String codeName;
    private String state;

    public Mission(String codeName, String  state) {
        this.codeName = codeName;
        this.setMissionState(state);
    }

    @Override
    public String toString() {
        return String.format("Code Name: %s State: %s", this.codeName, this.state);
    }

    @Override
    public void completeMission() {
        this.state = "Finished";
    }

    @Override
    public String getState() {
        return this.state;
    }

    @Override
    public void setMissionState(String state) {
        if ((!"Finished".equals(state)  && !"inProgress".equals(state))){
            throw new IllegalArgumentException("invalid");
        }

        this.state = state;
    }
}