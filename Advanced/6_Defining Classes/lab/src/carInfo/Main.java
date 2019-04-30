package carInfo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split(" ");
            System.out.println("The car is: " + tokens[0] + " " + tokens[1] + " - " + tokens[2] +" HP.");
        }

    }
}
