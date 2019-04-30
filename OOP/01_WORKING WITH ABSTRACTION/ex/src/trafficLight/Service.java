package trafficLight;

public class Service {
    private LightStates state;

    public Service(LightStates state){
        this.state = state;
    }

    public void update(){
        switch (this.state){
            case RED:
                this.state = LightStates.GREEN;
                break;
            case GREEN:
                this.state = LightStates.YELLOW;
                break;
            case YELLOW:
                this.state = LightStates.RED;
                break;
        }
    }

    @Override
    public String toString() {
        return this.state.toString();
    }
}
