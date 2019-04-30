package panzer.entities.vehicles;

import java.math.BigDecimal;

public class Vanguard extends VehiclesImpl {
    public Vanguard(String model, double weight, BigDecimal price, int attack, int defense, int hitPoints) {
        super(model,
                weight * 2 ,
                price,
                (int)(attack * 0.75),
                (int)(defense * 1.5),
                (int)(hitPoints * 1.75));
    }
}
