package com.charliocat.game.core;

import java.util.regex.Pattern;

public class MultiplesGameEngine implements GameEngine {

    private static final Pattern NUMERIC_PATTERN = Pattern.compile("-?\\d+?");
    private static final String INPUT_ERROR_MESSAGE = "Input error. Try again.";
    private static final String NON_POSITIVE_INTEGER_ERROR_MESSAGE = "It must be positive!";
    private static final int WIN_SCORE = 3;
    private static final int HIGHEST_VALUE = 10;
    private static final String WIN = "win";

    private Game game;
    int[] gameValues;
    private boolean isFinished = false;

    public MultiplesGameEngine() {
        this.gameValues = GameInitializer.initValues(WIN_SCORE, HIGHEST_VALUE);
        this.game = new Game(gameValues);
    }

    public MultiplesGameEngine(int[] gameValues) {
        this.gameValues = gameValues;
        this.game = new Game(gameValues);
    }

    @Override
    public boolean isRunning() {
        return !isFinished;
    }

    @Override
    public int[] getGameValues() {
        return gameValues;
    }

    @Override
    public String play(String input) {
        if (!isNumeric(input))
            throw new RuntimeException(INPUT_ERROR_MESSAGE);

        int number = convertToInteger(input);
        if (number < 1)
            throw new RuntimeException(NON_POSITIVE_INTEGER_ERROR_MESSAGE);

        game.play(number);
        if (game.getScore() == WIN_SCORE) {
            isFinished = true;
            return WIN;
        }
        return String.valueOf(game.getScore());
    }

    private int convertToInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (Exception e) {
            throw new RuntimeException(INPUT_ERROR_MESSAGE);
        }
    }

    private boolean isNumeric(String input) {
        return NUMERIC_PATTERN.matcher(input).matches();
    }

}
