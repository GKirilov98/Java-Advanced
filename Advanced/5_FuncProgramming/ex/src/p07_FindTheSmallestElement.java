
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class p07_FindTheSmallestElement {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
       ArrayList<String> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .collect(Collectors.toCollection(ArrayList::new)) ;
        String min = numbers.stream().mapToInt(Integer::parseInt).min().getAsInt() + "";
        System.out.println(numbers.lastIndexOf(min));
    }
}
