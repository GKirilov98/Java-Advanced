package p02_BombField;
import java.util.Scanner;

public class Main {

    public static String[][] field;
    public static int bombCount = 0;
    public static int rowS = 0;
    public static int colS = 0;
    public static boolean isStopping = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        field = new String[n][n];
        String[] wayCommands = scanner.nextLine().split(",");
        for (int row = 0; row < n; row++) {
            String[] colsTokens = scanner.nextLine().split("\\s+");
            for (int col = 0; col < n; col++) {
                field[row][col] = colsTokens[col];
                if (colsTokens[col].equals("B")) {
                    bombCount++;
                } else if (colsTokens[col].equals("s")) {
                    rowS = row;
                    colS = col;
                }
            }
        }

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < wayCommands.length; i++) {
            switch (wayCommands[i]) {
                case "left":
                    stringBuilder.append(moveItLeft());
                    break;
                case "right":
                    stringBuilder.append(moveItRight());
                    break;
                case "up":
                    stringBuilder.append(moveItUp());
                    break;
                case "down":
                    stringBuilder.append(moveItDown());
                    break;
            }

            if (bombCount == 0 || isStopping) break;
        }

        if (bombCount == 0) {
            stringBuilder.append("Congratulations! You found all bombs!");
        } else if (!isStopping) {
            stringBuilder.append(bombCount + " bombs left on the field. Sapper position: (" + rowS + "," + colS + ")");
        }

        System.out.println(stringBuilder);


        //   Arrays.stream(field).forEach(e-> System.out.println(String.join(" ", e)));
    }

    private static String moveItDown() {
        if (rowS == field.length - 1) {
            return "";
        }
        field[rowS][colS] = "+";
        if (field[rowS + 1][colS].equals("B")) {
            field[rowS + 1][colS] = "s";
            rowS++;
            bombCount--;
            return "You found a bomb!\n";
        } else if (field[rowS + 1][colS].equals("e")) {
            isStopping = true;
            return "END! " + bombCount + " bombs left on the field";
        } else {
            field[rowS + 1][colS] = "s";
            rowS++;
        }

        return "";
    }

    private static String moveItUp() {
        if (rowS == 0) {
            return "";
        }
        field[rowS][colS] = "+";
        if (field[rowS - 1][colS].equals("B")) {
            field[rowS - 1][colS] = "s";
            rowS--;
            bombCount--;
            return "You found a bomb!\n";
        } else if (field[rowS - 1][colS].equals("e")) {
            isStopping = true;
            return "END! " + bombCount + " bombs left on the field";
        } else {
            field[rowS - 1][colS] = "s";
            rowS--;
        }

        return "";
    }

    private static String moveItRight() {
        if (colS == field.length - 1) {
            return "";
        }
        field[rowS][colS] = "+";
        if (field[rowS][colS + 1].equals("B")) {
            field[rowS][colS + 1] = "s";
            colS++;
            bombCount--;
            return "You found a bomb!\n";
        } else if (field[rowS][colS + 1].equals("e")) {
            isStopping = true;
            return "END! " + bombCount + " bombs left on the field";
        } else {
            field[rowS][colS + 1] = "s";
            colS++;
        }

        return "";
    }

    private static String moveItLeft() {
        if (colS == 0) {
            return "";
        }
        field[rowS][colS] = "+";
        if (field[rowS][colS - 1].equals("B")) {
            field[rowS][colS - 1] = "s";
            colS--;
            bombCount--;
            return "You found a bomb!\n";
        } else if (field[rowS][colS - 1].equals("e")) {
            isStopping = true;
            return "END! " + bombCount + " bombs left on the field";
        } else {
            field[rowS][colS - 1] = "s";
            colS--;
        }

        return "";
    }


}
