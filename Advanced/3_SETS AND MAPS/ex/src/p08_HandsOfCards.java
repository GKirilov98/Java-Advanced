import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.stream.Collectors;

public class p08_HandsOfCards {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        LinkedHashMap<String, HashSet<String>> players = new LinkedHashMap<>();
        while (true) {
            String[] tokens = console.nextLine().split(": ");
            if (tokens[0].equals("JOKER")) {
                break;
            }
            String name = tokens[0];
            HashSet<String> cards = Arrays.stream(tokens[1].split(", ")).collect(Collectors.toCollection(HashSet::new));
            if (!players.containsKey(name)) {
                players.put(name, cards);
            } else {
                players.get(name).addAll(cards);
            }
        }

        for (String p : players.keySet()) {
            int powerDecks = checkPowerDeck(players.get(p));
            System.out.println(p + ": " + powerDecks);
        }

    }

    private static int checkPowerDeck(HashSet<String> cards) {
        int power = 0;

        for (String card : cards) {
            int currPower = 0;
            char numOfCard = card.charAt(0);
            switch (numOfCard) {
                case '1':
                    currPower = 10;
                    break;
                case 'J':
                    currPower = 11;
                    break;
                case 'Q':
                    currPower = 12;
                    break;
                case 'K':
                    currPower = 13;
                    break;
                case 'A':
                    currPower = 14;
                    break;
                default:
                    currPower = Integer.parseInt("" + numOfCard);
                    break;
            }

            char paint = card.charAt(card.length() - 1);
            switch (paint) {
                //(S -> 4, H-> 3, D -> 2, C -> 1
                case 'S':
                    currPower *= 4;
                    break;
                case 'H':
                    currPower *= 3;
                    break;
                case 'D':
                    currPower *= 2;
                    break;
            }

            power += currPower;
        }


        return power;
    }
}
