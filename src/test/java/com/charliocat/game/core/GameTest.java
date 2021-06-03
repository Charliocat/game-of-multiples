package com.charliocat.game.core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

        assertEquals(game.getScore(), 3);
    }

    @Test
    void playAGameNotWinning() {
        game.play(4);

        assertEquals(game.getScore(), 1);
    }

    @Test
    void playAGameWithNegativeInteger() {
        game.play(-2);

        assertEquals(game.getScore(), 1);
    }

}
