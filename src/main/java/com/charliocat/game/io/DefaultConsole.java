package com.charliocat.game.io;

import java.util.Scanner;
import java.util.regex.Pattern;

public class DefaultConsole implements IOConsole {

    private Scanner scanner;

    public DefaultConsole(Scanner scanner) {
        this.scanner = scanner;
    }

    public DefaultConsole() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void println(String text) {
        System.out.println(text);
    }

    @Override
    public void println(int number) {
        System.out.println(number);
    }

    @Override
    public boolean hasNext(Pattern pattern) {
        return scanner.hasNext(pattern);
    }

    @Override
    public String next() {
        return scanner.next();
    }

    @Override
    public boolean hasNextInt() {
        return scanner.hasNextInt();
    }

    @Override
    public int nextInt() {
        return scanner.nextInt();
    }

}
