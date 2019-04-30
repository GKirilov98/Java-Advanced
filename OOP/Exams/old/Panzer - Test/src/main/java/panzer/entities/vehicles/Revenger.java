package panzer.entities.vehicles;

import java.math.BigDecimal;

public class Revenger extends VehiclesImpl {
    public Revenger(String model, double weight, BigDecimal price, int attack, int defense, int hitPoints) {
        super(model,
                weight,
                price.multiply(BigDecimal.valueOf(1.5)),
                (int) (attack * 2.5),
                (int) (defense* 0.5),
                (int) (hitPoints * 0.5));
    }
}
