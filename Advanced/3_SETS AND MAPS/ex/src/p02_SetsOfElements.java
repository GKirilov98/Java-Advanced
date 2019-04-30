import java.util.LinkedHashSet;
import java.util.Scanner;

public class p02_SetsOfElements {
    public static void main(String[] args) {
         Scanner console = new Scanner(System.in);
         int firsSize = console.nextInt();
         int secondSize = console.nextInt();
         console.nextLine();
        LinkedHashSet<String> firstSet = new LinkedHashSet<>();
        for (int i = 0; i < firsSize; i++) {
            firstSet.add(console.nextLine());
        }

        LinkedHashSet<String> secondSet = new LinkedHashSet<>();
        for (int i = 0; i < secondSize; i++) {
            secondSet.add(console.nextLine());
        }

        firstSet.retainAll(secondSet);
        firstSet.forEach(e -> System.out.print(e + " "));
    }
}
