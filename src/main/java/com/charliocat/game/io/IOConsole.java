package com.charliocat.game.io;

import java.util.regex.Pattern;

public interface IOConsole {

    void write(String text);

    void write(int number);

    boolean hasNext(Pattern pattern);

    String readNext();

    boolean hasNextInt();

    int readNextInt();
}
