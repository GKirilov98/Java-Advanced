package p02_KingsGambit;

import p02_KingsGambit.interfaces.Defender;
import p02_KingsGambit.interfaces.Target;
import java.util.Map;

public class King extends Unit implements Target {


    private Map<String, Defender> defenders;

    public King(String name, Map<String, Defender> defenders) {
        super(name);
        this.defenders = defenders;
    }

    @Override
    public void onAttacked() {
        System.out.printf("King %s is under attack!\n", this.getName());
        this.fireOnAttackEvent();
    }

    private void fireOnAttackEvent() {
        for (Defender defender : defenders.values()) {
            defender.onDeffends();
        }
    }

    public void killedDefender(String name){
        this.defenders.remove(name);
    }
}
