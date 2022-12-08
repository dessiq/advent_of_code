package org.adventofcode.day08;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Day08_01 {

    static final String fileName = "src/main/resources/adventofcode/input_day08";

    private static final int[][] matrix = new int[99][99];
    private static int treesCount;

    public static void main(String[] args) throws IOException {
        fillMatrix();
        countTrees();
        System.out.println(treesCount);
    }

    private static void fillMatrix() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            for (int i = 0; i < matrix.length; i++) {
                final String line = reader.readLine();
                final char[] array = line.toCharArray();
                for (int j = 0; j < matrix.length; j++) {
                    matrix[i][j] = Integer.parseInt("" + array[j]);
                }
            }
        }
    }

    private static void countTrees() {
        treesCount = treesCount + (matrix.length * 4 - 4);

        for (int i = 1; i < matrix.length - 1; i++) {
            for (int j = 1; j < matrix.length - 1; j++) {
                final int value = matrix[i][j];
                if (checkUp(value, i, j) || checkLeft(value, i, j) || checkRight(value, i, j) || checkDown(value, i, j)) {
                    treesCount++;
                }
            }
        }
    }

    private static boolean checkUp(final int value, final int i, final int j) {
        for (int k = i - 1; k > -1; k--) {
            if (value <= matrix[k][j]) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkLeft(final int value, final int i, final int j) {
        for (int k = j - 1; k > -1; k--) {
            if (value <= matrix[i][k]) {
                return false;
            }
        }
        return true;

    }

    private static boolean checkRight(final int value, final int i, final int j) {
        for (int k = j + 1; k < matrix.length; k++) {
            if (value <= matrix[i][k]) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkDown(final int value, final int i, final int j) {
        for (int k = i + 1; k < matrix.length; k++) {
            if (value <= matrix[k][j]) {
                return false;
            }
        }
        return true;
    }
}
