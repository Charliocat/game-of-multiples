package com.charliocat.game.core;

public class Game {

    private final int[] gameValues;

    private int score;

    public Game(int[] gameValues) {
        this.gameValues = gameValues;
    }

    public int getScore() {
        return score;
    }

    public void play(int i) {
        score = calculateNumberOfMultiples(i);
    }

    private int calculateNumberOfMultiples(int i) {
        int result = 0;
        for (int value : gameValues) {
            if (i % value == 0)
                result += 1;
        }
        return result;
    }

}
