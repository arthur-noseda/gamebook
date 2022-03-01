package com.ingeniouscontraptions.games.gamebook.domain;

public class Score {

    private final int max;

    private int current;

    private Score(int max) {
        this.max = max;
        current = max;
    }

    public static Score of(int max) {
        return new Score(max);
    }

    public int getMax() {
        return max;
    }

    public int getCurrent() {
        return current;
    }

    public void deduct(int points) {
        current -= points;
    }

    public void add(int points) {
        current = Math.min(max, current + points);
    }

}
