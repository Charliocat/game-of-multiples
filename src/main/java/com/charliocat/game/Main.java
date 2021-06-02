package com.charliocat.game;

import com.charliocat.game.core.GameInitializer;
import com.charliocat.game.core.Game;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {

        final int MAX_GAME_VALUES = 3;
        final int HIGHEST_VALUE = 10;

        int[] gameValues = GameInitializer.initValues(MAX_GAME_VALUES, HIGHEST_VALUE);
        Game game = new Game(gameValues);
        System.out.println("Game values: " + Arrays.toString(gameValues));
        System.out.println(game.run(5));
        System.out.println(game.run(4));
        System.out.println(game.run(14));
        System.out.println(game.run(70));
        System.out.println(game.run(280));

    }

}
