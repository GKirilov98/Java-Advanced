package p03_Dependecy;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        PrimitiveCalculator primitiveCalculator = new PrimitiveCalculator();
        while (!input.equals("End")) {
            String[] tokens = input.split(" ");
            int result = 0;
            if ("mode".equals(tokens[0])) {
               primitiveCalculator.changeStrategy(tokens[1].charAt(0));
            } else {
                System.out.println(primitiveCalculator
                        .performCalculation(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1])));
            }
             input = scanner.nextLine();
        }
    }
}
