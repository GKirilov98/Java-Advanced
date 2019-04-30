package panzer.entities.vehicles;

import panzer.contracts.Assembler;
import panzer.contracts.Part;
import panzer.contracts.Vehicle;
import panzer.models.miscellaneous.VehicleAssembler;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public abstract class VehiclesImpl implements Vehicle {
    private String model;
    private double weight;
    private BigDecimal price;
    private int attack;
    private int defense;
    private int hitPoints;
    private Assembler assembler;
    private List<Part> partList;

    protected VehiclesImpl(String model, double weight, BigDecimal price, int attack, int defense, int hitPoints) {
        this.model = model;
        this.weight = weight;
        this.price = price;
        this.attack = attack;
        this.defense = defense;
        this.hitPoints = hitPoints;
        this.assembler = new VehicleAssembler();
        this.partList = new ArrayList<>();
    }

    @Override
    public double getTotalWeight() {
        return this.assembler.getTotalWeight() + this.weight;
    }

    @Override
    public BigDecimal getTotalPrice() {
        return this.assembler.getTotalPrice().add(this.price);
    }

    @Override
    public long getTotalAttack() {
        return this.assembler.getTotalAttackModification() + this.attack;
    }

    @Override
    public long getTotalDefense() {
        return this.assembler.getTotalDefenseModification() + this.defense;
    }

    @Override
    public long getTotalHitPoints() {
        return this.assembler.getTotalHitPointModification() + this.hitPoints;
    }

    @Override
    public void addArsenalPart(Part arsenalPart) {
        this.assembler.addArsenalPart(arsenalPart);
        this.partList.add(arsenalPart);
    }

    @Override
    public void addShellPart(Part shellPart) {
        this.assembler.addShellPart(shellPart);
        this.partList.add(shellPart);
    }

    @Override
    public void addEndurancePart(Part endurancePart) {
        this.assembler.addEndurancePart(endurancePart);
        this.partList.add(endurancePart);
    }

    @Override
    public Iterable<Part> getParts() {
        return this.partList;
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public String toString() {
        final String[] parts = {""};

        if (partList.size() == 0){
            parts[0] = "None";
        } else {
            partList.forEach(e -> parts[0] += (e.getModel() + ", "));
            parts[0] = parts[0].substring(0, parts[0].length() - 2);
        }

        return String.format(
                "%s - %s\n" +
                        "Total Weight: %.3f\n" +
                        "Total Price: %.3f\n" +
                        "Attack: %d\n" +
                        "Defense: %d\n" +
                        "HitPoints: %d\n" +
                        "Parts: %s",
                this.getClass().getSimpleName(), this.getModel(),
                this.getTotalWeight(),
                this.getTotalPrice(),
                this.getTotalAttack(),
                this.getTotalDefense(),
                this.getTotalHitPoints(),
                parts[0]);
    }
}
