package org.adventofcode.day09;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Day09_02 {

    static final String fileName = "src/main/resources/adventofcode/input_day09";

    public static final int gridSize = 1000;
    public static int[] grid = new int[gridSize * gridSize];
    public static int[] ropX = new int[10];
    public static int[] ropY = new int[10];

    public static void main(String[] args) throws IOException {
        Arrays.fill(ropX, 500);
        Arrays.fill(ropY, 500);
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] move = line.split(" ");
                String direction = move[0];
                int steps = Integer.parseInt(move[1]);
                for (int j = 0; j < steps; j++) {
                    switch (direction) {
                        case "U" -> ropY[0]--;
                        case "L" -> ropX[0]--;
                        case "R" -> ropX[0]++;
                        case "D" -> ropY[0]++;
                    }

                    for (int i = 0; i < ropX.length - 1; i++) {
                        boolean moveX = Math.abs(ropX[i] - ropX[i + 1]) > 1;
                        boolean moveY = Math.abs(ropY[i] - ropY[i + 1]) > 1;
                        boolean moveXY = Math.abs(ropX[i] - ropX[i + 1]) + Math.abs(ropY[i] - ropY[i + 1]) > 2;

                        if (moveXY) {
                            if (ropX[i] > ropX[i + 1]) {
                                ropX[i + 1]++;
                            } else {
                                ropX[i + 1]--;
                            }
                            if (ropY[i] > ropY[i + 1]) {
                                ropY[i + 1]++;
                            } else {
                                ropY[i + 1]--;
                            }
                        } else if (moveX) {
                            if (ropX[i] > ropX[i + 1]) {
                                ropX[i + 1]++;
                            } else {
                                ropX[i + 1]--;
                            }
                        } else if (moveY) {
                            if (ropY[i] > ropY[i + 1]) {
                                ropY[i + 1]++;
                            } else {
                                ropY[i + 1]--;
                            }
                        }
                        grid[ropY[9] * gridSize + ropX[9]] += 1;
                    }
                }
            }
        }

        int amount = 0;
        for (int i : grid) {
            if (i > 0) {
                amount++;
            }
        }
        System.out.println(amount);
    }
}
