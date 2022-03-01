package com.ingeniouscontraptions.games.gamebook.domain;

import com.ingeniouscontraptions.games.gamebook.domain.die.Die;

public interface Creature {

    Score getSkill();

    Score getStamina();

    AttackStrength attackRoll(Die die);

    boolean isDead();

}
