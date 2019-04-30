import java.util.Arrays;
import java.util.Scanner;

public class p03_DiagonalDifference {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int size = Integer.parseInt(console.nextLine());
        int[][] matrix = new int[size][size];
        for (int row = 0; row < size; row++) {
            int[] colInput = Arrays.stream(console.nextLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            for (int col = 0; col < size; col++) {
                matrix[row][col] = colInput[col];
            }
        }

        int sumFirstDiagonal = sumFirstDiagonal(matrix);
        int sumSecondDiagonal = sumSecondDiagonal(matrix);
        int diference = Math.abs(sumFirstDiagonal - sumSecondDiagonal);
        System.out.println(diference);
    }

    private static int sumSecondDiagonal(int[][] matrix) {
        int sum = 0;
        int row = 0;
        for (int col = matrix.length -1; col >= 0; col--) {
            sum += matrix[row++][col];
        }
        return sum;
    }

    private static int sumFirstDiagonal(int[][] matrix) {
        int sum = 0;
        for (int rowCol = 0; rowCol < matrix.length; rowCol++) {
            sum += matrix[rowCol][rowCol];
        }
        return sum;
    }
}
