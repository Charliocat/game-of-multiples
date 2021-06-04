package com.charliocat.game.core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

class MultiplesGameEngineTest {

    private static final Pattern NUMERIC_PATTERN = Pattern.compile("-?\\d+?");
    private static final String INPUT_ERROR_MESSAGE = "Input error. Try again.";
    private static final String NON_POSITIVE_INTEGER_ERROR_MESSAGE = "It must be positive!";
    private static final int WIN_SCORE = 3;
    private static final int HIGHEST_VALUE = 10;
    private static final String WIN = "win";

    private GameEngine gameEngine;

    @BeforeEach
    void setUp() {
        gameEngine = new MultiplesGameEngine(new int[]{2, 7, 10});
    }

    @Test
    void playWithNonNumericInput() {
        Exception e = assertThrows(RuntimeException.class, () -> {
            gameEngine.play("abc");
        });

        assertEquals(e.getMessage(), INPUT_ERROR_MESSAGE);
        assertTrue(gameEngine.isRunning());
    }

    @Test
    void playWithNegativeInteger() {
        Exception e = assertThrows(RuntimeException.class, () -> {
            gameEngine.play("-1");
        });

        assertEquals(e.getMessage(), NON_POSITIVE_INTEGER_ERROR_MESSAGE);
        assertTrue(gameEngine.isRunning());
    }

    @Test
    void playAndWin() {
        String result = gameEngine.play("70");

        assertEquals(result, WIN);
        assertFalse(gameEngine.isRunning());
    }

    @Test
    void playAndDoNotWin() {
        String result = gameEngine.play("2");

        assertEquals(result, "1");
        assertTrue(gameEngine.isRunning());
    }

}
