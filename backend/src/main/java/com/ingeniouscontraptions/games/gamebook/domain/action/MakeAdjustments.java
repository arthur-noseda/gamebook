package com.ingeniouscontraptions.games.gamebook.domain.action;

import com.ingeniouscontraptions.games.gamebook.domain.book.Action;
import com.ingeniouscontraptions.games.gamebook.domain.book.Adventure;
import com.ingeniouscontraptions.games.gamebook.domain.die.Die;
import com.ingeniouscontraptions.games.gamebook.domain.encounter.Encounter;

public class MakeAdjustments implements Action {

    public static final MakeAdjustments INSTANCE = new MakeAdjustments();

    private MakeAdjustments() {
    }

    @Override
    public boolean isAllowed(Adventure adventure) {
        Encounter encounter = adventure.getEncounter();
        return encounter != null && encounter.canMakeAdjustments();
    }

    @Override
    public void resolve(Adventure adventure, Die die) {
        Encounter encounter = adventure.getEncounter();
        encounter.makeAdjustments();
        if (encounter.canProceedToNextRound()) {
            encounter.nextRound(die);
        }
    }

}
