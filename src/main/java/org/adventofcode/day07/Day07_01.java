package org.adventofcode.day07;

import com.google.common.collect.HashMultimap;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Day07_01 {

    static final String fileName = "src/main/resources/adventofcode/input_day07";

    static final HashMultimap<String, Long> map = HashMultimap.create();

    public static void main(String[] args) throws IOException {

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            final String line = reader.readLine();
            countSizeOfDir(line, reader);
            map.entries()
                    .forEach(System.out::println);
            System.out.println("~~~~~~~~~~~~~~~~~~~");
            map.entries().stream()
                    .filter(entry -> entry.getValue() < 100_000)
                    .forEach(System.out::println);
            System.out.println("~~~~~~~~~~~~~~~~~~~");
            System.out.println("Sum= " + map.values().stream()
                    .filter(value -> value < 100_000)
                    .reduce(0L, Long::sum));
        }
    }

    private static long countSizeOfDir(final String line, final BufferedReader reader) throws IOException {
        long sum = 0;
        final String dirName = line.split(" ")[2];
        while (true) {
            final String str = reader.readLine();
            if (str == null) {
                map.put(dirName, sum);
                return sum;
            }

            if (str.equals("$ ls")) {
                continue;
            }
            if (str.contains("dir")) {
                continue;
            }

            if (str.matches("(\\d)* [a-zA-Z]*.[a-zA-Z]*")) {
                sum = sum + Integer.parseInt(str.split(" ")[0]);
                continue;
            }

            if (str.matches("\\$ cd [a-z]*")) {
                sum = sum + countSizeOfDir(str, reader);
            }

            if (str.equals("$ cd ..")) {
                map.put(dirName, sum);
                return sum;
            }
        }
    }
}