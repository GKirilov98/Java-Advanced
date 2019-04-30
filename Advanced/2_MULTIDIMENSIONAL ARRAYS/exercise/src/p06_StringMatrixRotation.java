import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class p06_StringMatrixRotation {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int rotate = Integer.parseInt(console.nextLine().split("[()]+")[1]) % 360;

        ArrayList<String> inputWords = new ArrayList<>();
        int maxLenghtWord = 0;
        while (true) {
            String word = console.nextLine();
            if (word.equals("END")) {
                break;
            }
            inputWords.add(word);
            if (maxLenghtWord < word.length()) {
                maxLenghtWord = word.length();
            }
        }
        int wordCounts = inputWords.size();
        char[][] matrix = new char[wordCounts][maxLenghtWord];
        for (int r = 0; r < wordCounts; r++) {
            for (int c = 0; c < maxLenghtWord; c++) {
                if (c > inputWords.get(r).length() - 1) {
                    matrix[r][c] = ' ';
                } else {
                    matrix[r][c] = inputWords.get(r).charAt(c);
                }

            }
        }

        switch (rotate) {
            case 0:
                printMatrix0Degrees(matrix);
                break;
            case 90:
                printMatrix90Degrees(matrix, wordCounts);
                break;
            case 180:
                printMatrix180Degrees(matrix);
                break;
            default:
                printMatrix270Degrees(matrix);
                break;
        }
    }

    private static void printMatrix270Degrees(char[][] matrix) {
        if (matrix.length > 0) {
            for (int col = matrix[0].length - 1; col >= 0 ; col--) {
                for (int row = 0; row < matrix.length; row++) {
                    System.out.print(matrix[row][col]);
                }
                System.out.println();
            }
        }
    }

    private static void printMatrix180Degrees(char[][] matrix) {
        for (int row = matrix.length - 1; row >= 0; row--) {
            for (int col = matrix[row].length - 1; col>=0 ; col--) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static void printMatrix90Degrees(char[][] matrix, int rowCount) {
        if (matrix.length > 0) {
            for (int col = 0; col < matrix[0].length; col++) {
                for (int row = matrix.length - 1; row >= 0; row--) {
                    System.out.print(matrix[row][col]);
                }
                System.out.println();
            }
        }
    }

    private static void printMatrix0Degrees(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }
}
