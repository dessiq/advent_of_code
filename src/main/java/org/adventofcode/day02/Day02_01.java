package org.adventofcode.day02;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Day02_01 {

    static final HashMap<String, Integer> battleMap = new HashMap<>() {{
        put("A X", 3);
        put("A Y", 6);
        put("A Z", 0);
        put("B X", 0);
        put("B Y", 3);
        put("B Z", 6);
        put("C X", 6);
        put("C Y", 0);
        put("C Z", 3);
    }};

    static final HashMap<String, Integer> scoreMap = new HashMap<>() {{
        put("A", 1); // Rock
        put("B", 2); // Paper
        put("C", 3); // Scissors
        put("X", 1); // Rock
        put("Y", 2); // Paper
        put("Z", 3); // Scissors
    }};

    static final String fileName = "src/main/resources/adventofcode/input_day02";

    public static void main(String[] args) throws IOException {
        int totalScore = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String value = reader.readLine();
            while (value != null) {
                final Integer battleScore = battleMap.get(value);
                final String[] round = value.split(" ");
                final Integer player1score = scoreMap.get(round[0]);
                final Integer player2score = scoreMap.get(round[1]);
                if (player1score > player2score) {
                    totalScore = totalScore + battleScore + player2score;
                } else if (player1score < player2score) {
                    totalScore = totalScore + battleScore + player2score;
                } else {
                    totalScore = totalScore + battleScore + player2score;
                }
                value = reader.readLine();
            }
        }
        System.out.println("Total score: " + totalScore);
    }
}
