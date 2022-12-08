package org.adventofcode.day02;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Day02_02 {

    static final HashMap<String, Integer> battleMap = new HashMap() {{
        put("A X", 0);
        put("A Y", 3);
        put("A Z", 6);
        put("B X", 0);
        put("B Y", 3);
        put("B Z", 6);
        put("C X", 0);
        put("C Y", 3);
        put("C Z", 6);
    }};

    static final HashMap<String, Integer> drawScoreMap = new HashMap() {{
        put("A", 1); // Rock - Rock
        put("B", 2); // Paper - Paper
        put("C", 3); // Scissors - Scissors
    }};

    static final HashMap<String, Integer> winScoreMap = new HashMap() {{
        put("A", 2); // Rock - Paper
        put("B", 3); // Paper - Scissors
        put("C", 1); // Scissors  - Rock
    }};

    static final HashMap<String, Integer> loseScoreMap = new HashMap() {{
        put("A", 3); // Rock - Scissors
        put("B", 1); // Paper - Rock
        put("C", 2); // Scissors - Paper
    }};

    static final String fileName = "src/main/resources/adventofcode/input_day02";


    public static void main(String[] args) throws IOException {
        int totalScore = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String value = reader.readLine();
            while (value != null) {
                final int battleScore = battleMap.get(value);
                final String[] round = value.split(" ");
                if (battleScore == 3) {
                    totalScore = totalScore + battleScore + drawScoreMap.get(round[0]);
                } else if (battleScore == 6) {
                    totalScore = totalScore + battleScore + winScoreMap.get(round[0]);
                } else {
                    totalScore = totalScore + battleScore + loseScoreMap.get(round[0]);
                }
                value = reader.readLine();
            }
        }
        System.out.println("Total score: " + totalScore);
    }
}
