package com.ingeniouscontraptions.games.gamebook.domain.action;

import com.ingeniouscontraptions.games.gamebook.domain.Monster;
import com.ingeniouscontraptions.games.gamebook.domain.book.Action;
import com.ingeniouscontraptions.games.gamebook.domain.book.Adventure;
import com.ingeniouscontraptions.games.gamebook.domain.die.Die;
import com.ingeniouscontraptions.games.gamebook.domain.encounter.Encounter;

public class StartBattle implements Action {

    public static final StartBattle INSTANCE = new StartBattle();

    private StartBattle() {
    }

    @Override
    public boolean isAllowed(Adventure adventure) {
        Monster monster = adventure.getMonster();
        return monster != null && !monster.isDead() && adventure.getEncounter() == null;
    }

    @Override
    public void resolve(Adventure adventure, Die die) {
        if (!isAllowed(adventure)) {
            throw new IllegalStateException("You cannot start battle.");
        }
        Encounter encounter = new Encounter(adventure.getHero(), adventure.getMonster());
        encounter.nextRound(die);
        adventure.setEncounter(encounter);
    }

}
