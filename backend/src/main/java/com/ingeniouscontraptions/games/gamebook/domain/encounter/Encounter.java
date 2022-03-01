package com.ingeniouscontraptions.games.gamebook.domain.encounter;

import java.util.ArrayList;
import java.util.List;

import com.ingeniouscontraptions.games.gamebook.domain.Hero;
import com.ingeniouscontraptions.games.gamebook.domain.Monster;
import com.ingeniouscontraptions.games.gamebook.domain.die.Die;

public class Encounter {

    private final Hero hero;

    private final Monster monster;

    private final List<AttackRound> history;

    private AttackRound attackRound;

    public Encounter(Hero hero, Monster monster) {
        this.hero = hero;
        this.monster = monster;
        history = new ArrayList<>();
    }

    public int getRoundNumber() {
        return history.size() + 1;
    }

    public boolean canProceedToNextRound() {
        return attackRound == null || attackRound.canProceedToNextRound();
    }

    public void nextRound(Die die) {
        if (attackRound != null) {
            if (!attackRound.canProceedToNextRound()) {
                throw new IllegalStateException("You cannot proceed to the next round.");
            }
            history.add(attackRound);
        }
        attackRound = new AttackRound(hero, monster);
        attackRound.rollAttackStrengths(die);
    }

    public boolean mayTestLuck() {
        return attackRound.mayTestLuck();
    }

    public void testLuck(Die die) {
        attackRound.testLuck(die);
    }

    public boolean canMakeAdjustments() {
        return attackRound != null && attackRound.canMakeAdjustments();
    }

    public void makeAdjustments() {
        attackRound.makeAdjustments();
    }

    public boolean hasStarted() {
        return attackRound != null;
    }

    public boolean hasEnded() {
        return attackRound != null && !attackRound.canProceedToNextRound();
    }

    public String getMessage() {
        return attackRound.getMessage();
    }

}
