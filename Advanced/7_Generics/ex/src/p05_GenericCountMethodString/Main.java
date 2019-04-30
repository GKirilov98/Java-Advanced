package p05_GenericCountMethodString;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Generic<String>> allInputs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Generic<String> token = new Generic<>((scanner.nextLine()));
            allInputs.add(token);
        }

        String comparedElement = scanner.nextLine();
        int count = 0;
        for (Generic<String> input : allInputs) {
            if (input.compareTo(comparedElement)){
                count ++;
            }
        }

        System.out.println(count);

    }
}
