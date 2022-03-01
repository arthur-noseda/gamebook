package com.ingeniouscontraptions.games.gamebook.domain.encounter.outcome;

import com.ingeniouscontraptions.games.gamebook.domain.Hero;
import com.ingeniouscontraptions.games.gamebook.domain.Luck;
import com.ingeniouscontraptions.games.gamebook.domain.Monster;

public class HeroWound implements IntermediateAttackRoundOutcome {

    @Override
    public String getMessage() {
        return "Your opponent has wounded you.";
    }

    @Override
    public FinalAttackRoundOutcome change(Luck luck) {
        return luck == Luck.LUCKY ? new HeroLightWound() : new HeroSevereWound();
    }

    @Override
    public void makeAdjustments(Hero hero, Monster monster) {
        hero.getStamina().deduct(2);
    }

}
