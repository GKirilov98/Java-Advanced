package fake;

import Interfaces.Target;
import Interfaces.Weapon;

public class FakeAxe implements Weapon {
    public int getAttackPoints() {
        return 10;
    }

    public int getDurabilityPoints() {
        return 10;
    }

    public void attack(Target target) {
        target.takeAttack(10);
    }
}
