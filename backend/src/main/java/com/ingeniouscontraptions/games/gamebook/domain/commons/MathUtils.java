package com.ingeniouscontraptions.games.gamebook.domain.commons;

public class MathUtils {

    private MathUtils() {
    }

    public static <T extends Comparable<T>> boolean greaterThan(T a, T b) {
        return a.compareTo(b) > 0;
    }

    public static <T extends Comparable<T>> boolean greaterThanOrEqualTo(T a, T b) {
        return a.compareTo(b) >= 0;
    }

    public static <T extends Comparable<T>> boolean lessThan(T a, T b) {
        return a.compareTo(b) < 0;
    }

    public static <T extends Comparable<T>> boolean lessThanOrEqualTo(T a, T b) {
        return a.compareTo(b) <= 0;
    }

    public static <T extends Comparable<T>> T min(T a, T b) {
        return lessThan(a, b) ? a : b;
    }

    public static <T extends Comparable<T>> T max(T a, T b) {
        return greaterThan(a, b) ? a : b;
    }

}
