import java.util.Arrays;
import java.util.Scanner;

public class p02_MatrixOfPalindromes {
    public static void main(String[] args) {
         Scanner console = new Scanner(System.in);
         int[] input = Arrays.stream(console.nextLine().split(" "))
                 .mapToInt(Integer::parseInt)
                 .toArray();
         int rowInput = input[0];
         int colInput = input[1];
         String[][] matrix = new String[rowInput][colInput];

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                    matrix[row][col] = "" + (char)('a' + row) + (char)('a' + col + row) + (char)('a' + row);
            }
        }

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
