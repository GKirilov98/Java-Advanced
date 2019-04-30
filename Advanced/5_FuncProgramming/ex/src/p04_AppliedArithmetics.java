import java.util.*;

import static java.util.stream.Collectors.toCollection;

public class p04_AppliedArithmetics {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> numbers = Arrays
                .stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(toCollection(ArrayList::new));
        String line = scanner.nextLine();
        while (!line.equals("end")){
            switch (line){
                case "add":
                   numbers = numbers.stream().map(e -> e+=1).collect(toCollection(ArrayList::new));
                    break;
                case "multiply":
                    numbers = numbers.stream().map(e -> e*=2).collect(toCollection(ArrayList::new));
                    break;
                case "subtract":
                    numbers = numbers.stream().map(e -> e-=1).collect(toCollection(ArrayList::new));
                    break;
                case "print":
                    numbers.forEach(e -> System.out.print(e + " "));
                    System.out.println();
                    break;
            }
            line = scanner.nextLine();
        }
    }
}
