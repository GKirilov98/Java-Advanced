import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;

public class p03_PeriodicTable {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int n = Integer.parseInt(console.nextLine());
        TreeSet<String> periodicTable = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            String[] tokens = console.nextLine().split("\\s+");
            periodicTable.addAll(Arrays.asList(tokens));
        }
        periodicTable.forEach(e -> System.out.print(e + " "));
    }
}
