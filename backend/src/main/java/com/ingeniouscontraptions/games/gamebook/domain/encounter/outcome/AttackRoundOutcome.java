package com.ingeniouscontraptions.games.gamebook.domain.encounter.outcome;

import com.ingeniouscontraptions.games.gamebook.domain.Hero;
import com.ingeniouscontraptions.games.gamebook.domain.Monster;

public interface AttackRoundOutcome {

    String getMessage();

    void makeAdjustments(Hero hero, Monster monster);

}
