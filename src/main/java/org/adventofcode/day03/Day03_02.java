package org.adventofcode.day03;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Set;
import java.util.stream.Collectors;

public class Day03_02 {

    static final String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    static final String fileName = "src/main/resources/adventofcode/input_day03";

    public static void main(String[] args) throws IOException {
        int totalSum = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            while (true) {
                final String firstLine = reader.readLine();
                if (firstLine == null) break;
                final Set<Character> firstSet = firstLine.chars().mapToObj(e -> (char) e).collect(Collectors.toSet());

                final String secondLine = reader.readLine();
                final Set<Character> secondSet = secondLine.chars().mapToObj(e -> (char) e).collect(Collectors.toSet());

                final String thirdLine = reader.readLine();
                final Set<Character> thirdSet = thirdLine.chars().mapToObj(e -> (char) e).collect(Collectors.toSet());

                final ImmutableSet<Character> firstIntersection = Sets.intersection(firstSet, secondSet).immutableCopy();
                final ImmutableSet<Character> secondIntersection = Sets.intersection(firstIntersection, thirdSet).immutableCopy();

                final int index = alphabet.indexOf(secondIntersection.iterator().next()) + 1;

                totalSum = totalSum + index;
            }
        }
        System.out.println("Total score: " + totalSum);
    }
}
