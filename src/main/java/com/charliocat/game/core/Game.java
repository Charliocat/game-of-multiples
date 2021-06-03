package com.charliocat.game.core;

public class Game {

    private final int[] gameValues;

    private int currentScore;

    public Game(int[] gameValues) {
        this.gameValues = gameValues;
    }

    public int getCurrentScore() {
        return currentScore;
    }

    public void play(int i) {
        currentScore = calculateNumberOfMultiples(i);
    }

    public boolean isWon() {
        return currentScore == gameValues.length;
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
