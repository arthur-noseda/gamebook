package com.ingeniouscontraptions.games.gamebook.domain.action;

import com.ingeniouscontraptions.games.gamebook.domain.Hero;
import com.ingeniouscontraptions.games.gamebook.domain.book.Action;
import com.ingeniouscontraptions.games.gamebook.domain.book.Adventure;
import com.ingeniouscontraptions.games.gamebook.domain.die.Die;

public class EatProvisions implements Action {

    private boolean done;

    @Override
    public boolean isAllowed(Adventure adventure) {
        return !done;
    }

    @Override
    public void resolve(Adventure adventure, Die die) {
        Hero hero = adventure.getHero();
        hero.eat(hero.getProvisions().take());
        done = true;
    }

}
