package com.ingeniouscontraptions.games.gamebook.domain.action;

import com.ingeniouscontraptions.games.gamebook.domain.book.Adventure;

public class EntryCleared implements Condition {

    public static final EntryCleared INSTANCE = new EntryCleared();

    @Override
    public boolean evaluate(Adventure adventure) {
        return adventure.getMonster().isDead();
    }

}
