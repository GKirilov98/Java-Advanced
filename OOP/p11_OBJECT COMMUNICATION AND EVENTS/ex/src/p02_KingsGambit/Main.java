package p02_KingsGambit;

import p02_KingsGambit.interfaces.Defender;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Defender> defenders = new LinkedHashMap<>();

        String nameOfKing = scanner.nextLine();
       Arrays.stream(scanner.nextLine().split(" "))
                .forEach( e->  defenders.put(e, new RoyalGuard(e)));
        Arrays.stream(scanner.nextLine().split(" "))
                .forEach( e->  defenders.put(e, new Footman(e)));

        King king = new King(nameOfKing, defenders);
        String command = scanner.nextLine();
        while (!command.equals("End")) {
            if ("Attack King".equals(command)) {
                king.onAttacked();
            } else {
                king.killedDefender(command.split(" ")[1]);
            }
            command = scanner.nextLine();
        }
    }
}
