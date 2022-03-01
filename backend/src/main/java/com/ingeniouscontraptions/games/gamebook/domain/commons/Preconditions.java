package com.ingeniouscontraptions.games.gamebook.domain.commons;

public class Preconditions {

    private Preconditions() {
    }

    public static int positive(int i, String name) {
        if (i < 0) {
            throw new IllegalArgumentException(String.format("%s must be positive.", name));
        }
        return i;
    }

    public static <T> T notNull(T o, String name) {
        if (o == null) {
            throw new NullPointerException(String.format("%s is required.", name));
        }
        return o;
    }

}
