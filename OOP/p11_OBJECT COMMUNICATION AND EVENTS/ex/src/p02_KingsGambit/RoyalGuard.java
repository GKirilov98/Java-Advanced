package p02_KingsGambit;

import p02_KingsGambit.interfaces.Defender;

public class RoyalGuard extends Unit implements Defender {
    RoyalGuard(String name) {
        super(name);
    }

    @Override
    public void onDeffends() {
            System.out.printf("Royal Guard %s is defending!\n", this.getName());
    }
}
