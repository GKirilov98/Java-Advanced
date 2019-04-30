package p01_Internship;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int problemsCount = Integer.parseInt(scanner.nextLine());
        int programmersCount = Integer.parseInt(scanner.nextLine());
        ArrayDeque<String> allProblems = new ArrayDeque<>();
        while (problemsCount-- > 0) {
            allProblems.push(scanner.nextLine());
        }

        ArrayDeque<String> allProgrammers = new ArrayDeque<>();
        while (programmersCount-- > 0) {
            String name = scanner.nextLine();
            boolean matches = name.matches("\\b[A-Z][a-z]+\\s+[A-Z][a-z]+\\b");
            if (matches) {
                String[] tokens = name.split("\\s+");
                allProgrammers.add(tokens[0] + " " + tokens[1]);
            }
        }

        StringBuilder stringBuilder = new StringBuilder();

        while (allProblems.size() > 0 && allProgrammers.size() > 1) {
            String problem = allProblems.pop();
            String programmer = allProgrammers.remove();
            int problemSum = getSum(problem);
            int programmerSum = getSum(programmer);
            if (programmerSum > problemSum){
                allProgrammers.addLast(programmer);
                stringBuilder.append(String.format("%s solved %s.\n", programmer, problem));
            } else {
                allProblems.addLast(problem);
                stringBuilder.append(String.format("%s failed %s.\n", programmer, problem));
            }
        }

        if (allProgrammers.size()==1){
            stringBuilder.append(String.format("%s gets the job!", allProgrammers.remove()));
        } else {
           stringBuilder.append(String.join(",", allProgrammers));
        }

        System.out.println(stringBuilder);
    }

    private static int getSum(String word) {
       return Arrays.stream(word.split("")).mapToInt(String::hashCode).sum();
    }
}
