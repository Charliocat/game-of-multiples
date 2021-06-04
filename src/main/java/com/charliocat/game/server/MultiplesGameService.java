package com.charliocat.game.server;

import com.charliocat.game.core.GameEngine;
import com.charliocat.game.core.MultiplesGameEngine;
import com.charliocat.game.io.DefaultConsole;
import com.charliocat.game.io.IOConsole;

import java.util.Arrays;

public class MultiplesGameService implements GameService {

    private IOConsole console;
    private GameEngine gameEngine;

    public MultiplesGameService() {
        this.console = new DefaultConsole();
        this.gameEngine = new MultiplesGameEngine();
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public void run() {
        console.write("Welcome to the game of multiples!");
        console.write("Type <hint> to see the game values");
        console.write("Type <exit> to stop playing");
        console.write("Enter a positive integer to play");

        while (gameEngine.isRunning()) {
            String input = console.readNext();
            if (input.equals("exit")) {
                console.write("Thanks for playing!");
                break;
            }

            if (input.equals("hint")) {
                console.write(Arrays.toString(gameEngine.getGameValues()));
                continue;
            }

            try {
                console.write(gameEngine.play(input));
            } catch (Exception e) {
                console.write(e.getMessage());
            }
        }
    }

    public static class Builder {

        private IOConsole console;
        private GameEngine gameEngine;

        public Builder withConsole(IOConsole console) {
            this.console = console;
            return this;
        }

        public Builder withGameEngine(GameEngine gameEngine) {
            this.gameEngine = gameEngine;
            return this;
        }

        public MultiplesGameService build() {
            MultiplesGameService multiplesGameService = new MultiplesGameService();

            if (this.console != null)
                multiplesGameService.console = this.console;

            if (this.gameEngine != null)
                multiplesGameService.gameEngine = this.gameEngine;

            return multiplesGameService;
        }
    }

}
