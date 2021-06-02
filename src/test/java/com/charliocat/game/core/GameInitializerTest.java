package com.charliocat.game.core;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GameInitializerTest {

    @Test
    void generateThreeRandomValuesBetweenOneAndMaxValue() {
        int maxValue = 10;
        int[] values = GameInitializer.initValues(3, maxValue);

        assertEquals(values.length, 3);
        assertTrue(values[values.length - 1] <= maxValue);
    }

}
