package com.charliocat.game.server;

import com.charliocat.game.core.Game;
import com.charliocat.game.core.GameInitializer;
import com.charliocat.game.io.DefaultConsole;
import com.charliocat.game.io.IOConsole;

import java.util.Arrays;
import java.util.regex.Pattern;

public class MultiplesGameService implements GameService {

    private static final int WIN_SCORE = 3;
    private static final int HIGHEST_VALUE = 10;
    private static final String WIN = "win";

    private IOConsole console;
    private Game game;
    int[] gameValues;

    public MultiplesGameService() {
        this.console = new DefaultConsole();
        this.gameValues = GameInitializer.initValues(WIN_SCORE, HIGHEST_VALUE);
        this.game = new Game(gameValues);
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public void run() {
        console.println("Welcome to the game of multiples!");
        console.println("Type <hint> to see the game values");
        console.println("Type <exit> to stop playing");
        console.println("Enter a positive integer to play");

        while (isRunning()) {
            if (console.hasNext(Pattern.compile("exit"))) {
                console.println("Thanks for playing!");
                break;
            }

            if (console.hasNext(Pattern.compile("hint"))) {
                console.println(Arrays.toString(gameValues));
                console.next();
                continue;
            }

            if (!console.hasNextInt()) {
                console.println("Input error. Try again.");
                console.next();
                continue;
            }

            int number = console.nextInt();
            if (number < 1) {
                console.println("It must be positive!");
                continue;
            }

            game.play(number);
            if (game.isWon()) {
                console.println(WIN);
                break;
            }

            console.println(game.getCurrentScore());
        }
    }

    private boolean isRunning() {
        return game.getCurrentScore() < WIN_SCORE;
    }

    public static class Builder {

        private IOConsole console;
        private int[] gameValues;

        public Builder setConsole(IOConsole console) {
            this.console = console;
            return this;
        }

        public Builder setGameValues(int[] gameValues) {
            this.gameValues = gameValues;
            return this;
        }

        public MultiplesGameService build() {
            MultiplesGameService multiplesGameService = new MultiplesGameService();

            if (this.console != null)
                multiplesGameService.console = this.console;

            if (this.gameValues != null)
                multiplesGameService.gameValues = this.gameValues;

            return multiplesGameService;
        }
    }

}
