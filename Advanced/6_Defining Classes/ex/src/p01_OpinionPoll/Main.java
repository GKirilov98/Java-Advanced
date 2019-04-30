package p01_OpinionPoll;

import java.util.*;

public class Main {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
         int n = Integer.parseInt(scanner.nextLine());
        List<Person> personsOlderThan30 = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split(" ");
            int age = Integer.parseInt(tokens[1]);
            if ( age > 30){
                personsOlderThan30.add(new Person(tokens[0], age));
            }
        }

        personsOlderThan30
                .sort(Comparator.comparing(Person::getName));
        personsOlderThan30.forEach(e -> System.out.println(e.getInfo()));

    }
}
