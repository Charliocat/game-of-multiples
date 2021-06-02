package com.charliocat.game.core;

public class Game {

    private static final String WIN = "win";

    private final int[] gameValues;

    public Game(int[] gameValues) {
        this.gameValues = gameValues;
    }

    public String play(int i) {
        int score = findNumberOfMultiples(i);
        if (score == gameValues.length)
            return WIN;

        return String.valueOf(score);
    }

    public int play2(int i) {
        return findNumberOfMultiples(i);
    }

    private int findNumberOfMultiples(int i) {
        int result = 0;
        for (int value : gameValues) {
            if (i % value == 0)
                result += 1;
        }
        return result;
    }

}
