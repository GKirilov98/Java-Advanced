import core.MachinesManagerImpl;

import core.interfaces.MachineFactory;
import core.interfaces.PilotFactory;
import core.interfaces.MachinesManager;
import entities.PilotImpl;
import entities.factories.MachineFactoryImpl;
import entities.factories.PilotFactoryImpl;
import entities.interfaces.Machine;
import entities.interfaces.Pilot;


import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PilotFactory pilotFactory = new PilotFactoryImpl();
        MachineFactory machineFactory = new MachineFactoryImpl();
        Map<String, Pilot> pilots = new LinkedHashMap<>();
        Map<String, Machine> machines = new LinkedHashMap<>();

        MachinesManager machinesManager = new MachinesManagerImpl(pilotFactory, machineFactory, pilots, machines);

        //•	Hire {pilotName}
        //•	Report {pilotName}
        //•	ManufactureTank {tankName} {attackPoints} {DefensePoints}
        //•	ManufactureFighter {fighterName} {attackPoints} {DefensePoints}
        //•	Engage {pilotName} {machineName}
        //•	Attack {attackingMachineName} {defendingMachineName}
        //•	DefenseMode {machineName}
        //•	AggressiveMode {machineName}
         Scanner scanner = new Scanner(System.in);
         String result = "";
         String command = scanner.nextLine();
         while (!command.equals("Over")){
             String[] tokens = command.split(" ");
             switch (tokens[0]){
                 case "Hire":
                    result = machinesManager.hirePilot(tokens[1]);
                     break;
                 case "Report":
                     result =  machinesManager.pilotReport(tokens[1]);
                     break;
                 case "ManufactureTank":
                     result =  machinesManager.manufactureTank(tokens[1], Double.parseDouble(tokens[2]),
                             Double.parseDouble(tokens[3]));
                     break;
                 case "ManufactureFighter":
                     result =   machinesManager.manufactureFighter(tokens[1], Double.parseDouble(tokens[2]),
                             Double.parseDouble(tokens[3]));
                     break;
                 case "Engage":
                     result =   machinesManager.engageMachine(tokens[1], tokens[2]);
                     break;
                 case "Attack":
                     result =  machinesManager.attackMachines(tokens[1], tokens[2]);
                     break;
                 case "DefenseMode":
                     result =  machinesManager.toggleTankDefenseMode(tokens[1]);
                     break;
                 case "AggressiveMode":
                     result =  machinesManager.toggleFighterAggressiveMode(tokens[1]);
                     break;
             }

             System.out.println(result);
             command =scanner.nextLine();
         }

    }
}
