package p02_ExcelFunctions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine());
        String[][] matrix = new String[rows - 1][];
        String[] headers = scanner.nextLine().split(", ");
        for (int i = 0; i < rows - 1; i++) {
            matrix[i] = scanner.nextLine().split(", ");
        }

        String[] tokens = scanner.nextLine().split(" ");
        String command = tokens[0];
        String head = tokens[1];
        int indexHead = -1;
        for (int i = 0; i < headers.length; i++) {
            if (headers[i].equals(head)) {
                indexHead = i;
            }
        }

        switch (command) {
            case "hide":
                for (int r = 0; r < matrix.length; r++) {
                    matrix[r][indexHead] = "";
                    headers[indexHead] = "";
                    matrix[r] = Arrays.stream(matrix[r]).filter(e -> !e.isEmpty()).toArray(String[]::new);
                }
                headers = Arrays.stream(headers).filter(e -> !e.isEmpty()).toArray(String[]::new);
                break;
            case "sort":
                int finalIndexHead = indexHead;
                matrix = Arrays.stream(matrix)
                        .sorted(Comparator.comparing(f -> f[finalIndexHead]))
                        .toArray(String[][]::new);
                break;
            case "filter":
                String value = tokens[2];
                ArrayList<Integer> filteredTableIndex = new ArrayList<>();
                for (int r = 0; r < matrix.length; r++) {
                    if (matrix[r][indexHead].equals(value)) {
                        filteredTableIndex.add(r);
                    }
                }

                System.out.println(String.join(" | ", headers));
                for (Integer tableIndex : filteredTableIndex) {
                    System.out.println(String.join(" | ", matrix[tableIndex]));
                }
                return;
        }

        System.out.println(String.join(" | ", headers));
        for (String[] row : matrix) {
            System.out.println(String.join(" | ", row));
        }
    }
}
