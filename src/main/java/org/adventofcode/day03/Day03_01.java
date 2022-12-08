package org.adventofcode.day03;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Set;
import java.util.stream.Collectors;

public class Day03_01 {

    static final String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    static final String fileName = "src/main/resources/adventofcode/input_day03";

    public static void main(String[] args) throws IOException {
        int totalSum = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String value = reader.readLine();
            while (value != null) {
                final String first = value.substring(0, value.length() / 2);
                final String second = value.substring(value.length() / 2);
                final Set<Character> firstSet = first.chars().mapToObj(e -> (char) e).collect(Collectors.toSet());
                final Set<Character> secondSet = second.chars().mapToObj(e -> (char) e).collect(Collectors.toSet());
                final ImmutableSet<Character> intersection = Sets.intersection(firstSet, secondSet).immutableCopy();
                final int index = alphabet.indexOf(intersection.iterator().next()) + 1;
                totalSum = totalSum + index;
                value = reader.readLine();
            }
        }
        System.out.println("Total score: " + totalSum);
    }
}
