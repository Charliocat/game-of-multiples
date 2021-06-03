package com.charliocat.game.io;

import java.util.regex.Pattern;

public interface IOConsole {

    void println(String text);

    void println(int number);

    boolean hasNext(Pattern pattern);

    String next();

    boolean hasNextInt();

    int nextInt();
}
