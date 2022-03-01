package com.ingeniouscontraptions.games.gamebook.domain.encounter.outcome;

import com.ingeniouscontraptions.games.gamebook.domain.Hero;
import com.ingeniouscontraptions.games.gamebook.domain.Monster;

public class MonsterSevereWound implements FinalAttackRoundOutcome {

    @Override
    public String getMessage() {
        return "You have inflicted a severe wound.";
    }

    @Override
    public void makeAdjustments(Hero hero, Monster monster) {
        monster.getStamina().deduct(4);
    }

}
