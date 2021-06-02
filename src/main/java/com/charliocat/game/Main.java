package com.charliocat.game;

import com.charliocat.game.core.Game;
import com.charliocat.game.core.GameInitializer;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        final int WIN_SCORE = 3;
        final int HIGHEST_VALUE = 10;
        final String WIN = "win";

        int[] gameValues = GameInitializer.initValues(WIN_SCORE, HIGHEST_VALUE);
        Game game = new Game(gameValues);

        System.out.println("Welcome to the game of multiples!");
        System.out.println("Type <hint> to see the game values");
        System.out.println("Type <exit> to stop playing");
        System.out.println("Enter a positive integer to play");

        Scanner scanner = new Scanner(System.in);
        while (game.isRunning()) {
            if (!scanner.hasNextInt()) {
                String input = scanner.next();
                if (input.equals("exit")) {
                    System.out.println("Thanks for playing!");
                    break;
                }

                if (input.equals("hint")) {
                    System.out.println(Arrays.toString(gameValues));
                    continue;
                }

                System.out.println("Input error. Try again.");
                continue;
            }

            int number = scanner.nextInt();
            if (number < 1) {
                System.out.println("It must be positive!");
                continue;
            }

            game.play(number);
            if (game.isWon()) {
                System.out.println(WIN);
                break;
            }

            System.out.println(game.getCurrentScore());
        }

    }

}
