package com.ingeniouscontraptions.games.gamebook.domain.encounter;

public class Draw extends AttackRoundStateAdapter {

    @Override
    public boolean canProceedToNextRound() {
        return true;
    }

    @Override
    public String getMessage() {
        return "You have avoided each other's blow.";
    }

}
