package p04_TheMatrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static char[][] matrix;
    public static char color;
    public static char tobeReplaced;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];
        matrix = new char[rows][cols];

        for (int r = 0; r < rows; r++) {
            matrix[r] = scanner.nextLine().replaceAll(" +", "").toCharArray();
        }

        color = scanner.nextLine().charAt(0);
        int[] indexes = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int startRow = indexes[0];
        int startCol = indexes[1];

        tobeReplaced = matrix[startRow][startCol];
        painMatrix(startRow, startCol);

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                System.out.print(matrix[r][c]);
            }
            System.out.println();
        }

    }

    private static void painMatrix(int r, int c) {
        if (!isInBounds(r, c) || matrix[r][c] == color || matrix[r][c] != tobeReplaced) {
            return;
        }

        matrix[r][c] = color;
        painMatrix(r + 1, c);
        painMatrix(r - 1, c);
        painMatrix(r, c + 1);
        painMatrix(r, c - 1);
    }

    private static boolean isInBounds(int r, int c) {
        return r >= 0 && r < matrix.length && c >= 0 && c < matrix[r].length;
    }
}

