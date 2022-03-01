package com.ingeniouscontraptions.games.gamebook.domain.encounter;

import com.ingeniouscontraptions.games.gamebook.domain.die.Die;

public class AttackRoundStateAdapter implements AttackRoundState {

    @Override
    public boolean canRollAttackStrengths() {
        return false;
    }

    @Override
    public void rollAttackStrengths(Die die) {
        throw new IllegalStateException("You cannot roll attack strengths.");
    }

    @Override
    public boolean mayTestLuck() {
        return false;
    }

    @Override
    public void testLuck(Die die) {
        throw new IllegalStateException("You may not test your luck.");
    }

    @Override
    public boolean canMakeAdjustments() {
        return false;
    }

    @Override
    public void makeAdjustments() {
        throw new IllegalStateException("You cannot make adjustments.");
    }

    @Override
    public boolean canProceedToNextRound() {
        return false;
    }

    @Override
    public String getMessage() {
        throw new UnsupportedOperationException();
    }

}
