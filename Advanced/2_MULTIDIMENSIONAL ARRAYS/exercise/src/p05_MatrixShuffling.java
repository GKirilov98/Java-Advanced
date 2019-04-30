import java.util.Scanner;

public class p05_MatrixShuffling {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int rowSize = console.nextInt();
        int colSize = console.nextInt();
        console.nextLine();
        String[][] matrix = new String[rowSize][colSize];
        for (int i = 0; i < rowSize; i++) {
            matrix[i] = console.nextLine().split(" ");
        }

        String command = console.nextLine();
        while (!command.equals("END")){
            String[] tokens = command.split(" ");
            if (tokens.length != 5){
                System.out.println("Invalid input!");
            } else {
                int row1 = Integer.parseInt(tokens[1]);
                int col1 = Integer.parseInt(tokens[2]);
                int row2 = Integer.parseInt(tokens[3]);
                int col2 = Integer.parseInt(tokens[4]);

                if (row1 > rowSize  || col1 > colSize || row2 > rowSize || col2 > colSize){
                    System.out.println("Invalid input!");
                } else {
                    String firstNum = matrix[row1][col1];
                    matrix[row1][col1] = matrix[row2][col2];
                    matrix[row2][col2] = firstNum;

                    for (int row = 0; row < matrix.length; row++) {
                        for (int col = 0; col < matrix[row].length; col++) {
                            System.out.print(matrix[row][col] + " ");
                        }
                        System.out.println();
                    }
                }
            }

            command = console.nextLine();
        }
    }
}
