package com.ingeniouscontraptions.games.gamebook.domain;

import com.ingeniouscontraptions.games.gamebook.domain.die.Die;

public class Monster implements Creature {

    private final Score skill;

    private final Score stamina;

    public Monster(Score initialSkill, Score initialStamina) {
        skill = initialSkill;
        stamina = initialStamina;
    }

    @Override
    public Score getSkill() {
        return skill;
    }

    @Override
    public Score getStamina() {
        return stamina;
    }

    @Override
    public AttackStrength attackRoll(Die die) {
        return new AttackStrength(skill.getCurrent() + die.roll() + die.roll());
    }

    @Override
    public boolean isDead() {
        return stamina.getCurrent() <= 0;
    }

}
