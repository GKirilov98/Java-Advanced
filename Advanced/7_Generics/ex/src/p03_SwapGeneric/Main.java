package p03_SwapGeneric;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n =  Integer.parseInt(scanner.nextLine());
        ArrayList<Box> boxes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Integer  token = Integer.parseInt(scanner.nextLine());
            Box<Integer> box = new Box<>(token);
            boxes.add(box);
        }
        int firstIndex = scanner.nextInt();
        int secondIndex = scanner.nextInt();
        swapList(firstIndex, secondIndex, boxes);
        boxes.forEach(e -> System.out.println(e.toString()));
    }

    private static void swapList(int firstIndex, int secondIndex, ArrayList<Box> boxes) {
        boxes.add(firstIndex + 1, boxes.get(secondIndex));
        Box<Integer> removedBoxes = boxes.remove(firstIndex);
        boxes.remove(secondIndex);
        boxes.add(secondIndex , removedBoxes);
    }


}
