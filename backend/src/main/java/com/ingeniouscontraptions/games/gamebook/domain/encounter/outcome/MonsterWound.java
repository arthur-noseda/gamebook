package com.ingeniouscontraptions.games.gamebook.domain.encounter.outcome;

import com.ingeniouscontraptions.games.gamebook.domain.Hero;
import com.ingeniouscontraptions.games.gamebook.domain.Luck;
import com.ingeniouscontraptions.games.gamebook.domain.Monster;

public class MonsterWound implements IntermediateAttackRoundOutcome {

    @Override
    public String getMessage() {
        return "You have wounded your opponent.";
    }

    @Override
    public FinalAttackRoundOutcome change(Luck luck) {
        return luck == Luck.LUCKY ? new MonsterSevereWound() : new MonsterLightWound();
    }

    @Override
    public void makeAdjustments(Hero hero, Monster monster) {
        monster.getStamina().deduct(2);
    }

}
