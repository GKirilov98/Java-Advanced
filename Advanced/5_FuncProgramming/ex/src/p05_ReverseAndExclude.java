import java.util.*;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.toList;

public class p05_ReverseAndExclude {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers =
                Arrays.stream(scanner.nextLine().split(" "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toCollection(ArrayList::new));
        int divideNum = Integer.parseInt(scanner.nextLine());
       numbers = numbers.stream()
               .filter(e -> e % divideNum != 0)
               .collect(toList());
        Collections.reverse(numbers);
        numbers.forEach(e -> System.out.print(e + " "));
    }
}
