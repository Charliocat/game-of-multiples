package com.charliocat.game;

import com.charliocat.game.core.Game;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        final int MAX_GAME_VALUES = 3;
        final int HIGHEST_VALUE = 10;
        final String WIN = "win";

        //int[] gameValues = GameInitializer.initValues(MAX_GAME_VALUES, HIGHEST_VALUE);
        int[] gameValues = new int[]{2, 7, 10};
        Game game = new Game(gameValues);

        System.out.println("Welcome to the game of multiples!");
        System.out.println("Enter a positive integer to play");

        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                int number = scanner.nextInt();

                if (number < 1)
                    throw new RuntimeException();

                int score = game.play2(number);
                if (score == MAX_GAME_VALUES) {
                    System.out.println(WIN);
                    break;
                }
                System.out.println(score);
            } catch (Exception e) {
                System.out.println("Not a positive integer");
            }
        }
    }

}
