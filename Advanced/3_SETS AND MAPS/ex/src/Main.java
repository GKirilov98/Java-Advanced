import java.util.LinkedHashSet;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
         Scanner console = new Scanner(System.in);
         int n = Integer.parseInt(console.nextLine());
        LinkedHashSet<String> usernames = new LinkedHashSet<>();
        for (int i = 0; i < n; i++) {
            usernames.add(console.nextLine());
        }
        usernames.forEach(System.out::println);
    }
}
