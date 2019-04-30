package panzer;

import panzer.contracts.*;
import panzer.core.PanzerBattleOperator;
import panzer.entities.vehicles.Revenger;
import panzer.entities.vehicles.Vanguard;
import panzer.entities.parts.ArsenalPart;
import panzer.entities.parts.EndurancePart;
import panzer.entities.parts.ShellPart;

import java.math.BigDecimal;
import java.util.*;

public class ManagerCommandImpl implements Manager {
    private Map<String, Vehicle> allVehicles;
    private Map<String, Part> allParts;
    private BattleOperator battleOperator;
    private List<String> defetedVehiclesList;
    private int partsCount = 0;

    public ManagerCommandImpl() {
        allVehicles = new LinkedHashMap<>();
        this.allParts = new LinkedHashMap<>();
        this.battleOperator = new PanzerBattleOperator();
        this.defetedVehiclesList = new ArrayList<>();
    }

    @Override
    public String addVehicle(List<String> arguments) {
        //•	Vehicle {vehicleType} {model} {weight} {price} {attack} {defense} {hitPoints}
        String vehicleType = arguments.get(arguments.size() - 7);
        String model = arguments.get(arguments.size() - 6);
        double weight = Double.parseDouble(arguments.get(arguments.size() - 5));
        BigDecimal price = new BigDecimal(arguments.get(arguments.size() - 4));
        int attack = Integer.parseInt(arguments.get(arguments.size() - 3));
        int defense = Integer.parseInt(arguments.get(arguments.size() - 2));
        int hitPoints = Integer.parseInt(arguments.get(arguments.size() - 1));
        Vehicle vehicle;
        if (vehicleType.equals("Vanguard")) {
            vehicle = new Vanguard(model, weight, price, attack, defense, hitPoints);
        } else {
            vehicle = new Revenger(model, weight, price, attack, defense, hitPoints);
        }

        allVehicles.put(model, vehicle);
        return String.format("Created %s Vehicle - %s", vehicleType, model);
    }

    @Override
    public String addPart(List<String> arguments) {
        //•	Part {vehicleModel} {partType} {model} {weight} {price} {additionalParameter}
        String vehicleModel = arguments.get(arguments.size() - 6);
        String partType = arguments.get(arguments.size() - 5);
        String partModel = arguments.get(arguments.size() - 4);
        double weight = Double.parseDouble(arguments.get(arguments.size() - 3));
        BigDecimal price = new BigDecimal(arguments.get(arguments.size() - 2));
        int additionalParameter = Integer.parseInt(arguments.get(arguments.size() - 1));
        Part part;
        if (partType.equals("Arsenal")){
            part = new ArsenalPart(partModel, weight, price, additionalParameter);
            this.allVehicles.get(vehicleModel).addArsenalPart(part);
        } else  if (partType.equals("Shell")){
            part = new ShellPart(partModel, weight, price, additionalParameter);
            this.allVehicles.get(vehicleModel).addShellPart(part);
        } else {
            part = new EndurancePart(partModel, weight, price, additionalParameter);
            this.allVehicles.get(vehicleModel).addEndurancePart(part);
        }

        this.allParts.put(partModel, part);
        this.partsCount ++;
        return String.format("Added %s - %s to Vehicle - %s",
                partType, partModel, vehicleModel);
    }

    @Override
    public String inspect(List<String> arguments) {
       String model = arguments.get(arguments.size() -1);
       if(this.allVehicles.containsKey(model)){
          return this.allVehicles.get(model).toString();
       } else if (this.allParts.containsKey(model)){
           throw new Error("Tes 4");
           // FIXME: 4/13/2019
         //  return this.allParts.get(model).toString();
       }

       return "";
    }

    @Override
    public String battle(List<String> arguments) {
       String modelOne = arguments.get(arguments.size() -1);
       String modelTwo = arguments.get(arguments.size() - 2);
       if(this.allVehicles.containsKey(modelOne) && this.allVehicles.containsKey(modelTwo)) {
           Vehicle attacker = this.allVehicles.get(modelOne);
           Vehicle target = this.allVehicles.get(modelTwo);

           String theWinner = battleOperator.battle(attacker, target);
           if (theWinner.equals(modelOne)){
               target.getParts().forEach(e -> this.partsCount --);
               this.allVehicles.remove(modelTwo);
               this.defetedVehiclesList.add(modelTwo);

           } else {
               attacker.getParts().forEach(e -> this.partsCount --);
               this.allVehicles.remove(modelOne);
               this.defetedVehiclesList.add(modelOne);
           }

           return String.format(
                   "%s versus %s -> %s Wins! Flawless Victory!",
                   modelTwo, modelOne, theWinner);
       }
       return null;
    }

    @Override
    public String terminate(List<String> arguments) {
        StringBuilder remainingVehicles = new StringBuilder();
                this.allVehicles.keySet().forEach(e -> remainingVehicles.append(e).append(", "));

        String resultRemaining = "None";
                if (remainingVehicles.length() != 0){
                    resultRemaining = remainingVehicles.substring(0, remainingVehicles.length() - 2);
                }

                if (partsCount < 0){
                    partsCount = 0;
                }

        StringBuilder defetedVehicles = new StringBuilder();
        this.defetedVehiclesList.forEach(e -> defetedVehicles.append(e).append(", "));
        String resultDefeted = "None";
        if (defetedVehicles.length() != 0){
            resultDefeted = defetedVehicles.substring(0, defetedVehicles.length() - 2);
        }

           return String.format("Remaining Vehicles: %s\n" +
                   "Defeated Vehicles: %s\n" +
                   "Currently Used Parts: %d",
                   resultRemaining, resultDefeted, partsCount);
    }
}
