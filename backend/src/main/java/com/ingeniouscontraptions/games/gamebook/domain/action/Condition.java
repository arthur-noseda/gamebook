package com.ingeniouscontraptions.games.gamebook.domain.action;

import com.ingeniouscontraptions.games.gamebook.domain.book.Adventure;

public interface Condition {

    boolean evaluate(Adventure adventure);

}
