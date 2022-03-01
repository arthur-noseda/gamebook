package com.ingeniouscontraptions.games.gamebook.domain;

public class Ration implements Meal {

    public int getStaminaPointsIntake(boolean alreadyEaten) {
        return alreadyEaten ? 1 : 2;
    }

}
