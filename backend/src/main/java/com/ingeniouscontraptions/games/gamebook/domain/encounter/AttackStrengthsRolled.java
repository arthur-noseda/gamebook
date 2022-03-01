package com.ingeniouscontraptions.games.gamebook.domain.encounter;

import static com.ingeniouscontraptions.games.gamebook.domain.commons.Preconditions.notNull;

import com.ingeniouscontraptions.games.gamebook.domain.die.Die;
import com.ingeniouscontraptions.games.gamebook.domain.encounter.outcome.FinalAttackRoundOutcome;
import com.ingeniouscontraptions.games.gamebook.domain.encounter.outcome.IntermediateAttackRoundOutcome;

public class AttackStrengthsRolled extends AttackRoundStateAdapter {

    private final AttackRound attackRound;

    private final IntermediateAttackRoundOutcome outcome;

    public AttackStrengthsRolled(AttackRound attackRound, IntermediateAttackRoundOutcome outcome) {
        this.attackRound = notNull(attackRound, "attackRound");
        this.outcome = notNull(outcome, "outcome");
    }

    @Override
    public boolean mayTestLuck() {
        return true;
    }

    @Override
    public void testLuck(Die die) {
        FinalAttackRoundOutcome finalOutcome = outcome.change(attackRound.getHero().testLuck(die));
        attackRound.setState(new HeroTestedLuck(attackRound, finalOutcome));
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
