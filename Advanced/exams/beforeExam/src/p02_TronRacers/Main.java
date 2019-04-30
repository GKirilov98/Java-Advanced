package p02_TronRacers;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static String[][] matrix;
    static int[] fRowCol = new int[2];
    static int[] sRowCol = new int[2];
    static boolean isEnd = true;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        matrix = new String[size][size];
        for (int r = 0; r < size; r++) {
            matrix[r] = scanner.nextLine().split("");
            for (int c = 0; c < matrix[r].length; c++) {
                if (matrix[r][c].equals("f")) {
                    fRowCol[0] = r;
                    fRowCol[1] = c;
                } else if (matrix[r][c].equals("s")) {
                    sRowCol[0] = r;
                    sRowCol[1] = c;
                }
            }
        }


        while (isEnd) {
            String[] commands = scanner.nextLine().split("\\s+");
            switch (commands[0]) {
                case "right":
                    fMoveRight();
                    break;
                case "left":
                    fMoveLeft();
                    break;
                case "up":
                    fMoveUp();
                    break;
                case "down":
                    fMoveDown();
                    break;
            }
            if (!isEnd){
                break;
            }

            switch (commands[1]) {
                case "right":
                    sMoveRight();
                    break;
                case "left":
                    sMoveLeft();
                    break;
                case "up":
                    sMoveUp();
                    break;
                case "down":
                    sMoveDown();
                    break;
            }

        }

        Arrays.stream(matrix).forEach(e -> System.out.println(String.join("", e)));
    }

    private static void sMoveDown() {
        if (sRowCol[0] == matrix.length - 1) {
            sRowCol[0] = -1;
        }

        if ( matrix[sRowCol[0] + 1][sRowCol[1]].equals("f")){
            isEnd = false;
            matrix[sRowCol[0]+ 1][sRowCol[1]] = "x";
            return;
        }

        matrix[sRowCol[0] + 1][sRowCol[1]] = "s";
        sRowCol[0]++;
    }

    private static void sMoveUp() {
        if (sRowCol[0] == 0) {
            sRowCol[0] = matrix.length;
        }

        if ( matrix[sRowCol[0] - 1][sRowCol[1]].equals("f")){
            isEnd = false;
            matrix[sRowCol[0]- 1][sRowCol[1]] = "x";
            return;
        }


        matrix[sRowCol[0] - 1][sRowCol[1]] = "s";
        sRowCol[0]--;

    }

    private static void sMoveLeft() {
        if (sRowCol[1] == 0) {
            sRowCol[1] = matrix.length;
        }

        if ( matrix[sRowCol[0]][sRowCol[1] - 1].equals("f")){
            isEnd = false;
            matrix[sRowCol[0]][sRowCol[1] - 1] = "x";
            return;
        }


        matrix[sRowCol[0]][sRowCol[1] - 1] = "s";
        sRowCol[1]--;


    }

    private static void sMoveRight() {
        if (sRowCol[1] == matrix.length - 1) {
            sRowCol[1] = -1;
        }
        if ( matrix[sRowCol[0]][sRowCol[1] + 1].equals("f")){
            isEnd = false;
            matrix[sRowCol[0]][sRowCol[1] + 1] = "x";
            return;
        }

        matrix[sRowCol[0]][sRowCol[1] + 1] = "s";
        sRowCol[1]++;
    }


    private static void fMoveDown() {
        if (fRowCol[0] == matrix.length - 1) {
            fRowCol[0] = -1;
        }

        if (matrix[fRowCol[0] + 1][fRowCol[1]].equals("s")){
            isEnd = false;
            matrix[fRowCol[0] + 1][fRowCol[1]] = "x";
            return;
        }

        matrix[fRowCol[0] + 1][fRowCol[1]] = "f";
        fRowCol[0]++;

    }

    private static void fMoveUp() {
        if (fRowCol[0] == 0) {
            fRowCol[0] = matrix.length;
        }

        if (matrix[fRowCol[0] - 1][fRowCol[1]].equals("s")){
            isEnd = false;
            matrix[fRowCol[0] - 1][fRowCol[1]] = "x";
            return;
        }

        matrix[fRowCol[0] - 1][fRowCol[1]] = "f";
        fRowCol[0]--;
    }

    private static void fMoveLeft() {
        if (fRowCol[1] == 0) {
            fRowCol[1] = matrix.length;
        }

        if (matrix[fRowCol[0]][fRowCol[1] - 1].equals("s")){
            isEnd = false;
            matrix[fRowCol[0]][fRowCol[1] - 1] = "x";
            return;
        }
        matrix[fRowCol[0]][fRowCol[1] - 1] = "f";
        fRowCol[1]--;
    }

    private static void fMoveRight() {

        if (fRowCol[1] == matrix.length - 1) {
            fRowCol[1] = -1;
        }

        if (matrix[fRowCol[0]][fRowCol[1] + 1].equals("s")){
            isEnd = false;
            matrix[fRowCol[0]][fRowCol[1] + 1] = "x";
            return;
        }

        matrix[fRowCol[0]][fRowCol[1] + 1] = "f";
        fRowCol[1]++;
    }
}
