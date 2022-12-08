package org.adventofcode.day06;

import com.google.common.collect.ImmutableList;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Day06_02 {

    static final String fileName = "src/main/resources/adventofcode/input_day06";

    public static void main(String[] args) throws IOException {

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            final String line = reader.readLine();
            final ImmutableList<Character> chars = line.chars().mapToObj(e -> (char) e).collect(ImmutableList.toImmutableList());
            final LinkedList<Character> list = new LinkedList();
            for (int i = 0; i < 13; i++) {
                final Character next = chars.get(i);
                list.add(next);
            }
            for (int i = 13; i < chars.size(); i++) {
                final Character next = chars.get(i);
                list.addLast(next);
                if (isDifferent(list)) {
                    System.out.println(i + 1);
                    break;
                }
                list.removeFirst();
            }
        }
    }

    private static boolean isDifferent(final List<Character> list) {
        return list.size() == Set.copyOf(list).size();
    }
}