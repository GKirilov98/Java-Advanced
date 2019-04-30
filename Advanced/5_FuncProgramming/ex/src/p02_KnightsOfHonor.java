import java.util.Arrays;
import java.util.Scanner;

public class p02_KnightsOfHonor {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
        Arrays.stream(scanner.nextLine().split(" "))
                .forEach(n ->  System.out.println( "Sir " + n) );
    }
}
