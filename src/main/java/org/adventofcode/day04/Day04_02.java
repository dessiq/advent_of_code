package org.adventofcode.day04;

import com.google.common.collect.Sets;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Day04_02 {

    static final String fileName = "src/main/resources/adventofcode/input_day04";

    public static void main(String[] args) throws IOException {
        int count = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            while (true) {
                final String firstLine = reader.readLine();
                if (firstLine == null) break;
                final String[] parts = firstLine.split(",");

                final Set<Integer> firstNumbers = getNumbers(parts[0]);
                final Set<Integer> secondNumbers = getNumbers(parts[1]);

                if (!Sets.intersection(firstNumbers, secondNumbers).isEmpty()) {
                    count++;
                }
            }
        }
        System.out.println("Total count: " + count);
    }

    private static Set<Integer> getNumbers(final String str) {
        final Set<Integer> numbers = new HashSet();
        final String[] nums = str.split("-");
        final int first = Integer.parseInt(nums[0]);
        final int second = Integer.parseInt(nums[1]);
        for (int i = first; i <= second; i++) {
            numbers.add(i);
        }
        return numbers;
    }
}
