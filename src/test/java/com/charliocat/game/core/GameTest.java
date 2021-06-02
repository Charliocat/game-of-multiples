package com.charliocat.game.core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    private final int[] gameValues = new int[]{2, 7, 10};
    private Game game;

    @BeforeEach
    void setUp() {
        game = new Game(gameValues);
    }

    @Test
    void playAndWinAGame() {
        game.play(70);

        assertTrue(game.isWon());
    }

    @Test
    void playAGameNotWinning() {
        game.play(4);

        assertFalse(game.isWon());
        assertEquals(game.getCurrentScore(), 1);
    }

    @Test
    void playAGameWithNegativeInteger() {
        game.play(-2);

        assertFalse(game.isWon());
        assertEquals(game.getCurrentScore(), 1);
    }

}
