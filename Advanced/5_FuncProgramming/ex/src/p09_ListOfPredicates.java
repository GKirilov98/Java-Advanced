import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Predicate;

public class p09_ListOfPredicates {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        if (n < 0) {
            return;
        }

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }

        int[] divisors = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        Predicate<Integer> check = (i) -> {
            for (Integer a : divisors) {
                if (a == 0)
                    continue;
                if (i % a != 0)
                    return false;
            }
            return true;
        };

        for (Integer i : arr){
            if (check.test(i)){
                System.out.printf("%d ", i);
            }
        }
    }
}

