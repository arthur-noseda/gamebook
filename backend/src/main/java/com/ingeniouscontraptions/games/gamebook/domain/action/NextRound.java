package com.ingeniouscontraptions.games.gamebook.domain.action;

import com.ingeniouscontraptions.games.gamebook.domain.book.Action;
import com.ingeniouscontraptions.games.gamebook.domain.book.Adventure;
import com.ingeniouscontraptions.games.gamebook.domain.die.Die;
import com.ingeniouscontraptions.games.gamebook.domain.encounter.Encounter;

public class NextRound implements Action {

    public static final NextRound INSTANCE = new NextRound();

    private NextRound() {
    }

    @Override
    public boolean isAllowed(Adventure adventure) {
        Encounter encounter = adventure.getEncounter();
        return encounter != null && encounter.canProceedToNextRound();
    }

    @Override
    public void resolve(Adventure adventure, Die die) {
        adventure.getEncounter().nextRound(die);
    }

}
