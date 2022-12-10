package org.adventofcode.day09;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

public class Day09_01 {

    static final String fileName = "src/main/resources/adventofcode/input_day09";

    private static final HashSet<String> positions = new HashSet<>();

    public static void main(String[] args) throws IOException {
        new Day09_01().start();
        System.out.println("Positions visited: " + positions.size());
        System.out.println(positions);
    }

    private void start() throws IOException {
        Head head = new Head(0, 0);
        Tail tail = new Tail(0, 0);
        positions.add("" + "04");
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            while (true) {
                final String line = reader.readLine();
                if (line == null) break;
                String[] move = line.split(" ");
                String direction = move[0];
                int steps = Integer.parseInt(move[1]);
                switch (direction) {
                    case "U" -> stepUp(head, tail, steps);
                    case "L" -> stepLeft(head, tail, steps);
                    case "R" -> stepRight(head, tail, steps);
                    case "D" -> stepDown(head, tail, steps);
                }
            }
        }
    }

    private void stepUp(final Head head, final Tail tail, final int steps) {
        for (int i = 0; i < steps; i++) {
            int tempX = head.getX();
            int tempY = head.getY();

            head.setY(head.getY() - 1);

            if (move(head, tail)) {
                tail.setX(tempX);
                tail.setY(tempY);
                positions.add("" + tempX + tempY);
            }
        }
    }

    private void stepLeft(final Head head, final Tail tail, final int steps) {
        for (int i = 0; i < steps; i++) {
            int tempX = head.getX();
            int tempY = head.getY();

            head.setX(head.getX() - 1);

            if (move(head, tail)) {
                tail.setX(tempX);
                tail.setY(tempY);
                positions.add("" + tempX + tempY);
            }
        }
    }

    private void stepRight(final Head head, final Tail tail, final int steps) {
        for (int i = 0; i < steps; i++) {
            int tempX = head.getX();
            int tempY = head.getY();

            head.setX(head.getX() + 1);

            if (move(head, tail)) {
                tail.setX(tempX);
                tail.setY(tempY);
                positions.add("" + tempX + tempY);
            }
        }
    }

    private void stepDown(final Head head, final Tail tail, final int steps) {
        for (int i = 0; i < steps; i++) {
            int tempX = head.getX();
            int tempY = head.getY();

            head.setY(head.getY() + 1);

            if (move(head, tail)) {
                tail.setX(tempX);
                tail.setY(tempY);
                positions.add("" + tempX + tempY);
            }
        }
    }

    private boolean move(final Head head, final Tail tail) {
        final int headX = head.getX();
        final int headY = head.getY();

        final int tailX = tail.getX();
        final int tailY = tail.getY();

        return Math.abs(headY - tailY) > 1 || Math.abs(headX - tailX) > 1;
    }

    abstract class Player {
        private int x;
        private int y;

        public Player(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public void setX(int x) {
            this.x = x;
        }

        public void setY(int y) {
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }


        @Override
        public String toString() {
            return "{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    class Head extends Player {
        public Head(int x, int y) {
            super(x, y);
        }
    }

    class Tail extends Player {
        public Tail(int x, int y) {
            super(x, y);
        }
    }
}
