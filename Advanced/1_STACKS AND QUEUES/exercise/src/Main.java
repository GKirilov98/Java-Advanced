import java.util.*;

public class Main {
    public static void main(String[] args) {
	// write your code here
         Scanner console = new Scanner(System.in);
        int[] arr = Arrays.stream(console.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer> normal = new ArrayDeque<>();
        for (int i = 0; i < arr.length; i++) {
            normal.push(arr[i]);
        }
        for (Integer x : normal) {
            System.out.printf("%d ", x);
        }
    }
}
