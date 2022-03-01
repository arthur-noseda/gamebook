package com.ingeniouscontraptions.games.gamebook.domain.encounter;

import com.ingeniouscontraptions.games.gamebook.domain.Hero;
import com.ingeniouscontraptions.games.gamebook.domain.Monster;
import com.ingeniouscontraptions.games.gamebook.domain.die.Die;

public class AttackRound {

    private final Hero hero;

    private final Monster monster;

    private AttackRoundState state;

    AttackRound(Hero hero, Monster monster) {
        this.hero = hero;
        this.monster = monster;
        setState(new AttackRoundStarted(this));
    }

    boolean canRollAttackStrengths() {
        return state.canRollAttackStrengths();
    }

    void rollAttackStrengths(Die die) {
        state.rollAttackStrengths(die);
    }

    boolean mayTestLuck() {
        return state.mayTestLuck();
    }

    void testLuck(Die die) {
        state.testLuck(die);
    }

    boolean canMakeAdjustments() {
        return state.canMakeAdjustments();
    }

    void makeAdjustments() {
        state.makeAdjustments();
    }

    boolean canProceedToNextRound() {
        return state.canProceedToNextRound();
    }

    String getMessage() {
        return state.getMessage();
    }

    void setState(AttackRoundState state) {
        this.state = state;
    }

    Hero getHero() {
        return hero;
    }

    Monster getMonster() {
        return monster;
    }

}
