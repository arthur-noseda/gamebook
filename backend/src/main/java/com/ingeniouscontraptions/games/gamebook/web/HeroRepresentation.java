package com.ingeniouscontraptions.games.gamebook.web;

import com.ingeniouscontraptions.games.gamebook.domain.Hero;
import com.ingeniouscontraptions.games.gamebook.domain.Score;

public class HeroRepresentation {

    private final Hero hero;

    public HeroRepresentation(Hero hero) {
        this.hero = hero;
    }

    public Score getSkill() {
        return hero.getSkill();
    }

    public Score getStamina() {
        return hero.getStamina();
    }

    public Score getLuck() {
        return hero.getLuck();
    }

    public String getGoldPieces() {
        return hero.getPouch().getGoldPieces().toString();
    }

    public int getNumberOfMeals() {
        return hero.getProvisions().getNumberOfMeals();
    }

    public boolean isDead() {
        return hero.isDead();
    }

}
