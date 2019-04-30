package p03_ConnectedAreasInAMatrix;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;


public class Main {
    static class Area {
        private int row;
        private int col;
        private int size;

        public int getRow() {
            return row;
        }

        public int getCol() {
            return col;
        }

        public int getSize() {
            return size;
        }

        public Area(int r, int c, int s) {
            this.row = r;
            this.col = c;
            this.size = s;
        }

        public String toString(int number) {
            return String.format("Area #%d at (%d, %d), size: %d", number, this.row, this.col, this.size);
        }
    }

    public static int[] arr;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[rows][cols];

        ArrayList<Area> areas = new ArrayList<>();

        for (int r = 0; r < rows; r++) {
            matrix[r] = scanner.nextLine().replaceAll("[\t ]+", "").toCharArray();
        }

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (matrix[r][c] == '-') {
                    int[] size = new int[1];
                    countSize(matrix, r, c, size);
                    Area area = new Area(r, c, size[0]);
                    areas.add(area);
                }
            }
        }

        System.out.println("Total areas found: " + areas.size());
        AtomicInteger number = new AtomicInteger(1);
        areas.stream().sorted((f, s) -> {
            int result = s.getSize() - f.getSize();
            if (result == 0) {
                result = f.getRow() - s.getRow();
            }

            if (result == 0) {
                result = f.getCol() - s.getCol();
            }

            return result;
        }).forEach(a -> {
            System.out.println(a.toString(number.getAndIncrement()));
        });
    }

    private static void countSize(char[][] matrix, int r, int c, int[] size) {

        if (!isInBounds(matrix, r, c) || matrix[r][c] == 'V' || matrix[r][c] == '*') {
            return;
        }

        size[0]++;
        matrix[r][c] = 'V';

        countSize(matrix, r + 1, c, size);
        countSize(matrix, r, c + 1, size);
        countSize(matrix, r - 1, c, size);
        countSize(matrix, r, c - 1, size);
    }

    private static boolean isInBounds(char[][] matrix, int r, int c) {
        return r >= 0 && r < matrix.length && c >= 0 && c < matrix[r].length;
    }
}

