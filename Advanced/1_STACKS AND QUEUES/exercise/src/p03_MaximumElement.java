import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class p03_MaximumElement {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int n = Integer.parseInt(console.nextLine());
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            String[] tokens = console.nextLine().split(" ");
            switch (tokens[0]){
                case "1":
                    stack.push(Integer.parseInt(tokens[1]));
                    break;
                case "2":
                    stack.pop();
                    break;
                case "3":
                    int max = Collections.max(stack);
                    System.out.println(max);
                    break;
            }
        }
    }
}
