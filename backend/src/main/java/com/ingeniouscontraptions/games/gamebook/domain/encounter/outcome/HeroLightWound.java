package com.ingeniouscontraptions.games.gamebook.domain.encounter.outcome;

import com.ingeniouscontraptions.games.gamebook.domain.Hero;
import com.ingeniouscontraptions.games.gamebook.domain.Monster;

public class HeroLightWound implements FinalAttackRoundOutcome {

    @Override
    public String getMessage() {
        return "You have managed to avoid the full damage of the blow.";
    }

    @Override
    public void makeAdjustments(Hero hero, Monster monster) {
        hero.getStamina().deduct(1);
    }

}
