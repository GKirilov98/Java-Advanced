import java.util.Arrays;
import java.util.Scanner;

public class p03_CustomMinFunction {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
        System.out.println(Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).min().getAsInt());
    }
}
