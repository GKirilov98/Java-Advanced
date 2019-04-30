package panzer.entities.parts;

import panzer.contracts.Part;

import java.math.BigDecimal;

public abstract class PartsImpl implements Part {
    private String model;
    private double weight;
    private BigDecimal price;

    protected PartsImpl(String model, double weight, BigDecimal price) {
        this.model = model;
        this.weight = weight;
        this.price = price;
    }

    @Override
    public double getWeight() {
        return this.weight;
    }

    @Override
    public BigDecimal getPrice() {
        return this.price;
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public String toString() {
        throw new Error("Eh NiceTry");
        //return "PartsImpl{}";
    }
}
