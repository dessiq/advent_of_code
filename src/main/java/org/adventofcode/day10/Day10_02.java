package org.adventofcode.day10;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Day10_02 {

    static final String fileName = "src/main/resources/adventofcode/input_day10";

    private static int register = 1;
    private static int cycleCount = 0;
    private static int raw = 0;
    private static final String[][] matrix = new String[6][40];

    public static void main(String[] args) throws IOException {
        process();
        Arrays.stream(matrix).map(Arrays::toString).forEach(System.out::println);
    }

    private static void process() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                final String[] input = line.split(" ");
                final String command = input[0];
                switch (command) {
                    case "addx" -> addx(Integer.parseInt(input[1]));
                    case "noop" -> noop();
                }
            }
        }
    }

    private static void addx(int amount) {
        doStep();
        doStep();
        register = register + amount;
    }

    private static void noop() {
        doStep();
    }

    private static void doStep() {
        if (Math.abs((cycleCount - raw * 40) - register) < 2) {
            matrix[raw][cycleCount % 40] = "#";
        } else {
            matrix[raw][cycleCount % 40] = ".";
        }
        cycleCount++;
        if (cycleCount % 40 == 0) {
            raw++;
        }
    }
}
