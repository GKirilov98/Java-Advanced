import java.util.Arrays;
import java.util.Scanner;

public class p04_MaximalSum {

    private static int sum = 0;
    private static int[][] tempMatrix = new int[3][3];

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int rowSize = console.nextInt();
        int colSize = console.nextInt();
        console.nextLine();
        int[][] matrixInput = new int[rowSize][colSize];
        for (int row = 0; row < matrixInput.length; row++) {
            matrixInput[row] = Arrays.stream(console.nextLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
        }

        int maxSum = 0;
        int[][] maxMatrix = new int[3][3];

        for (int row = 1; row < rowSize - 1; row++) {
            for (int col = 1; col < colSize - 1; col++) {
                calculateMatrixSum(matrixInput, row, col);

                if (sum > maxSum) {
                    maxSum = sum;
                    maxMatrix = tempMatrix;
                }
            }
        }

        System.out.println("Sum = " + maxSum);
        for (int row = 0; row < maxMatrix.length; row++) {
            for (int col = 0; col < maxMatrix[row].length; col++) {
                System.out.print(maxMatrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static void calculateMatrixSum(int[][] matrix, int r, int c) {
            sum = 0;
        int tempMatrixRow = 0;
        tempMatrix = new int[3][3];
        for (int row = r - 1; row <= r + 1; row++) {
            int tempMatrixCol = 0;
            for (int col = c - 1; col <= c + 1; col++) {
                sum += matrix[row][col];
                tempMatrix [tempMatrixRow][tempMatrixCol++] = matrix[row][col];
            }
            tempMatrixRow++;
        }
    }


}
