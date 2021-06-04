package com.charliocat.game.io;

import java.util.Scanner;

public class DefaultConsole implements IOConsole {

    private static final String PROMPT = "Game: ";

    private Scanner scanner;

    public DefaultConsole(Scanner scanner) {
        this.scanner = scanner;
    }

    public DefaultConsole() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void write(String text) {
        System.out.print(PROMPT);
        System.out.println(text);
    }

    @Override
    public String readNext() {
        return scanner.next();
    }

}
