import java.util.Arrays;
import java.util.Scanner;

public class p06_PredicateForNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        Arrays.stream(scanner.nextLine().split(" "))
                .filter(e -> e.length() <= size)
                .forEach(System.out::println);
    }
}
