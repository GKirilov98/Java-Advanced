import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class p02_BasicStackOperations {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int[] tokens = Arrays
                .stream(console.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int elToPush = tokens[0];
        int elToPop = tokens[1];
        int elToSearch = tokens[2];
        //Push
        ArrayDeque<Integer> lineOfNumbers = new ArrayDeque<>();
        Arrays
                .stream(console.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .limit(elToPush)
                .forEach(lineOfNumbers::push);
        //Pop
        for (int i = 0; i < elToPop; i++) {
            lineOfNumbers.poll();
        }
        //search
        if (lineOfNumbers.contains(elToSearch)) {
            System.out.println(true);
        } else {
            int min = 0;
            if (!lineOfNumbers.isEmpty()){
                min = Collections.min(lineOfNumbers);
            }
            System.out.println(min);
        }
    }
}
