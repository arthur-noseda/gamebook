package com.ingeniouscontraptions.games.gamebook.domain.encounter.outcome;

import com.ingeniouscontraptions.games.gamebook.domain.Luck;

public interface IntermediateAttackRoundOutcome extends AttackRoundOutcome {

    FinalAttackRoundOutcome change(Luck luck);

}
