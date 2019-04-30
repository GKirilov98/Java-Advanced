package p01_BoxClass;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double length = Double.parseDouble(scanner.nextLine());
        double width = Double.parseDouble(scanner.nextLine());
        double height = Double.parseDouble(scanner.nextLine());
        try {
            Box box = new Box(length, width, height);
            double surfaceArea = box.calculateSurfaceArea();
            double lateralSA = box.calculateLateralSurfaceArea();
            double volume = box.calculateVolume();

            System.out.printf("Surface Area - %.2f\n" +
                    "Lateral Surface Area - %.2f\n" +
                    "Volume – %.2f", surfaceArea, lateralSA, volume);

        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
