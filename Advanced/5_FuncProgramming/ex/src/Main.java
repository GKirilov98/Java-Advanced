import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner scanner = new Scanner(System.in);
        Arrays.stream(scanner.nextLine().split(" ")).forEach(System.out::println);
    }
}
