package org.adventofcode.day08;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.HashSet;

public class Day08_02 {

    static final String fileName = "src/main/resources/adventofcode/input_day08";

    private static final int[][] matrix = new int[99][99];
    private static final HashSet<Integer> treesCount = new HashSet();

    public static void main(String[] args) throws IOException {
        fillMatrix();
        countTrees();
        final int max = treesCount.stream().max(Comparator.naturalOrder()).get();
        System.out.println(max);
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
        for (int i = 1; i < matrix.length - 1; i++) {
            for (int j = 1; j < matrix.length - 1; j++) {
                final int value = matrix[i][j];
                treesCount.add(countUp(value, i, j) * countLeft(value, i, j) * countRight(value, i, j) * countDown(value, i, j));
            }
        }
    }

    private static int countUp(final int value, final int i, final int j) {
        int tmp = 0;
        for (int k = i - 1; k > -1; k--) {
            if (value > matrix[k][j]) {
                tmp++;
            } else {
                tmp++;
                break;
            }
        }
        return tmp;
    }

    private static int countLeft(final int value, final int i, final int j) {
        int tmp = 0;
        for (int k = j - 1; k > -1; k--) {
            if (value > matrix[i][k]) {
                tmp++;
            } else {
                tmp++;
                break;
            }
        }
        return tmp;
    }

    private static int countRight(final int value, final int i, final int j) {
        int tmp = 0;
        for (int k = j + 1; k < matrix.length; k++) {
            if (value > matrix[i][k]) {
                tmp++;
            } else {
                tmp++;
                break;
            }
        }
        return tmp;
    }

    private static int countDown(final int value, final int i, final int j) {
        int tmp = 0;
        for (int k = i + 1; k < matrix.length; k++) {
            if (value > matrix[k][j]) {
                tmp++;
            } else {
                tmp++;
                break;
            }
        }
        return tmp;
    }
}
