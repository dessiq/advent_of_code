package org.adventofcode.day01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Day01 {

    static final String fileName = "src/main/resources/adventofcode/input_day01";

    public static void main(String[] args) throws IOException {
        final Map<Integer, Integer> map = new HashMap();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String value = reader.readLine();
            for (int i = 1; ; i++) {
                int sum = 0;
                while (value != null && !value.isEmpty()) {
                    final int val = Integer.parseInt(value);
                    sum += val;
                    value = reader.readLine();
                }
                if (value == null) {
                    break;
                }
                map.put(i, sum);
                value = reader.readLine();
            }
        }

        final Integer max = map.values().stream()
                .max(Comparator.naturalOrder())
                .get();
        System.out.println("Max: " + max);

        final Integer sumOfThree = map.values().stream()
                .sorted(Comparator.reverseOrder())
                .limit(3)
                .reduce(0, Integer::sum);
        System.out.println("Sum of three max: " + sumOfThree);
    }
}
