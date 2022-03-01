package com.ingeniouscontraptions.games.gamebook.domain.action;

import com.ingeniouscontraptions.games.gamebook.domain.book.Action;
import com.ingeniouscontraptions.games.gamebook.domain.book.Adventure;
import com.ingeniouscontraptions.games.gamebook.domain.die.Die;
import com.ingeniouscontraptions.games.gamebook.domain.encounter.Encounter;

public class TestLuck implements Action {

    public static final TestLuck INSTANCE = new TestLuck();

    private TestLuck() {
    }

    @Override
    public boolean isAllowed(Adventure adventure) {
        Encounter encounter = adventure.getEncounter();
        return encounter != null && encounter.mayTestLuck();
    }

    @Override
    public void resolve(Adventure adventure, Die die) {
        adventure.getEncounter().testLuck(die);
    }

}
