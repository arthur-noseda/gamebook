package com.ingeniouscontraptions.games.gamebook.domain.encounter;

import com.ingeniouscontraptions.games.gamebook.domain.die.Die;

public interface AttackRoundState {

    boolean canRollAttackStrengths();

    void rollAttackStrengths(Die die);

    boolean mayTestLuck();

    void testLuck(Die die);

    boolean canMakeAdjustments();

    void makeAdjustments();

    boolean canProceedToNextRound();

    String getMessage();

}
