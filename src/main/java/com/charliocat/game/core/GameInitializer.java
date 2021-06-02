package com.charliocat.game.core;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class GameInitializer {

    public static int[] initValues(int maxGameValues, int highestValue) {
        Random random = new Random();
        Set<Integer> set = new HashSet<>();
        while (set.size() < maxGameValues) {
            set.add(random.nextInt(highestValue) + 1);
        }
        return set.stream().mapToInt(Number::intValue).toArray();
    }

}
