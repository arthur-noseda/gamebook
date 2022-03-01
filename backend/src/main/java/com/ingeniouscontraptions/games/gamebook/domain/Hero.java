package com.ingeniouscontraptions.games.gamebook.domain;

import com.ingeniouscontraptions.games.gamebook.domain.die.Die;

public class Hero extends Monster {

    private final Score luck;

    private Pouch pouch;

    private Provisions provisions;

    private boolean alreadyEaten;

    private Hero(Score skill, Score stamina, Score luck, Pouch pouch, Provisions provisions) {
        super(skill, stamina);
        this.luck = luck;
        this.pouch = pouch;
        this.provisions = provisions;
    }

    public static Hero warrior(Die die) {
        return new Hero(rollSkill(die), rollStamina(die), rollLuck(die), Pouch.of(GoldPieces.of(20)), Provisions.of(2));
    }

    private static Score rollSkill(Die die) {
        return Score.of(6 + die.roll());
    }

    private static Score rollStamina(Die die) {
        return Score.of(12 + die.roll() + die.roll());
    }

    private static Score rollLuck(Die die) {
        return Score.of(6 + die.roll());
    }

    public Score getLuck() {
        return luck;
    }

    public Luck testLuck(Die die) {
        int roll = die.roll() + die.roll();
        Luck outcome = roll <= luck.getCurrent() ? Luck.LUCKY : Luck.UNLUCKY;
        luck.deduct(1);
        return outcome;
    }

    public Pouch getPouch() {
        return pouch;
    }

    public Provisions getProvisions() {
        return provisions;
    }

    public void eat(Meal meal) {
        getStamina().add(meal.getStaminaPointsIntake(alreadyEaten));
        alreadyEaten = true;
    }

    public boolean hasAlreadyEaten() {
        return alreadyEaten;
    }

}
