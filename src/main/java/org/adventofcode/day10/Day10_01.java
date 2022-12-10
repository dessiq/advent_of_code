package org.adventofcode.day10;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Day10_01 {

    static final String fileName = "src/main/resources/adventofcode/input_day10";

    private static int register = 1;
    private static int cycleCount = 0;
    private static final HashMap<Integer, Integer> cycles = new HashMap<>();

    public static void main(String[] args) throws IOException {
        process();
        System.out.println(cycles.get(20) * 20 + cycles.get(60) * 60 + cycles.get(100) * 100 + cycles.get(140) * 140 + cycles.get(180) * 180 + cycles.get(220) * 220);
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

    private static void noop() {
        doStep();
    }

    private static void addx(int amount) {
        doStep();
        doStep();
        register = register + amount;
    }

    private static void doStep() {
        cycleCount++;
        cycles.put(cycleCount, register);
    }
}
