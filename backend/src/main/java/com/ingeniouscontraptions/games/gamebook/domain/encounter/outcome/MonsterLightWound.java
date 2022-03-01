package com.ingeniouscontraptions.games.gamebook.domain.encounter.outcome;

import com.ingeniouscontraptions.games.gamebook.domain.Hero;
import com.ingeniouscontraptions.games.gamebook.domain.Monster;

public class MonsterLightWound implements FinalAttackRoundOutcome {

    @Override
    public String getMessage() {
        return "You have inflicted a mere graze.";
    }

    @Override
    public void makeAdjustments(Hero hero, Monster monster) {
        monster.getStamina().deduct(1);
    }

}
