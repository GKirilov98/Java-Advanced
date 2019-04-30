import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
         Scanner console = new Scanner(System.in);
         String[] input = console.nextLine().split(", ");
         int size = Integer.parseInt(input[0]);
         String pattern = input[1];
         int[][] matrix = new int[size][size];
         if (pattern.equals("A")){
             matrixModifyPatternA(matrix, size);
         } else {
             matrixModifySecondPatternB(matrix, size);
         }

         printMatrix(matrix);
    }

    private static void matrixModifySecondPatternB(int[][] matrix, int size) {
        int value = 1;
        for (int col = 0; col < size; col++) {
            if (col % 2 == 0){
                for (int row = 0; row < size; row++) {
                    matrix[row][col] = value++;
                }
            } else {
                for (int row = size - 1; row >= 0; row--) {
                    matrix[row][col] = value++;
                }
            }
        }
    }

    private static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static void matrixModifyPatternA(int[][] matrix, int size) {
        int value = 1;
        for (int col = 0; col < size; col++) {
            for (int row = 0; row < size; row++) {
                matrix[row][col] = value++;
            }
        }
    }
}
