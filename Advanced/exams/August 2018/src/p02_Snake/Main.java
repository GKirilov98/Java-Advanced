package p02_Snake;

import java.util.Scanner;

public class Main {
    static String[][] fieldScreen;
    static int rowSnake = 0;
    static int colSnake = 0;
    static int snakeLength = 1;
    static int foodCount = 0;
    static boolean isStopping = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        fieldScreen = new String[n][n];
        String[] commands = scanner.nextLine().split(", ");
        for (int row = 0; row < n; row++) {
            String[] tokens = scanner.nextLine().split(" ");
            for (int col = 0; col < n; col++) {
                fieldScreen[row][col] = tokens[col];
                if (tokens[col].equals("s")) {
                    rowSnake = row;
                    colSnake = col;
                } else if (tokens[col].equals("f")){
                    foodCount++;
                }
            }
        }

        for (String command : commands) {
            switch (command) {
                case "right":
                    moveRight();
                    break;
                case "left":
                    moveLeft();
                    break;
                case "up":
                    moveUp();
                    break;
                case "down":
                    moveDown();
                    break;
            }

            if (foodCount == 0 || isStopping){
                break;
            }
        }

        printResult();
    }

    private static void printResult() {
        if (foodCount == 0){
            System.out.println("You win! Final snake length is " + snakeLength);
        } else if (isStopping){
            System.out.println("You lose! Killed by an enemy!");
        } else {
            System.out.println("You lose! There is still "+ foodCount +" food to be eaten.");
        }
    }

    private static void moveDown() {
        fieldScreen[rowSnake][colSnake] = "*";
        if (rowSnake == fieldScreen.length-1) {
            rowSnake = -1;
        }

        if (fieldScreen[rowSnake +1 ][colSnake].equals("f")) {
            fieldScreen[rowSnake + 1][colSnake ] = "s";
            rowSnake++;
            foodCount--;
            snakeLength++;
        } else if (fieldScreen[rowSnake + 1][colSnake].equals("e")) {
            isStopping = true;
        } else {
            fieldScreen[rowSnake + 1][colSnake] = "s";
            rowSnake++;
        }

    }

    private static void moveUp() {
        fieldScreen[rowSnake][colSnake] = "*";
        if (rowSnake == 0) {
            rowSnake = fieldScreen.length;
        }

        if (fieldScreen[rowSnake -1 ][colSnake].equals("f")) {
            fieldScreen[rowSnake - 1][colSnake ] = "s";
            rowSnake--;
            foodCount--;
            snakeLength++;
        } else if (fieldScreen[rowSnake - 1][colSnake].equals("e")) {
            isStopping = true;
        } else {
            fieldScreen[rowSnake - 1][colSnake] = "s";
            rowSnake--;
        }
    }

    private static void moveLeft() {
        fieldScreen[rowSnake][colSnake] = "*";
        if (colSnake == 0) {
            colSnake = fieldScreen.length;
        }

        if (fieldScreen[rowSnake][colSnake - 1].equals("f")) {
            fieldScreen[rowSnake][colSnake - 1] = "s";
            colSnake--;
            foodCount--;
            snakeLength++;
        } else if (fieldScreen[rowSnake][colSnake - 1].equals("e")) {
            isStopping = true;
        } else {
            fieldScreen[rowSnake][colSnake - 1] = "s";
            colSnake--;
        }
    }

    private static void moveRight() {
        fieldScreen[rowSnake][colSnake] = "*";
        if (colSnake == fieldScreen.length - 1) {
            colSnake = -1;
        }

        if (fieldScreen[rowSnake][colSnake + 1].equals("f")) {
            fieldScreen[rowSnake][colSnake + 1] = "s";
            colSnake++;
            foodCount--;
            snakeLength++;
        } else if (fieldScreen[rowSnake][colSnake + 1].equals("e")) {
            isStopping = true;
        } else {
            fieldScreen[rowSnake][colSnake + 1] = "s";
            colSnake++;
        }
    }
}
