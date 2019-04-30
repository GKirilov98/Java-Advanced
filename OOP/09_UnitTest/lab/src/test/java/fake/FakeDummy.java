package fake;

import Interfaces.Target;

public class FakeDummy implements Target {

    public int getHealth() {
        return 10;
    }

    public void takeAttack(int attackPoints) {

    }

    public int giveExperience() {
        return 10;
    }

    public boolean isDead() {
        return true;
    }
}
