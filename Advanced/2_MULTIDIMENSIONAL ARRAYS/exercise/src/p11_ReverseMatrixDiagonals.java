import java.util.Arrays;
import java.util.Scanner;

public class p11_ReverseMatrixDiagonals {
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

        int row = rowSize - 1;
        int col = colSize - 1;

        while (row != -1){
            int c = col;
            int r = row;
            while (c < colSize && r>=0){
                System.out.print(matrixInput[r--][c++] + " ");
            }
            System.out.println();
            col--;

            if (col == -1 ){
                col = 0;
                row--;
            }
        }
    }
}
