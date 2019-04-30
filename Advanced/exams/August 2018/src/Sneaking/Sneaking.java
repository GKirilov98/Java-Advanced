package Sneaking;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sneaking {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int samRow = 0;
        int samCol = 0;
        int nRow = 0;
        int nCol = 0;

        char matrix[][] = null;
        int rows = Integer.valueOf(bf.readLine());

        for(int j = 0; j < rows; j++) {
            String row = bf.readLine();
            if(j == 0) {
                matrix = new char[rows][row.length()];
            }
            for(int k = 0; k < row.length(); k++) {
                char element = row.charAt(k);
                if(element == 'S') {
                    samRow = j;
                    samCol = k;
                }

                if(element == 'N') {
                    nRow = j;
                    nCol = k;
                }
                matrix[j][k] = element;
            }
        }
        String allDirections = bf.readLine();
        boolean isTrue = true;
        for(int i = 0; i < allDirections.length(); i++) {
            char direction = allDirections.charAt(i);
            moveEnemies(matrix);

            isTrue = checkIfEnemiesKillSam(matrix, samRow, samCol, nRow, nCol);
            if(!isTrue) {
                print(matrix);
                break;
            }
            if(direction == 'L') {
                if(samCol > 0) {
                    matrix[samRow][samCol] = '.';
                    matrix[samRow][--samCol] = 'S';
                }
            } else if (direction == 'R') {
                if(samCol < matrix[0].length - 1) {
                    matrix[samRow][samCol] = '.';
                    matrix[samRow][++samCol] = 'S';
                }
            } else if (direction == 'U') {
                if(samRow > 0) {
                    matrix[samRow][samCol] = '.';
                    matrix[--samRow][samCol] = 'S';
                }
            } else if (direction == 'D') {
                if(samRow < matrix.length - 1) {
                    matrix[samRow][samCol] = '.';
                    matrix[++samRow][samCol] = 'S';
                }
            }
            isTrue = checkIfEnemiesKillSam(matrix, samRow, samCol, nRow, nCol);
            if(!isTrue) {
                print(matrix);
                break;
            }
        }
    }

    // Check if Sam Or NIKODZIADE is dead
    private static boolean checkIfEnemiesKillSam(char[][] matrix, int samRow, int samCol, int nRow, int nCol) {
        for(int j = samRow; j <= samRow; j++) {
            for(int k = 0; k < matrix[0].length; k++) {
                char element = matrix[j][k];
                if(element == 'N') {
                    System.out.println("Nikoladze killed!");
                    matrix[nRow][nCol] = 'X';
                    return false;
                } else if (element == 'b') {
                    if (k < samCol) {
                        System.out.printf("Sam died at %d, %d%n", samRow, samCol);
                        matrix[samRow][samCol] = 'X';
                        return false;
                    }
                } else if (element == 'd') {
                    if(k > samCol) {
                        System.out.printf("Sam died at %d, %d%n", samRow, samCol);
                        matrix[samRow][samCol] = 'X';
                        return false;
                    }
                }
            }
        }
        return true;
    }

    // Move all enemies
    private static void moveEnemies(char[][] matrix) {
        for(int j = 0; j < matrix.length; j++) {
            for(int k = 0; k < matrix[0].length; k++) {
                char element = matrix[j][k];
                if(element == 'b' && k == matrix[0].length - 1) {
                    matrix[j][k] = 'd';
                    break;
                }else if (element == 'd' && k == 0) {
                    matrix[j][k] = 'b';
                    break;
                }else if (element == 'b' && k < matrix[0].length - 1) {
                    matrix[j][k + 1] = 'b';
                    matrix[j][k] = '.';
                    break;
                }else if (element == 'd' && k > 0) {
                    matrix[j][k - 1] = 'd';
                    matrix[j][k] = '.';
                    break;
                }
            }
        }
    }

    // Printing
    public static void print(char matrix[][]) {

        for(int j = 0; j < matrix.length; j++) {
            for(int k = 0; k < matrix[0].length; k++) {
                System.out.print(matrix[j][k]);
            }
            System.out.println();
        }
    }
}















//package Sneaking;
//
//import java.util.Arrays;
//import java.util.Scanner;
//
//public class Main {
//    static String[][] field;
//    static int rowS;
//    static int colS;
//    static boolean isDead = false;
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int row = Integer.parseInt(scanner.nextLine());
//        String[] lines = scanner.nextLine().split("");
//        field = new String[row][lines.length];
//        for (int i = 0; i < row; i++) {
//            for (int j = 0; j < lines.length; j++) {
//                field[i][j] = lines[j];
//
//                if (lines[j].equals("S")) {
//                    rowS = i;
//                    colS = j;
//                }
//            }
//            if (i != row - 1) {
//                lines = scanner.nextLine().split("");
//            }
//
//        }
//
//        String[] commands = scanner.nextLine().split("");
//
//        for (String command : commands) {
//            if (isDead) {
//                break;
//            }
//            moveEvils();
//            switch (command) {
//                case "R":
//                    moveRight();
//                    break;
//                case "L":
//                    moveLeft();
//                    break;
//                case "U":
//                    moveUp();
//                    break;
//                case "D":
//                    moveDown();
//                    break;
//            }
//
//            checkField();
//            Arrays.stream(field).forEach(e -> System.out.println(String.join("", e)));
//            System.out.println();
//        }
//    }
//
//    private static void moveUp() {
//        if (rowS == 0) {
//            return;
//        }
//
//        field[rowS][colS] = ".";
//        field[rowS - 1][colS] = "S";
//        rowS--;
//    }
//
//    private static void moveDown() {
//        if (rowS == field[0].length -1) {
//            return;
//        }
//
//        field[rowS][colS] = ".";
//        field[rowS + 1][colS] = "S";
//        rowS++;
//    }
//
//    private static void moveLeft() {
//        if (colS == 0) {
//            return;
//        }
//
//        field[rowS][colS] = ".";
//        field[rowS][colS -1] = "S";
//        colS--;
//    }
//
//    private static void moveRight() {
//        if (colS == field.length - 1) {
//            return;
//        }
//
//        field[rowS][colS] = ".";
//        field[rowS][colS + 1] = "S";
//        colS++;
//    }
//
//    private static void checkField() {
//        String fullRow = String.join("", field[rowS]);
//        if (fullRow.contains("b") && fullRow.indexOf("b") < fullRow.indexOf("S")) {
//            isDead = true;
//            field[rowS][colS] = "X";
//            System.out.println("Sam died at " + rowS + ", " + colS);
//        } else if (fullRow.indexOf("d") > fullRow.indexOf("S")) {
//            isDead = true;
//            field[rowS][colS] = "X";
//            System.out.println("Sam died at " + rowS + ", " + colS);
//        } else if (fullRow.contains("N")) {
//            isDead = true;
//            field[rowS][fullRow.indexOf("N")] = "X";
//            System.out.println("Nikoladze killed!");
//        }
//    }
//
//    private static void moveEvils() {
//        for (String[] symbols : field) {
//            String rowString = Arrays.toString(symbols);
//            if (rowString.contains("b")) {
//                for (int i = symbols.length - 1; i >= 0; i--) {
//                    if (!symbols[i].equals("b")) {
//                        continue;
//                    }
//
//                    if (i == symbols.length - 1) {
//                        symbols[i] = "d";
//                    } else {
//                        symbols[i] = ".";
//                        symbols[i + 1] = "b";
//                    }
//                }
//
//            } else if (rowString.contains("d")) {
//                for (int i = 0; i < symbols.length; i++) {
//                    if (!symbols[i].equals("d")) {
//                        continue;
//                    }
//
//                    if (i == 0) {
//                        symbols[i] = "b";
//                    } else {
//                        symbols[i] = ".";
//                        symbols[i - 1] = "d";
//                    }
//                }
//            }
//        }
//    }
//}
