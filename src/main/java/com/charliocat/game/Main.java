package com.charliocat.game;

import com.charliocat.game.server.GameService;
import com.charliocat.game.server.MultiplesGameService;

public class Main {

    public static void main(String[] args) {
        GameService gameService = MultiplesGameService.builder().build();
        gameService.run();
    }

}
