package p02_NestedLoops;

import java.util.Scanner;

public class Main {

    static int numberOfLoops;
    static int numberOfIterations;
    static int[] loops;

    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
        numberOfLoops = Integer.parseInt(scanner.nextLine());
        numberOfIterations = numberOfLoops;
        loops = new int[numberOfLoops];
        NestedLoops(0);

    }

    static void NestedLoops(int currentLoop)
    {
        if (currentLoop == numberOfLoops)
        {
            PrintLoops();
            return;
        }
        for (int counter = 1; counter <= numberOfIterations; counter++)
        {
            loops[currentLoop] = counter;
            NestedLoops(currentLoop + 1);
        }
    }

    static void PrintLoops()
    {
        for (int i = 0; i < numberOfLoops; i++)
        {
            System.out.print(String.format("%s ", loops[i]));
        }

        System.out.println();
    }
}
