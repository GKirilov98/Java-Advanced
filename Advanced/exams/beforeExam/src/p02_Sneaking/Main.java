package p02_Sneaking;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int[] samRowCol = new int[2];
    static int[] nikoladzeRowCol = new int[2];
    static String[][] field;
    static boolean samIsDead = false;
    static boolean nikoladzeIsDead = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine());
        field = new String[rows][];
        for (int r = 0; r < rows; r++) {
            field[r] = scanner.nextLine().split("");
            for (int c = 0; c < field[r].length; c++) {
                if (field[r][c].equals("S")) {
                    samRowCol[0] = r;
                    samRowCol[1] = c;
                } else if (field[r][c].equals("N")) {
                    nikoladzeRowCol[0] = r;
                    nikoladzeRowCol[1] = c;
                }
            }
        }

        String[] commands = scanner.nextLine().split("");
        for (String command : commands) {
            moveEnemies();
            checkSamDead();
            if (samIsDead) {
                break;
            }

            switch (command) {
                case "U":
                    moveSamUp();
                    break;
                case "D":
                    moveSamDown();
                    break;
                case "L":
                    moveSamLeft();
                    break;
                case "R":
                    moveSamRight();
                    break;
            }

            if (samRowCol[0] == nikoladzeRowCol[0]){
                nikoladzeIsDead = true;
                break;
            }

//            Arrays.stream(field).forEach(e -> System.out.println(String.join("", e)));
//            System.out.println();
        }

        if (samIsDead){
            field[samRowCol[0]][samRowCol[1]] = "X";
            System.out.println("Sam died at " + samRowCol[0] + ", "+ samRowCol[1]);
        } else {
            field[nikoladzeRowCol[0]][nikoladzeRowCol[1]] = "X";
            System.out.println("Nikoladze killed!");
        }

        Arrays.stream(field).forEach(e -> System.out.println(String.join("", e)));
    }


    private static void checkSamDead() {
        String[] currRow = field[samRowCol[0]];
        int c = samRowCol[1];
        for (int i = 0; i < currRow.length; i++) {
            if (currRow[i].equals("b")){
                if (i < c){
                    samIsDead = true;
                }
                break;
            } else if (currRow[i].equals("d")) {
                if (i > c){
                    samIsDead = true;
                }
                break;
            }
        }
    }

    private static void moveEnemies() {
        for (String[] row : field) {
            for (int i = 0; i < row.length; i++) {
                if (row[i].equals("b")) {
                    if (i == row.length - 1) {
                        row[i] = "d";
                    } else {
                        row[i] = ".";
                        row[i + 1] = "b";
                    }
                    break;
                } else if (row[i].equals("d")) {
                    if (i == 0) {
                        row[i] = "b";
                    } else {
                        row[i] = ".";
                        row[i - 1] = "d";
                    }
                    break;
                }
            }

        }
    }

    private static void moveSamRight() {
        int r = samRowCol[0];
        int c = samRowCol[1];
        if (c == field[r].length - 1) {
            return;
        }


        field[r][c] = ".";
        field[r][c + 1] = "S";
        samRowCol[1]++;
    }

    private static void moveSamLeft() {
        int r = samRowCol[0];
        int c = samRowCol[1];
        if (c == 0) {
            return;
        }


        field[r][c] = ".";
        field[r][c - 1] = "S";
        samRowCol[1]--;

    }

    private static void moveSamDown() {
        int r = samRowCol[0];
        int c = samRowCol[1];
        if (r == field.length - 1) {
            return;
        }


        field[r][c] = ".";
        field[r + 1][c] = "S";
        samRowCol[0]++;
    }

    private static void moveSamUp() {
        int r = samRowCol[0];
        int c = samRowCol[1];
        if (r == 0) {
            return;
        }

        field[r][c] = ".";
        field[r - 1][c] = "S";
        samRowCol[0]--;
    }
}
