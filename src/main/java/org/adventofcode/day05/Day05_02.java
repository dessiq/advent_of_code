package org.adventofcode.day05;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Day05_02 {

    static final String fileName = "src/main/resources/adventofcode/input_day05";
    static final LinkedList<String> first = new LinkedList<>(Arrays.asList("F", "C", "P", "G", "Q", "R"));
    static final LinkedList<String> second = new LinkedList<>(Arrays.asList("W", "T", "C", "P"));
    static final LinkedList<String> third = new LinkedList<>(Arrays.asList("B", "H", "P", "M", "C"));
    static final LinkedList<String> forth = new LinkedList<>(Arrays.asList("L", "T", "Q", "S", "M", "P", "R"));
    static final LinkedList<String> fifth = new LinkedList<>(Arrays.asList("P", "H", "J", "Z", "V", "G", "N"));
    static final LinkedList<String> sixth = new LinkedList<>(Arrays.asList("D", "P", "J"));
    static final LinkedList<String> seventh = new LinkedList<>(Arrays.asList("L", "G", "P", "Z", "F", "J", "T", "R"));
    static final LinkedList<String> eighth = new LinkedList<>(Arrays.asList("N", "L", "H", "C", "F", "P", "T", "J"));
    static final LinkedList<String> ninth = new LinkedList<>(Arrays.asList("G", "V", "Z", "Q", "H", "T", "C", "W"));

    static final Map<Integer, LinkedList<String>> map = new HashMap<>() {{
        put(1, first);
        put(2, second);
        put(3, third);
        put(4, forth);
        put(5, fifth);
        put(6, sixth);
        put(7, seventh);
        put(8, eighth);
        put(9, ninth);
    }};

    public static void main(String[] args) throws IOException {

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            while (true) {
                final String firstLine = reader.readLine();
                if (firstLine == null) break;
                final String[] array = firstLine.split(" ");
                final int count = Integer.parseInt(array[1]);
                final int source = Integer.parseInt(array[3]);
                final int target = Integer.parseInt(array[5]);

                final LinkedList<String> tmp = new LinkedList<>();
                for (int i = 0; i < count; i++) {
                    final String element = map.get(source).getLast();
                    map.get(source).removeLastOccurrence(element);
                    tmp.addFirst(element);
                }
                map.get(target).addAll(tmp);
            }
        }
        System.out.println(first.getLast()
                        + second.getLast()
                        + third.getLast()
                        + forth.getLast()
                        + fifth.getLast()
                        + sixth.getLast()
                        + seventh.getLast()
                        + eighth.getLast()
                        + ninth.getLast()
        );
    }
}
