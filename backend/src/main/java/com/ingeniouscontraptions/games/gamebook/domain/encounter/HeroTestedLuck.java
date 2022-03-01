package com.ingeniouscontraptions.games.gamebook.domain.encounter;

import static com.ingeniouscontraptions.games.gamebook.domain.commons.Preconditions.notNull;

import com.ingeniouscontraptions.games.gamebook.domain.encounter.outcome.FinalAttackRoundOutcome;

public class HeroTestedLuck extends AttackRoundStateAdapter {

    private final AttackRound attackRound;

    private final FinalAttackRoundOutcome outcome;

    public HeroTestedLuck(AttackRound attackRound, FinalAttackRoundOutcome outcome) {
        this.attackRound = notNull(attackRound, "attackRound");
        this.outcome = notNull(outcome, "outcome");
    }

    @Override
    public boolean canMakeAdjustments() {
        return true;
    }

    @Override
    public void makeAdjustments() {
        outcome.makeAdjustments(attackRound.getHero(), attackRound.getMonster());
        attackRound.setState(new AttackRoundEnded(attackRound));
    }

    @Override
    public String getMessage() {
        return outcome.getMessage();
    }

}
