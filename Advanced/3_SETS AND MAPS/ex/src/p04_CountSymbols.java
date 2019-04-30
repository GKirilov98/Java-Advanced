import java.util.Scanner;
import java.util.TreeMap;

public class p04_CountSymbols {
    public static void main(String[] args) {
         Scanner console = new Scanner(System.in);
         char[] input = console.nextLine().toCharArray();
        TreeMap<Character, Integer> symbols = new TreeMap<>();
        for (char symbol : input) {
            if (!symbols.containsKey(symbol)){
                symbols.put(symbol, 0);
            }
            symbols.put(symbol, symbols.get(symbol) + 1);
        }
        for (Character character : symbols.keySet()) {
            System.out.printf("%s: %d time/s%n", character, symbols.get(character));
        }
    }
}
