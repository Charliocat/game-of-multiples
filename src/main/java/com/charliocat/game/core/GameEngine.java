package com.charliocat.game.core;

public interface GameEngine {

    boolean isRunning();

    int[] getGameValues();

    String play(String input);

}
