package com.ingeniouscontraptions.games.gamebook.domain.book;

import com.ingeniouscontraptions.games.gamebook.domain.die.Die;

public interface Action {

    boolean isAllowed(Adventure adventure);

    void resolve(Adventure adventure, Die die);

}
