package p01_Test;

import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int capacity = Integer.parseInt(scanner.nextLine());
        Map<String, List<String>> hallPeoples = new LinkedHashMap<>();

        String[] tokens = scanner.nextLine().split("\\s+");
        for (int i = tokens.length - 1; i >= 0; i--) {
            if (tokens[i].length() > 0 && !isNumeric(tokens[i])) {
                hallPeoples.putIfAbsent(tokens[i], new ArrayList<>());
                for (int num = i; num >= 0; num--) {
                    if (tokens[num].length() > 0 && isNumeric(tokens[num])) {
                        int people = Integer.parseInt(tokens[num]);
                        int sum = hallPeoples.get(tokens[i]).stream().mapToInt(Integer::parseInt).sum();
                        if (sum + people <= capacity) {
                            hallPeoples.get(tokens[i]).add(people + "");
                        } else {
                            System.out.println(tokens[i] + " -> " + String.join(", ", hallPeoples.get(tokens[i])));
                            break;
                        }

                        tokens[num] = "";
                    }
                }
            }
        }
    }

    public static boolean isNumeric(String str) {
        NumberFormat formatter = NumberFormat.getInstance();
        ParsePosition pos = new ParsePosition(0);
        formatter.parse(str, pos);
        return str.length() == pos.getIndex();
    }
}
