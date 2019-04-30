package p02_KingsGambit;

import p02_KingsGambit.interfaces.Defender;

public class Footman extends Unit implements Defender {
    Footman(String name) {
        super(name);
    }

    @Override
    public void onDeffends() {
            System.out.printf("Footman %s is panicking!\n", this.getName());
    }
}
