import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class p04_BasicQueueOperations {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int elToAdd = console.nextInt();
        int elToPoll = console.nextInt();
        int elToSearch = console.nextInt();
        console.nextLine();
        //add
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        Arrays.stream(console.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .limit(elToAdd)
                .forEach(queue::add);
        //poll
        for (int i = 0; i < elToPoll; i++) {
            queue.poll();
        }
        // search
        if (queue.contains(elToSearch)){
            System.out.println(true);
        } else {
            int min = 0;
            if (!queue.isEmpty()){
                min = Collections.min(queue);
            }
            System.out.println(min);
        }
    }
}
