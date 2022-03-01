package com.ingeniouscontraptions.games.gamebook.domain.encounter.outcome;

import com.ingeniouscontraptions.games.gamebook.domain.Hero;
import com.ingeniouscontraptions.games.gamebook.domain.Monster;

public class HeroSevereWound implements FinalAttackRoundOutcome {

    @Override
    public String getMessage() {
        return "You have taken a more serious blow.";
    }

    @Override
    public void makeAdjustments(Hero hero, Monster monster) {
        hero.getStamina().deduct(3);
    }

}
