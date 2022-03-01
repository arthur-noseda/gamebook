package com.ingeniouscontraptions.games.gamebook.domain.encounter;

public class AttackRoundEnded extends AttackRoundStateAdapter {

    private final AttackRound attackRound;

    public AttackRoundEnded(AttackRound attackRound) {
        this.attackRound = attackRound;
    }

    @Override
    public boolean canProceedToNextRound() {
        return !attackRound.getHero().isDead() && !attackRound.getMonster().isDead();
    }

    @Override
    public String getMessage() {
        return "The round has ended.";
    }

}
