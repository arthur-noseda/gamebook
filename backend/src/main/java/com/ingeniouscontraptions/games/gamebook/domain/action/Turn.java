package com.ingeniouscontraptions.games.gamebook.domain.action;

import com.ingeniouscontraptions.games.gamebook.domain.book.Action;
import com.ingeniouscontraptions.games.gamebook.domain.book.Adventure;
import com.ingeniouscontraptions.games.gamebook.domain.book.EntryNumber;
import com.ingeniouscontraptions.games.gamebook.domain.die.Die;

public class Turn implements Action {

    private final EntryNumber number;

    private final Condition condition;

    private Turn(EntryNumber number, Condition condition) {
        this.number = number;
        this.condition = condition;
    }

    public static Turn to(EntryNumber number) {
        return new Turn(number, null);
    }

    public static Turn to(EntryNumber number, Condition condition) {
        return new Turn(number, condition);
    }

    @Override
    public boolean isAllowed(Adventure adventure) {
        return condition == null || condition.evaluate(adventure);
    }

    @Override
    public void resolve(Adventure adventure, Die die) {
        adventure.turnTo(number);
    }

}
